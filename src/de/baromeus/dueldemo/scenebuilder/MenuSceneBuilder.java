package de.baromeus.dueldemo.scenebuilder;

import de.baromeus.dueldemo.enums.Shop;
import de.baromeus.dueldemo.scenes.MenuScene;
import java.util.Objects;

import static de.baromeus.dueldemo.MainFunctions.*;
import static de.baromeus.dueldemo.utils.ImageUtils.*;

public class MenuSceneBuilder {
    static MenuScene mainMenu = null;
    static MenuScene optionMenu = null;
    static MenuScene townMenu = null;
    static MenuScene traderMenu = null;
    static MenuScene tradingMenu = null;
    static MenuScene tavernMenu = null;
    static MenuScene arenaMenu = null;
    static MenuScene wilderness = null;
    static MenuScene saveMenu = null;

    public static final String WEAPON = "Waffenschmied";
    public static final String ARMOR = "Rüstungsmacher";
    public static final String CROCER = "Krämer";

    public static Shop trader = Shop.TOWN;

        public static MenuScene getMainMenuInstance(){
            if(mainMenu == null) {
                mainMenu = new MenuScene("Hauptmenü");
                mainMenu.addButton("Start Game")
                        .addActionListener(e -> newGame());

                mainMenu.addButton("Optionen")
                        .addActionListener(e -> callOptionMenu());

                mainMenu.addBackground(getImage(IMAGE_TITLE_C));
                mainMenu.addLeftBackground(getImage(IMAGE_TITLE_L));
                mainMenu.addRightBackground(getImage(IMAGE_TITLE_R));
            }

            return mainMenu;
        }

        public static MenuScene getOptionMenuInstance(){
            if(optionMenu == null) {
                optionMenu = new MenuScene("Optionen");
                optionMenu.addButton("Zurück")
                        .addActionListener(e -> callMainMenu());
            }

            return optionMenu;
        }

        public static MenuScene getTownMenuInstance() {
            if(townMenu == null){
                townMenu = new MenuScene("Stadt");

                townMenu.addButton("Zur Arena")
                        .addActionListener(e -> callArenaMenu());

                townMenu.addButton("Zum Waffenschmied")
                        .addActionListener(e -> callTraderMenu(Shop.WEAPON));

                townMenu.addButton("Zum Rüstungsmacher")
                        .addActionListener(e -> callTraderMenu(Shop.ARMOR));

                townMenu.addButton("Zum Krämer")
                        .addActionListener(e -> callTraderMenu(Shop.GROCER));

                townMenu.addButton("Zur Taverne")
                        .addActionListener(e -> callTavernMenu());

                townMenu.addButton("In die Wildniss")
                        .addActionListener(e -> callWildernessMenu());

                townMenu.addButton("Speichern");

                townMenu.addButton("Beenden");

                townMenu.addBackground(getImage(IMAGE_TOWN));
            }

            return townMenu;
        }

        public static MenuScene getArenaMenuInstance(){
            if(arenaMenu == null){
                arenaMenu = new MenuScene("Arena");
                arenaMenu.addButton("Zurück")
                        .addActionListener(e -> callTownMenu());

                arenaMenu.addBackground(getImage(IMAGE_ARENA));
            }

            return arenaMenu;
        }

        public static MenuScene getTavernMenuInstance(){
            if(tavernMenu == null){
                tavernMenu = new MenuScene("Taverne");
                tavernMenu.addButton("Zurück")
                        .addActionListener(e -> callTownMenu());

                tavernMenu.addBackground(getImage(IMAGE_TAVERN));
            }

            return tavernMenu;
        }

        public static MenuScene getWildernessMenuInstance(){
            if(wilderness == null){
                wilderness = new MenuScene("Wildniss");
                wilderness.addButton("Zurück")
                        .addActionListener(e -> callTownMenu());
                wilderness.addButton("Zufallskampf")
                        .addActionListener(e -> callTownMenu());

                wilderness.addBackground(getImage(IMAGE_WILDNESS));
            }

            return wilderness;
        }

        public static MenuScene getTraderMenu(Shop typ){
            traderMenu = new MenuScene("Händler");
            traderMenu.addButton("Kaufen")
                            .addActionListener(e -> callTradingMenu(typ,false));
            traderMenu.addButton("Verkaufen")
                            .addActionListener(e -> callTradingMenu(typ,true));
            traderMenu.addButton("Zurück")
                    .addActionListener(e -> callTownMenu());

            var f = "";
            switch (typ){
                case WEAPON -> {
                    f = IMAGE_BLACKSMITH;
                    traderMenu.changeTitle(WEAPON);
                }
                case ARMOR -> {
                    f = IMAGE_ARMORY;
                    traderMenu.changeTitle(ARMOR);
                }
                case GROCER -> {
                    f = IMAGE_CROCER;
                    traderMenu.changeTitle(CROCER);
                }
            }

            if(!f.equals(""))
                traderMenu.addBackground(getImage(f));


            trader = typ;
            return traderMenu;
        }

//        public static MenuScene getTradingMenu(Boolean sell){
//            if(tradingMenu == null){
//                tradingMenu = new MenuScene("Kaufen/Verkaufen");
//            }
//
//            var type = "";
//            if(sell){
//                type = "Verkaufen";
//            }else{
//                type = "Kaufen";
//            }
//
//            tradingMenu.changeTitle(trader + " -> " + type);
//            tradingMenu.clearButtons();
//            tradingMenu.addButton("Zurück")
//                    .addActionListener(e -> callTraderMenu(trader));
//
//            if(sell) {
//                generateSell();
//            }else{
//                switch (trader) {
//                    case WEAPON -> generateWeaponBuy();
//                    case ARMOR -> generarteArmorBuy();
//                    case CROCER -> generareCrocerBuy();
//                }
//            }
//            return tradingMenu;
//        }

        private static void generateWeaponBuy(){

        }

        private static void generarteArmorBuy(){

        }

        private static void generareCrocerBuy(){

        }

        public static void generateSell(){

        }
}
