package de.baromeus.dueldemo.scenes;

import de.baromeus.dueldemo.classes.CharacterPanel;
import de.baromeus.dueldemo.classes.ImagePanel;
import de.baromeus.dueldemo.classes.Lifeform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static de.baromeus.dueldemo.GameWindow.*;
import static de.baromeus.dueldemo.main.player;
import static de.baromeus.dueldemo.utils.ImageUtils.IMAGE_SIDE;
import static de.baromeus.dueldemo.utils.ImageUtils.getImage;
import static de.baromeus.dueldemo.utils.TextUtils.*;

public class GameScene implements de.baromeus.dueldemo.interfaces.GameScene {
    private JPanel top;
    private ImagePanel center;
    private CharacterPanel playerPanel;
    private CharacterPanel enemyPanel;
    private JPanel bottom;
    private JLabel title;
    private JTextArea centerText;
    private ArrayList<JButton> buttons;
    private Lifeform enemy = null;

    public GameScene(String label){
        top = new JPanel();
        center = new ImagePanel();
        playerPanel = player.getPlayerPanel();
        enemyPanel = new CharacterPanel();
        bottom = new JPanel();

        top.setPreferredSize(DTop);
        center.setPreferredSize(DCenter);
        playerPanel.setPreferredSize(DSide);
        enemyPanel.setPreferredSize(DSide);
        bottom.setPreferredSize(DBottom);

        playerPanel.addImage(getImage(IMAGE_SIDE));
        enemyPanel.addImage(getImage(IMAGE_SIDE));

        top.setLayout(new BorderLayout());
        center.setLayout(new BorderLayout());
        bottom.setLayout(new FlowLayout());

        title = new JLabel(label);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        centerText = new JTextArea();
        centerText.setMargin(new Insets(20,20,20,20));
        centerText.setFocusable(false);
        centerText.setEditable(false);
        buttons = new ArrayList<>();

        top.add(title, BorderLayout.CENTER);
        center.add(centerText, BorderLayout.CENTER);
    }

    public JButton addButton(String label){
        JButton temp = new JButton(label);
        buttons.add(temp);
        bottom.removeAll();

        buttons.forEach(btn -> {
            bottom.add(btn);
        });

        bottom.validate();
        bottom.repaint();

        return temp;
    }

    public void clearButtons(){
        buttons.clear();
        bottom.removeAll();
        bottom.validate();
        bottom.repaint();
    }

    public void clearText(){
        centerText.setText("");
        center.revalidate();
    }

    public void appendText(String text){
        addTextSlow(centerText, text + "\n", 50);
    }

    public void abortText(){
        textAbort(centerText);
    }

    public void skipText(){
        textSkip(centerText);
    }

    public void start(){

    }

    public void setEnemy(Lifeform en){
        enemyPanel.setName(en.getName());
        enemyPanel.setHP(en.getHp(),en.getMaxHP());
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
        switch (e.getKeyCode()){
            case KeyEvent.VK_ENTER -> skipText();
        }
    }
}
