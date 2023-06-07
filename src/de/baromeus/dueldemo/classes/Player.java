package de.baromeus.dueldemo.classes;

import de.baromeus.dueldemo.enums.EStats;
import de.baromeus.dueldemo.interfaces.Item;

import java.util.ArrayList;

import static de.baromeus.dueldemo.utils.ImageUtils.*;

public class Player extends Human implements de.baromeus.dueldemo.interfaces.Player {
    private EStats focus;
    private Stats stats;
    private int difficulty;
    private CharacterPanel character;
    private ArrayList<Item> inventory;

    public Player(){
        super();
        name = "No Name";
        character = new CharacterPanel();
        character.setName(name);
        character.addImage(getImage(IMAGE_SIDE));
        inventory = new ArrayList<>();
    }

    public void setValues(int difficulty, int str, int vit, int res, int agi, int intel, int per, int luck){
        this.difficulty = difficulty;
        strength = str;
        vitality = vit;
        resilience = res;
        agility = agi;
        intelligence = intel;
        perception = per;
        this.luck = luck;
        character.setHP(maxHP(),maxHP());
        character.setReputation("Unbekannt");
        character.setMoney(250 + 50 * luck);
    }

    public CharacterPanel getPlayerPanel(){
        return character;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        character.setName(name);
    }

    public void setGender(Boolean isMale){
        male = isMale;
        if(male)
            character.setSiluette(getImageIcon(IMAGE_MALE));
        else
            character.setSiluette(getImageIcon(IMAGE_FEMALE));
        character.invalidate();
    }

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
        return character.getMoney();
    }

    public void setMoney(int value){
        character.setMoney(value);
    }
}
