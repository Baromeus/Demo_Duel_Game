package de.baromeus.dueldemo;

import de.baromeus.dueldemo.classes.CharacterPanel;
import de.baromeus.dueldemo.classes.Player;
import de.baromeus.dueldemo.enums.Shop;
import de.baromeus.dueldemo.interfaces.GameScene;

import static de.baromeus.dueldemo.main.player;
import static de.baromeus.dueldemo.scenebuilder.GameSceneBuilder.*;
import static de.baromeus.dueldemo.scenebuilder.MenuSceneBuilder.*;
import static de.baromeus.dueldemo.scenebuilder.ShopSceneBuilder.getInventory;
import static de.baromeus.dueldemo.scenebuilder.ShopSceneBuilder.getTradingMenu;

public class MainFunctions {
    private static GameWindow game = null;
    public static CharacterPanel character = null;
    public static void startApp(){
        game = new GameWindow();
        callMainMenu();
    }
    public static void newGame(){
        // Intro
        game.addGameScene(getIntroInstance());
        // Charactererstellung

        // Start TownMenu
    }

    public static Player getPlayer(){
        if(player == null){
            player = new Player();
        }
        return player;
    }

    public static void callMainMenu(){
        game.addGameScene(getMainMenuInstance());
    }
    public static void callOptionMenu(){
        game.addGameScene(getOptionMenuInstance());
    }
    public static void callTownMenu() {
        game.addGameScene(getTownMenuInstance());
    }
    public static void callTraderMenu(Shop type){
        game.addGameScene(getTraderMenu(type));
    }
    public static void callTradingMenu(Shop type, Boolean sell){
        game.addGameScene(getTradingMenu(type, sell));
    }

    public static void callTavernMenu(){
        game.addGameScene(getTavernMenuInstance());
    }

    public static void callArenaMenu(){
        game.addGameScene(getArenaMenuInstance());
    }

    public static void callWildernessMenu(){
        game.addGameScene(getWildernessMenuInstance());
    }

    public static void callCharacterGen(){
        game.addGameScene(getChracterGenInstance());
    }
    public static void callInventory(){
        GameScene gs = game.getGameScene();
        game.addGameScene(getInventory(gs.getTyp(),false));
    }
}
