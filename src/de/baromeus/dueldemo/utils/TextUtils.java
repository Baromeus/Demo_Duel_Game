package de.baromeus.dueldemo.utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextUtils {

    private static HashMap<JTextArea, List<MyThread>> textList = new HashMap<>();

    private static MyThread work(JTextArea ta, String text, int speed){
        return new MyThread(() -> {
            for (int i = 0; i < text.length(); i++) {
                if(Thread.currentThread().isInterrupted()){
                    MyThread thread = (MyThread) Thread.currentThread();
                    if(thread.cause instanceof SkipInterruption){
                        ta.append(text.substring(i));
                        break;
                    }
                    if(thread.cause instanceof  AbortIntertuption){
                        return;
                    }
                }

                ta.append(text.substring(i, i + 1));
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    MyThread thread = (MyThread) Thread.currentThread();
                    if(!(thread.cause instanceof SkipInterruption || thread.cause instanceof AbortIntertuption))
                        throw new RuntimeException(e);
                    else
                        Thread.currentThread().interrupt();
                }
            }

            List<MyThread> buffer = textList.get(ta);

            if (buffer != null) {
                buffer.remove(Thread.currentThread());
                if (buffer.isEmpty()) {
                    textList.remove(ta);
                } else {
                    buffer.get(0).start();
                }
            }
        });
    }
    public static synchronized void addTextSlow(JTextArea ta, String text, int speed){
        MyThread t = work(ta, text, speed);

        List<MyThread> buffer = textList.get(ta);

        if(buffer == null || buffer.isEmpty() || buffer.get(0).isInterrupted()){
            buffer = new ArrayList<>();
            buffer.add(t);
            textList.put(ta,buffer);
            t.start();
        }else {
            buffer.add(t);
        }
    }

    public static synchronized void textSkip(JTextArea ta){
        List<MyThread> buffer = textList.get(ta);

        if(buffer != null){
            buffer.get(0).interrupt(new SkipInterruption());
        }
    }

    public static synchronized void textAbort(JTextArea ta){
        List<MyThread> buffer = textList.get(ta);

        if(buffer != null){
            buffer.forEach(t -> t.interrupt(new AbortIntertuption()));
            buffer.clear();
        }
    }

    private static class MyThread extends Thread{
        InterruptedException cause = null;
        MyThread(){
            super();
        }

        MyThread(Runnable run){
            super(run);
        }

        public void interrupt(InterruptedException exception){
            cause = exception;
            interrupt();
        }
    }

    private static class SkipInterruption extends InterruptedException{
        SkipInterruption(){
            super();
        }
    }

    private static class AbortIntertuption extends InterruptedException{
        AbortIntertuption(){
            super();
        }
    }
}




