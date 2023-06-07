package de.baromeus.dueldemo.utils;

import de.baromeus.dueldemo.classes.*;
import de.baromeus.dueldemo.interfaces.Item;

public class ItemUtils {
    public static final String FILE_PATH = "src/de/baromeus/dueldemo/items/";
    public static Item ItemFactory(String definition){
        Item result = null;
        var list = definition.split(",");
        if(list.length != 6) return null;

        var name = list[0];
        var price = Integer.parseInt(list[1]);
        var value = Integer.parseInt(list[2]);
        var hind = Integer.parseInt(list [3]);
        var slot = Integer.parseInt(list[4]);
        var type = list[5];

        switch (type){
            case "W" -> result = new Weapon(name, price, value, hind, slot);
            case "C"-> result = new Armor(name, price, value, hind, slot);
            case "L"-> result = new Leg(name, price, value, hind, slot);
            case "G"-> result = new Gloves(name, price, value, hind, slot);
            case "H"-> result = new Helmet(name, price, value, hind, slot);
            case "O"-> result = new Shild(name, price, value, hind, slot);
            case "I" -> result = new Consumable(name, price, value, hind, slot);
        }
        return result;
    }
}
