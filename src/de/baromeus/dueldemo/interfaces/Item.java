package de.baromeus.dueldemo.interfaces;

public interface Item {
    // name,price,value,hindrance,slotvalue,type
    public String getName();
    public int getPrice();
    public int getValue();
    public int getHindrance();
    public int getSlotCost();
    public char getType();
}
