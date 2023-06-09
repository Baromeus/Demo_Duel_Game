package de.baromeus.dueldemo.scenes;

import de.baromeus.dueldemo.classes.CharacterPanel;
import de.baromeus.dueldemo.classes.ImagePanel;
import de.baromeus.dueldemo.classes.Weapon;
import de.baromeus.dueldemo.enums.Shop;
import de.baromeus.dueldemo.interfaces.GameScene;
import de.baromeus.dueldemo.interfaces.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static de.baromeus.dueldemo.GameWindow.*;
import static de.baromeus.dueldemo.main.player;
import static de.baromeus.dueldemo.utils.ImageUtils.IMAGE_SIDE;
import static de.baromeus.dueldemo.utils.ImageUtils.getImage;

public class ShopScene implements GameScene {
    private final JPanel top;
    private ImagePanel center;
    private CharacterPanel playerPanel;
    private CharacterPanel enemyPanel;
    private final JPanel bottom;
    private final JLabel title;
    private final ArrayList<JButton> buttons;
    private final Map<JButton, Item> itemButtons;
    private int mode = 0; //0 nothing, 1 buy, 2 sell
    private Shop typ = Shop.TOWN;

    public ShopScene(String label, Shop t){
        typ = t;
        top = new JPanel();
        center = new ImagePanel();
        playerPanel = player.getPlayerPanel();
        enemyPanel = new CharacterPanel();
        bottom = new JPanel();

        playerPanel.addImage(getImage(IMAGE_SIDE));
        enemyPanel.addImage(getImage(IMAGE_SIDE));

        top.setPreferredSize(DTop);
        center.setPreferredSize(DCenter);
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        playerPanel.setPreferredSize(DSide);
        enemyPanel.setPreferredSize(DSide);
        bottom.setPreferredSize(DBottom);

        title = new JLabel(label);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        buttons = new ArrayList<>();
        itemButtons = new HashMap<>();

        top.add(title, BorderLayout.CENTER);
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

    public void setTitle(String title){
        this.title.setText(title);
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

    public void clearButtons(){
        buttons.clear();
        bottom.removeAll();
        bottom.revalidate();
    }

    public void clearItems(){
        itemButtons.clear();
        center.removeAll();
        center.revalidate();
    }

    public void addBackground(Image bg){
        center.addImage(bg);
    }

    public JButton addItem(Item item){
        if(item == null) return null;

        JButton temp = new JButton(item.getName());

        temp.addActionListener(e ->{
            if(mode == 1){
                var it = itemButtons.get(temp);
                var price = it.getPrice();
                var money = player.getMoney();
                if(money > price){
                    money -= price;
                    player.setMoney(money);
                    player.addToInventory(it);
                }else{
                    JOptionPane.showConfirmDialog(null,"Nicht genug Geld!");
                }
            }
            if(mode == 2){
                var it = itemButtons.get(temp);
                var price = it.getPrice();
                var money = player.getMoney();
                money += price;
                player.setMoney(money);
                player.removeFromInventory(it);
                itemButtons.remove(temp);
                setButtons();
            }
        });

        var tooltip = "Preis: " + item.getPrice();
        if(item instanceof Weapon)
            tooltip+= " | Schaden +";
        else
            tooltip+= " | Abwehr +";
        tooltip+= item.getValue();
        temp.setToolTipText(tooltip);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        itemButtons.put(temp,item);
        setButtons();
        return temp;
    }

    private void setButtons(){
        center.removeAll();

        itemButtons.forEach((btn, it) -> center.add(btn));

        center.validate();
        center.repaint();
        center.revalidate();
    }
    public void setMode(int mode){
        this.mode = mode;
    }
    @Override
    public Shop getTyp(){
        return typ;
    }
}
