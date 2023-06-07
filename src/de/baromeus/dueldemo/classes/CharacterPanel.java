package de.baromeus.dueldemo.classes;

import javax.swing.*;
import java.awt.*;

import static de.baromeus.dueldemo.MainFunctions.callInventory;

public class CharacterPanel extends ImagePanel{
    JLabel name;
    JLabel hp;
    JLabel money;
    JLabel reputation;
    JLabel siluette;

    JButton btnInventory;

    public CharacterPanel(){
        super();
        this.setLayout(null);
        name = new JLabel();
        name.setForeground(new Color(220,220,220));
        siluette = new JLabel();

        name.setBounds(0,0,400,40);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        name.setVerticalTextPosition(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        siluette.setBounds(5,0,400,610);

//        siluette.setPreferredSize(DSide);
        this.add(name, BorderLayout.NORTH);
        this.add(siluette);
    }

    public void setName(String label){
        name.setText(label);
        this.invalidate();
    }

    public void setSiluette(ImageIcon character){
        siluette.setIcon(character);
        this.invalidate();
    }

    public void setHP(int actual, int max){
        if(hp == null){
            hp = new JLabel();
            hp.setForeground(new Color(220,220,220));
            hp.setBounds(120, 520, 300, 20);
            this.add(hp,BorderLayout.SOUTH);
        }
        hp.setText("HP: " + actual + "/" + max);
        this.invalidate();
    }

    public void setMoney(int m){
        if(money == null){
            money = new JLabel();
            money.setForeground(new Color(220,220,220));
            money.setBounds(
                    120, 540, 300, 20);
            this.add(money,BorderLayout.SOUTH);
        }
        money.setText("G : " + m + " Taler");
        this.invalidate();
    }

    public void setReputation(String r){
        if(reputation == null){
            reputation = new JLabel();
            reputation.setForeground(new Color(220,220,220));
            reputation.setBounds(120, 560, 300, 20);
            this.add(reputation,BorderLayout.SOUTH);
        }
        reputation.setText("Rep.: " + r);
        btnInventory = new JButton("Inventar");
        btnInventory.addActionListener(e -> callInventory());
        btnInventory.setBounds(250,560, 100,20);
        this.add(btnInventory,BorderLayout.SOUTH);
        this.invalidate();
    }

    public int getMoney(){
        return Integer.parseInt(money.getText());
    }
}
