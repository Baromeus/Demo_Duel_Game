package de.baromeus.dueldemo.classes;

import de.baromeus.dueldemo.enums.EStats;
import de.baromeus.dueldemo.interfaces.Item;
import de.baromeus.dueldemo.utils.Property;

import java.util.ArrayList;

import static de.baromeus.dueldemo.utils.ImageUtils.*;

public class Player extends Human implements de.baromeus.dueldemo.interfaces.Player {
    private EStats focus;
    private Stats stats;
    private int difficulty;
    private CharacterPanel character;
    private ArrayList<Item> inventory;
    private Property<Integer> money = new Property<>(0);
    private Property<Integer> rep = new Property<>(0);

    public Player(){
        super();
        name.set("No Name");
        hp.set(0);
        character = new CharacterPanel();
//        character.setName(name);
        character.addImage(getImage(IMAGE_SIDE));
        character.setPlayer(this);
        inventory = new ArrayList<>();
//        addObserver(character.playerObserver);
    }

    public void setValues(int difficulty, int str, int vit, int res, int agi, int intel, int per, int luck){
        this.difficulty = difficulty;
        strength.set(str);
        vitality.set(vit);
        resilience.set(res);
        agility.set(agi);
        intelligence.set(intel);
        perception.set(per);
        this.luck.set(luck);
//        character.setHP(maxHP(),maxHP());
//        character.setReputation("Unbekannt");
//        character.setMoney(250 + 50 * luck);
        money.set(250 + 50 * luck);
        rep.set(10);
        hp.set(maxHP());
    }

    public CharacterPanel getPlayerPanel(){
        return character;
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

//    public void setGender(Boolean isMale){
//        male = isMale;
//        if(male)
//            character.setSiluette(getImageIcon(IMAGE_MALE));
//        else
//            character.setSiluette(getImageIcon(IMAGE_FEMALE));
//        character.invalidate();
//    }

    public void addToInventory(Item item){
        inventory.add(item);
    }

    public void removeFromInventory(Item item){
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    @Override
    public void setFocus(EStats stat) {
        focus = stat;
    }
    @Override
    public void startFight() {
       stats.fights++;
    }
    @Override
    public Stats getStatisitc() {
        return stats;
    }
    public int getMoney(){
        return money.get();
    }
    public Property<Integer> propertyMoney(){
        return money;
    }
    public void setMoney(int value){
        money.set(value);
    }
    public int getReputation(){
        return rep.get();
    }
    public Property<Integer> propertyReputation(){
        return rep;
    }
    public void setReputation(int value){
        rep.set(value);
    }
}
