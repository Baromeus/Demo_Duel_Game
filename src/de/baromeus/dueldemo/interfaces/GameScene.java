package de.baromeus.dueldemo.interfaces;

import javax.swing.*;
import java.awt.event.KeyEvent;

public interface GameScene {
    JPanel getTop();
    JPanel getCenter();
    JPanel getPlayerPanel();
    JPanel getEnemyPanel();
    JPanel getBottom();
    void keyReact(KeyEvent e);
}
