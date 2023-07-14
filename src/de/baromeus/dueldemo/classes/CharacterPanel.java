package de.baromeus.dueldemo.classes;

import javax.swing.*;
import java.awt.*;

import static de.baromeus.dueldemo.MainFunctions.callInventory;
import static de.baromeus.dueldemo.utils.ImageUtils.*;

public class CharacterPanel extends ImagePanel{
    JLabel name;
    JLabel hp;
    JLabel money;
    JLabel reputation;
    JLabel silhouette;
    JButton btnInventory;
//    Observer playerObserver;
    Player player;

    public CharacterPanel(){
        super();



//        playerObserver = (o, arg) -> {
//            Player p = (Player) o;
//            this.hp.setText("HP: " + p.getHp());
//            this.name.setText(p.getName());
//            this.money.setText("G:  " + p.getMoney() + " Taler");
//            this.reputation.setText("Rp: " + p.getReputation());
//            if(Objects.equals(p.getGender(), "Mann")){
//                siluette.setIcon(getImageIcon(IMAGE_MALE));
//            }else{
//                siluette.setIcon(getImageIcon(IMAGE_FEMALE));
//            };
//
//            this.invalidate();
//        };


        this.setLayout(null);

        name = new JLabel();
        name.setText("placeholder");
        name.setForeground(new Color(220,220,220));
        name.setBounds(0,0,400,40);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        name.setVerticalTextPosition(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);

        hp = new JLabel();
        hp.setForeground(new Color(220,220,220));
        hp.setBounds(120, 520, 300, 20);

        money = new JLabel();
        money.setForeground(new Color(220,220,220));
        money.setBounds(120, 540, 300, 20);

        reputation = new JLabel();
        reputation.setForeground(new Color(220,220,220));
        reputation.setBounds(120, 560, 300, 20);

        btnInventory = new JButton("Inventar");
        btnInventory.addActionListener(e -> callInventory());
        btnInventory.setBounds(250,560, 100,20);

        silhouette = new JLabel();
        silhouette.setBounds(5,0,400,610);

//        siluette.setPreferredSize(DSide);
        this.add(name, BorderLayout.NORTH);
        this.add(hp,BorderLayout.SOUTH);
        this.add(money,BorderLayout.SOUTH);
        this.add(reputation,BorderLayout.SOUTH);
        this.add(silhouette);
        this.add(btnInventory);
        invalidate();
    }

    public void setPlayer(Player p){
        // Entferne alle Listener, wenn zuvor ein Player gesetzt war
        if(player != null)
            player.propertyName().removeAllListener();
        // Übergabe des Spielers
        player = p;

        // Ist der neue Player null, so entferne alle werte und beende die Routine vorzeitig
        if(player == null){
            name.setText("");
            hp.setText("");
            money.setText("");
            reputation.setText("");
            silhouette.setIcon(null);
            return;
        }

        // Initialwerte
        this.name.setText(player.getName());
        setHP(player.getHp(), player.maxHP());
        setMoney(player.getMoney());
        setReputation(player.getReputation());
        setSilhouette(player.getMale());

       // Übername durch Listener
        player.propertyName().addListener((o, n) -> this.name.setText(n));
        player.propertyHP().addListener((o, n) -> setHP(n, player.maxHP()));
        player.propertyMoney().addListener((o,n) -> setMoney(n));
        player.propertyReputation().addListener((o,n) -> setReputation(n));
        player.propertyMale().addListener((o,n) -> setSilhouette(n));
    }
    private void setHP(int aktuell, int max){
        hp.setText("HP:   " + aktuell + "/" + max);
    }
    private void setMoney(int aktuell){
        money.setText("Geld: " + aktuell + " Taler");
    }
    private void setReputation(int aktuell){
        reputation.setText("Reputation: " + aktuell);
    }
    private void setSilhouette(Boolean aktuell){
        if(aktuell){
            silhouette.setIcon(getImageIcon(IMAGE_MALE));
        }else{
            silhouette.setIcon(getImageIcon(IMAGE_FEMALE));
        };
    }

//    public void setName(String label){
//        name.setText(label);
//        this.invalidate();
//    }

//    public void setSiluette(ImageIcon character){
//        siluette.setIcon(character);
//        this.invalidate();
//    }

//    public void setHP(int actual, int max){
//        if(hp == null){
//            hp = new JLabel();
//            hp.setForeground(new Color(220,220,220));
//            hp.setBounds(120, 520, 300, 20);
//            this.add(hp,BorderLayout.SOUTH);
//        }
//        hp.setText("HP: " + actual + "/" + max);
//        this.invalidate();
//    }

//    public void setMoney(int m){
//        if(money == null){
//            money = new JLabel();
//            money.setForeground(new Color(220,220,220));
//            money.setBounds(
//                    120, 540, 300, 20);
//            this.add(money,BorderLayout.SOUTH);
//        }
//        money.setText("G : " + m + " Taler");
//        this.invalidate();
//    }

//    public void setReputation(String r){
//        if(reputation == null){
//            reputation = new JLabel();
//            reputation.setForeground(new Color(220,220,220));
//            reputation.setBounds(120, 560, 300, 20);
//            this.add(reputation,BorderLayout.SOUTH);
//        }
//        reputation.setText("Rep.: " + r);
//        this.add(btnInventory,BorderLayout.SOUTH);
//        this.invalidate();
//    }

//    public int getMoney(){
//        var s1 = money.getText();
//        s1 = s1.substring(4, s1.length()-6);
//        return Integer.parseInt(s1);
//    }
}
