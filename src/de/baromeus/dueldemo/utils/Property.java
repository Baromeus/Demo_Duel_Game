package de.baromeus.dueldemo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Property <T> {
    private final List<BiConsumer<T,T>> listener = new ArrayList<>();
    private T t;
    public Property(){

    }
    public Property(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }
    public void set(T t){
        if(Objects.equals(this.t, t))
            return;
        listener.forEach(f -> f.accept(this.t, t));
        this.t = t;
    }
    public void addListener(BiConsumer<T,T> function){
        listener.add(function);
    }
    public void removeListener(BiConsumer<T,T> function){
        listener.remove(function);
    }
    public void removeAllListener(){
        listener.clear();
    }
}
