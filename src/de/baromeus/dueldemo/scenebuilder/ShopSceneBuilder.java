package de.baromeus.dueldemo.scenebuilder;

import de.baromeus.dueldemo.enums.Shop;
import de.baromeus.dueldemo.scenes.ShopScene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static de.baromeus.dueldemo.MainFunctions.callTownMenu;
import static de.baromeus.dueldemo.MainFunctions.callTraderMenu;
import static de.baromeus.dueldemo.main.player;
import static de.baromeus.dueldemo.scenebuilder.MenuSceneBuilder.*;
import static de.baromeus.dueldemo.utils.ImageUtils.*;
import static de.baromeus.dueldemo.utils.ItemUtils.FILE_PATH;
import static de.baromeus.dueldemo.utils.ItemUtils.ItemFactory;

public class ShopSceneBuilder {
    static ShopScene weaponShop = null;
    static ShopScene armorShop = null;
    static ShopScene crocerShop = null;
    static ShopScene inventory = null;

    public static ShopScene getWeaponShop(){
        if(weaponShop == null){
            weaponShop = new ShopScene("Waffenschmied -> Kaufen", Shop.WEAPON);
            weaponShop.addBackground(getImage(IMAGE_BLACKSMITH));

            weaponShop.addButton("Zurück")
                    .addActionListener(e -> callTraderMenu(trader));

            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + "weapons.csv"))){
                String line;
                while((line = br.readLine()) != null) {
                    weaponShop.addItem(ItemFactory(line));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return weaponShop;
    }

    public static ShopScene getArmorShop(){
        if(armorShop == null){
            armorShop = new ShopScene("Rüstungsmacher -> Kaufen", Shop.ARMOR);
            armorShop.addBackground(getImage(IMAGE_ARMORY));

            armorShop.addButton("Zurück")
                    .addActionListener(e -> callTraderMenu(trader));

            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + "armor.csv"))){
                String line;
                while((line = br.readLine()) != null) {
                    armorShop.addItem(ItemFactory(line));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return armorShop;
    }

    public static ShopScene getGrocerShop(){
        if(crocerShop == null){
            crocerShop = new ShopScene("Krämer -> Kaufen", Shop.GROCER);
            crocerShop.addBackground(getImage(IMAGE_CROCER));

            crocerShop.addButton("Zurück")
                    .addActionListener(e -> callTraderMenu(trader));

            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + "utils.csv"))){
                String line;
                while((line = br.readLine()) != null) {
                    crocerShop.addItem(ItemFactory(line));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return crocerShop;
    }

    public static ShopScene getInventory(Shop typ, Boolean sell){
        if(inventory == null){
            inventory = new ShopScene("", Shop.TOWN);
        }
        inventory.clearButtons();
        inventory.clearItems();
        inventory.setMode(0);
        if(sell){
            switch (typ){
                case WEAPON -> {
                    inventory.addBackground(getImage(IMAGE_BLACKSMITH));
                    inventory.setTitle("Waffenschmied -> Verkaufen");
                }
                case ARMOR -> {
                    inventory.addBackground(getImage(IMAGE_ARMORY));
                    inventory.setTitle("Rüstungsmacher -> Verkaufen");
                }
                case GROCER -> {
                    inventory.addBackground(getImage(IMAGE_CROCER));
                    inventory.setTitle("Krämer -> Verkaufen");
                }
            }
            inventory.addButton("Zurück")
                    .addActionListener(e -> callTraderMenu(typ));
        }else{
            switch (typ){
                case WEAPON -> {
                    inventory.addBackground(getImage(IMAGE_BLACKSMITH));
                    inventory.setTitle("Inventar");
                    inventory.addButton("Zurück")
                            .addActionListener(e -> callTraderMenu(typ));
                }
                case ARMOR -> {
                    inventory.addBackground(getImage(IMAGE_ARMORY));
                    inventory.setTitle("Inventar");
                    inventory.addButton("Zurück")
                            .addActionListener(e -> callTraderMenu(typ));
                }
                case GROCER -> {
                    inventory.addBackground(getImage(IMAGE_CROCER));
                    inventory.setTitle("Inventar");
                    inventory.addButton("Zurück")
                            .addActionListener(e -> callTraderMenu(typ));
                }
                default -> {
                    inventory.addBackground(getImage(IMAGE_TOWN));
                    inventory.setTitle("Inventar");
                    inventory.addButton("Zurück")
                            .addActionListener(e -> callTownMenu());
                }
            }
        }

        player.getInventory().forEach(it ->{
            inventory.addItem(it);
        });

        return inventory;
    }

    public static ShopScene getTradingMenu(Shop typ, Boolean sell){
        ShopScene ss = null;

        if(sell){
            ss = getInventory(typ, true);
            ss.setMode(2);
        }else{
            switch (typ) {
                case WEAPON -> ss = getWeaponShop();
                case ARMOR -> ss = getArmorShop();
                case GROCER -> ss = getGrocerShop();
            }
            if(ss != null)
                ss.setMode(1);
        }
        return ss;
    }
}
