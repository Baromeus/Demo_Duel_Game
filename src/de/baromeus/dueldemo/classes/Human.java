package de.baromeus.dueldemo.classes;

public abstract class Human extends Lifeform {
    protected Boolean male;
    public Human(){
        male = true;
    }
    @Override
    protected int maxHP() {
        return Math.round(vitality * 3.5f + strength * 1.5f + resilience * 0.5f);
    }

    @Override
    protected int defence() {
        return Math.round(resilience * 2.2f + strength * 0.5f + vitality * 0.5f);
    }

    @Override
    protected int attackPower() {
        return Math.round(strength * 1.5f + agility * 0.8f + perception * 0.5f);
    }

    @Override
    protected int evasion() {
        return Math.round(agility + perception * 0.2f);
    }

    @Override
    protected int accuracy() {
        return Math.round(perception * 1.5f + agility * 0.5f);
    }

    @Override
    protected int initiative() {
        return Math.round(agility * 0.5f + perception * 0.2f);
    }

    public String getGender(){
        if(male)
            return "Mann";
        else
            return "Frau";
    }

    public void switchGender(){
        male = !male;
        setChanged();
        notifyObservers();
    }

    @Override
    protected void levelUp() {
        level++;
        strength+= 1 + Math.round(level * 0.5f);
        vitality+= 1 + Math.round(level * 0.5f);
        resilience+= 1 + Math.round(level * 0.5f);
        agility+= 1 + Math.round(level * 0.5f);
        intelligence+= 1 + Math.round(level * 0.5f);
        perception+= 1 + Math.round(level * 0.5f);
        luck+= Math.round(level * 0.25f);
        setChanged();
        notifyObservers();
    }
}
