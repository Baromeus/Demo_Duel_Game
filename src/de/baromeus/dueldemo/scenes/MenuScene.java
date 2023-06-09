package de.baromeus.dueldemo.scenes;

import de.baromeus.dueldemo.classes.CharacterPanel;
import de.baromeus.dueldemo.classes.ImagePanel;
import de.baromeus.dueldemo.enums.Shop;
import de.baromeus.dueldemo.interfaces.GameScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static de.baromeus.dueldemo.GameWindow.*;
import static de.baromeus.dueldemo.main.player;
import static de.baromeus.dueldemo.utils.ImageUtils.IMAGE_SIDE;
import static de.baromeus.dueldemo.utils.ImageUtils.getImage;

public class MenuScene implements GameScene {
    private final JPanel top;
    private ImagePanel center;
    private CharacterPanel playerPanel;
    private CharacterPanel enemyPanel;
    private final JPanel bottom;
    private final JLabel title;
    private final ArrayList<JButton> buttons;
    private Shop typ = Shop.TOWN;

    public MenuScene(String label){
        top = new JPanel();
        center = new ImagePanel();
        playerPanel = player.getPlayerPanel();
        enemyPanel = new CharacterPanel();
        bottom = new JPanel();

        playerPanel.addImage(getImage(IMAGE_SIDE));
        enemyPanel.addImage(getImage(IMAGE_SIDE));

        top.setPreferredSize(DTop);
        center.setPreferredSize(DCenter);
        playerPanel.setPreferredSize(DSide);
        enemyPanel.setPreferredSize(DSide);
        bottom.setPreferredSize(DBottom);

        title = new JLabel(label);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        buttons = new ArrayList<>();

        top.add(title, BorderLayout.CENTER);
    }

    public JButton addButton(String label){
        JButton temp = new JButton(label);
        buttons.add(temp);
        bottom.removeAll();

        buttons.forEach(bottom::add);

        bottom.validate();
        bottom.repaint();
        bottom.revalidate();

        return temp;
    }

    public void changeTitle(String label){
        title.setText(label);
    }

    public void addBackground(Image bg){
        center.addImage(bg);
    }

    public void addLeftBackground(Image bg){
        playerPanel.addImage(bg);
    }

    public void addRightBackground(Image bg){
        enemyPanel.addImage(bg);
    }

    public void clearButtons(){
        buttons.clear();
        bottom.removeAll();
        bottom.validate();
        bottom.repaint();
    }

    @Override
    public JPanel getTop() {
        return top;
    }

    @Override
    public JPanel getCenter() {
        return center;
    }

    @Override
    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    @Override
    public JPanel getEnemyPanel() {
        return enemyPanel;
    }

    @Override
    public JPanel getBottom() {
        return bottom;
    }

    @Override
    public void keyReact(KeyEvent e) {

    }

    @Override
    public Shop getTyp(){
        return typ;
    }
}
