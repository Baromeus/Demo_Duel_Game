package de.baromeus.dueldemo.classes;

public class Weapon extends ItemClass{
    public Weapon(
            String name,
            int price,
            int value,
            int hindrance,
            int slot
    ){
        this.name = name;
        this.price = price;
        this.value = value;
        this.hindrance = hindrance;
        this.slot =slot;
        type = 'W';
    }
}
