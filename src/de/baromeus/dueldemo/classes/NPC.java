package de.baromeus.dueldemo.classes;

public class NPC extends Human{

    public NPC(String name){
        this.name.set(name);
        strength.set(4);
        vitality.set(3);
        resilience.set(2);
        agility.set(3);
        intelligence.set(4);
        perception.set(3);
        luck.set(2);
    }
}
