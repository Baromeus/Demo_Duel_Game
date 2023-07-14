package de.baromeus.dueldemo.classes;

public abstract class Animals extends Lifeform {
    @Override
    protected int maxHP() {
        return Math.round(vitality.get() * 4 + strength.get() * 2.5f + resilience.get() * 0.5f);
    }

    @Override
    protected int defence() {
        return Math.round(resilience.get() * 2.5f + strength.get() * 1.4f + vitality.get()* 0.5f);
    }

    @Override
    protected int attackPower() {
        return Math.round(strength .get()* 2.5f + agility.get() * 1.2f + perception.get() * 0.8f);
    }

    @Override
    protected int evasion() {
        return Math.round(agility.get() * 1.1f + perception.get() * 0.1f);
    }

    @Override
    protected int accuracy() {
        return Math.round(perception.get() * 1.5f + agility.get() * 0.2f);
    }

    @Override
    protected int initiative() {
        return Math.round(agility.get() * 0.5f + perception.get() * 0.2f);
    }

    @Override
    protected void levelUp(){
        level.set(level.get() + 1) ;
        strength.set(strength.get() + 1 + Math.round(level.get() * 0.5f));
        vitality.set(vitality.get() + 1 + Math.round(level.get() * 0.5f));
        resilience.set(resilience.get() + 1 + Math.round(level.get() * 0.5f));
        agility.set(agility.get() + 1 + Math.round(level.get() * 0.5f));
        intelligence.set(intelligence.get() + 1 + Math.round(level.get() * 0.5f));
        perception.set(perception.get() + 1 + Math.round(level.get() * 0.5f));
        luck.set(luck.get() + Math.round(level.get() * 0.25f));
    }
}
