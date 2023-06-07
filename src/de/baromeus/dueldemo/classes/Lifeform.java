package de.baromeus.dueldemo.classes;

public abstract class Lifeform {
    protected String name;
    protected int hp;
    protected int level = 1;
    protected int strength;
    protected int vitality;
    protected int resilience;
    protected int agility;
    protected int intelligence ;
    protected int perception;
    protected int luck;

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
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getLevel(){
        return level;
    }
    public int getStrength(){
        return strength;
    }
    public int getVitality() {
        return vitality;
    }
    public int getResilience() {
        return resilience;
    }
    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getPerception() {
        return perception;
    }

    public int getLuck() {
        return luck;
    }
}
