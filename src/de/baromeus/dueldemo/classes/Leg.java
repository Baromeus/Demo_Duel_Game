package de.baromeus.dueldemo.classes;

public class Leg extends ItemClass {
    public Leg(
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
        type = 'L';
    }
}
