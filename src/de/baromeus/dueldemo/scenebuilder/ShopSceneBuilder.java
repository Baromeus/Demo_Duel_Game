package de.baromeus.dueldemo.scenebuilder;

import de.baromeus.dueldemo.scenes.ShopScene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static de.baromeus.dueldemo.MainFunctions.callTraderMenu;
import static de.baromeus.dueldemo.scenebuilder.MenuSceneBuilder.*;
import static de.baromeus.dueldemo.utils.ImageUtils.IMAGE_BLACKSMITH;
import static de.baromeus.dueldemo.utils.ImageUtils.getImage;
import static de.baromeus.dueldemo.utils.ItemUtils.FILE_PATH;
import static de.baromeus.dueldemo.utils.ItemUtils.ItemFactory;

public class ShopSceneBuilder {
    static ShopScene weaponShop = null;

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

    public static ShopScene getTradingMenu(String type, Boolean sell){
        ShopScene ss = null;

//        if(sell){
//            t = "Verkaufen";
//        }else{
//            t = "Kaufen";
//        }

//        if(sell) {
////            generateSell();
//        }else{
            switch (type) {
                case WEAPON -> ss = getWeaponShop();
//                case ARMOR -> generarteArmorBuy();
//                case CROCER -> generareCrocerBuy();
            }
//        }

        return ss;
    }
}
