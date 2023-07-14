package de.baromeus.dueldemo.classes;

import de.baromeus.dueldemo.utils.Property;

public abstract class Lifeform {
    protected Property<String> name = new Property<>("");
    protected Property<Integer> hp = new Property<>(0);
    protected Property<Integer> level = new Property<>(1);
    protected Property<Integer> strength = new Property<>(0);
    protected Property<Integer> vitality = new Property<>(0);
    protected Property<Integer> resilience = new Property<>(0);
    protected Property<Integer> agility = new Property<>(0);
    protected Property<Integer> intelligence  = new Property<>(0);
    protected Property<Integer> perception = new Property<>(0);
    protected Property<Integer> luck = new Property<>(0);

    abstract int maxHP();
    public int getMaxHP(){
        return maxHP();
    }
    abstract int defence();
    abstract int attackPower();
    abstract int evasion();
    abstract int accuracy();
    abstract int initiative();
    abstract void levelUp();
    public String getName(){
        return name.get();
    }
    public Property<String> propertyName(){
        return name;
    }
    public int getHp(){
        return hp.get();
    }
    public Property<Integer> propertyHP(){
        return hp;
    }
    public int getLevel(){
        return level.get();
    }
    public Property<Integer> propertyLevel(){
        return level;
    }
    public int getStrength(){
        return strength.get();
    }
    public Property<Integer> propertyStrength(){
        return strength;
    }
    public int getVitality() {
        return vitality.get();
    }
    public Property<Integer> propertyVitality(){
        return vitality;
    }
    public int getResilience() {
        return resilience.get();
    }
    public Property<Integer> propertyResilience(){
        return resilience;
    }
    public int getAgility() {
        return agility.get();
    }
    public Property<Integer> propertyAgility(){
        return agility;
    }
    public int getIntelligence() {
        return intelligence.get();
    }

    public int getPerception() {
        return perception.get();
    }

    public Property<Integer> propertyPerception(){
        return perception;
    }

    public int getLuck() {
        return luck.get();
    }

    public Property<Integer> propertyLuck(){
        return luck;
    }
}
