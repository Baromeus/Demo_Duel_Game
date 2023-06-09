package de.baromeus.dueldemo;

import de.baromeus.dueldemo.interfaces.GameScene;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    public static final Dimension DWindow = new Dimension(1600, 800);
    public static final Dimension DTop = new Dimension(1600, 40);
    public static final Dimension DCenter = new Dimension(800, 610);
    public static final Dimension DSide = new Dimension(400, 610);
    public static final Dimension DBottom = new Dimension(1600, 150);
    JFrame window;
    JPanel top;
    JPanel center;
    JPanel left;
    JPanel right;
    JPanel bottom;

    private GameScene gs;

    GameWindow(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispater);
        window = new JFrame("DemoGame");
        window.setSize(DWindow);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(new BorderLayout());

        top = new JPanel();
        center = new JPanel();
        left = new JPanel();
        right = new JPanel();
        bottom = new JPanel();

        top.setPreferredSize(DTop);
        center.setPreferredSize(DCenter);
        left.setPreferredSize(DSide);
        right.setPreferredSize(DSide);
        bottom.setPreferredSize(DBottom);

        top.setLayout(new BorderLayout());
        center.setLayout(new BorderLayout());
        left.setLayout(new BorderLayout());
        right.setLayout(new BorderLayout());
        bottom.setLayout(new BorderLayout());

        top.setBackground(Color.white);
        bottom.setBackground(Color.white);
        left.setBackground(Color.white);
        right.setBackground(Color.white);
        center.setBackground(new Color(240,240,240));

        window.add(top, BorderLayout.NORTH);
        window.add(center, BorderLayout.CENTER);
        window.add(left, BorderLayout.WEST);
        window.add(right, BorderLayout.EAST);
        window.add(bottom, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
    }

    public GameScene getGameScene(){
        return gs;
    }

    public void addGameScene(GameScene gameScene){
        gs = gameScene;
        top.removeAll();
        center.removeAll();
        right.removeAll();
        left.removeAll();
        bottom.removeAll();

        top.add(gs.getTop(), BorderLayout.CENTER);
        center.add(gs.getCenter(), BorderLayout.CENTER);
        left.add(gs.getPlayerPanel(),BorderLayout.CENTER);
        right.add(gs.getEnemyPanel(),BorderLayout.CENTER);
        bottom.add(gs.getBottom(),BorderLayout.CENTER);

        window.validate();
        window.repaint();
        window.revalidate();

        if(gs instanceof de.baromeus.dueldemo.scenes.GameScene){
            ((de.baromeus.dueldemo.scenes.GameScene) gs).start();
        }
    }

    private final KeyEventDispatcher dispater = e -> {
        if(gs != null){
            gs.keyReact(e);
        }
        return false;
    };
}
