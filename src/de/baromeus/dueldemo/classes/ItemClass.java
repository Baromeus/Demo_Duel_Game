package de.baromeus.dueldemo.classes;

import de.baromeus.dueldemo.interfaces.Item;

public abstract class ItemClass implements Item {
    protected String name;
    protected int price;
    protected int value;
    protected int hindrance;
    protected int slot;
    protected char type;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getHindrance() {
        return hindrance;
    }

    @Override
    public int getSlotCost() {
        return slot;
    }

    @Override
    public char getType() {
        return type;
    }
}
