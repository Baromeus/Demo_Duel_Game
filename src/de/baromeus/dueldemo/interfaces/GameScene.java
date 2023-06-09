package de.baromeus.dueldemo.interfaces;

import de.baromeus.dueldemo.enums.Shop;

import javax.swing.*;
import java.awt.event.KeyEvent;

public interface GameScene {
    JPanel getTop();
    JPanel getCenter();
    JPanel getPlayerPanel();
    JPanel getEnemyPanel();
    JPanel getBottom();
    Shop getTyp();
    void keyReact(KeyEvent e);
}
