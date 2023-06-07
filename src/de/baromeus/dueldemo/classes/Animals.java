package de.baromeus.dueldemo.classes;

public abstract class Animals extends Lifeform {
    @Override
    protected int maxHP() {
        return Math.round(vitality * 4 + strength * 2.5f + resilience * 0.5f);
    }

    @Override
    protected int defence() {
        return Math.round(resilience * 2.5f + strength * 1.4f + vitality * 0.5f);
    }

    @Override
    protected int attackPower() {
        return Math.round(strength * 2.5f + agility * 1.2f + perception * 0.8f);
    }

    @Override
    protected int evasion() {
        return Math.round(agility * 1.1f + perception * 0.1f);
    }

    @Override
    protected int accuracy() {
        return Math.round(perception * 1.5f + agility * 0.2f);
    }

    @Override
    protected int initiative() {
        return Math.round(agility * 0.5f + perception * 0.2f);
    }

    @Override
    protected void levelUp(){
        level++;
        strength+= 1 + Math.round(level * 0.5f);
        vitality+= 1 + Math.round(level * 0.5f);
        resilience+= 1 + Math.round(level * 0.5f);
        agility+= 1 + Math.round(level * 0.5f);
        intelligence+= 1 + Math.round(level * 0.5f);
        perception+= 1 + Math.round(level * 0.5f);
        luck+= Math.round(level * 0.25f);
    }
}
