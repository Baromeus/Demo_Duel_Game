package de.baromeus.dueldemo.scenebuilder;

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
            weaponShop = new ShopScene("Waffenschmied -> Kaufen");
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
            armorShop = new ShopScene("Rüstungsmacher -> Kaufen");
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
            crocerShop = new ShopScene("Krämer -> Kaufen");
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

    public static ShopScene getInventory(String type, Boolean sell){
        if(inventory == null){
            inventory = new ShopScene("");
        }
        inventory.clearButtons();
        if(sell){
            switch (type){
                case WEAPON -> {
                    inventory.addBackground(getImage(IMAGE_BLACKSMITH));
                    inventory.setTitle("Waffenschmied -> Verkaufen");
                }
                case ARMOR -> {
                    inventory.addBackground(getImage(IMAGE_ARMORY));
                    inventory.setTitle("Rüstungsmacher -> Verkaufen");
                }
                case CROCER -> {
                    inventory.addBackground(getImage(IMAGE_CROCER));
                    inventory.setTitle("Krämer -> Verkaufen");
                }
            }
            inventory.addButton("Zurück")
                    .addActionListener(e -> callTraderMenu(type));
        }else{
            inventory.addBackground(getImage(IMAGE_TOWN));
            inventory.setTitle("Inventar");
            inventory.addButton("Zurück")
                    .addActionListener(e -> callTownMenu());
        }

        player.getInventory().forEach(it ->{
            inventory.addItem(it);
        });

        return inventory;
    }

    public static ShopScene getTradingMenu(String type, Boolean sell){
        ShopScene ss = null;

        if(sell){
            ss = getInventory(type, true);
        }else{
            switch (type) {
                case WEAPON -> ss = getWeaponShop();
                case ARMOR -> ss = getArmorShop();
                case CROCER -> ss = getGrocerShop();
            }
        }

        return ss;
    }
}
