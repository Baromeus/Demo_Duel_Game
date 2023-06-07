package de.baromeus.dueldemo.scenebuilder;

import de.baromeus.dueldemo.classes.Lifeform;
import de.baromeus.dueldemo.classes.NPC;
import de.baromeus.dueldemo.classes.Player;
import de.baromeus.dueldemo.classes.Tiger;
import de.baromeus.dueldemo.scenes.GameScene;

import javax.swing.*;
import java.util.Objects;

import static de.baromeus.dueldemo.MainFunctions.*;
import static de.baromeus.dueldemo.utils.Utils.rollDice;

public class GameSceneBuilder {
    static GameScene intro = null;
    static GameScene characterGen = null;
    static GameScene wilderness = null;

    public static GameScene getIntroInstance(){
        if(intro == null){
            intro = new GameScene("Intro");
            intro.addButton("Skip")
                    .addActionListener(e -> callCharacterGen());
        }

        return intro;
    }

    public static GameScene getChracterGenInstance(){
        if(characterGen == null){
            characterGen = new GameScene("Charaktererstellung");
            var player = getPlayer();
            player.setGender(true);


            characterGen.addButton("Zurück")
                    .addActionListener(e -> callMainMenu());

            characterGen.addButton("Name")
                    .addActionListener(e ->{
                        player.setName((String) JOptionPane.showInputDialog(
                                "Gib einen Namen ein."
                        ));
                    });
            
            characterGen.addButton("Geschlecht")
                    .addActionListener(e ->{
                        player.setGender(!Objects.equals(player.getGender(), "Mann"));
                    });

            JButton auswuerfeln =  characterGen.addButton("Auswürfeln");
            JButton btn = characterGen.addButton("Akzeptieren");
            btn.addActionListener(e -> {callTownMenu();});
            btn.setEnabled(false);

            auswuerfeln.addActionListener(e ->{

                var str = rollDice();
                var vit = rollDice();
                var res = rollDice();
                var agi = rollDice();
                var intel = rollDice();
                var per = rollDice();
                var luck = rollDice();

                characterGen.abortText();
                characterGen.clearText();
                characterGen.appendText("Folgende Werte wurden gerollt:");
                characterGen.appendText("Stärke: " + str);
                characterGen.appendText("Vitalität: " + vit);
                characterGen.appendText("Wiederstand: " + res);
                characterGen.appendText("Agilität: " + agi);
                characterGen.appendText("Inteligenz: " + intel);
                characterGen.appendText("Wahrnehmung: " + per);
                characterGen.appendText("Glück: " + luck);

                player.setValues(0,str,vit,res,agi,intel,per,luck);
                btn.setEnabled(true);
            });
        }
        
        return characterGen;
    }

    public static GameScene getWildernissFightInstance(){
        if(wilderness != null){
            wilderness = null;
        }
        wilderness = new GameScene("Zufallskampf");
        Lifeform enemy = generateEnemy(1);

        wilderness.addButton("Flüchten")
                .addActionListener(e -> callWildernessMenu());

        wilderness.addButton("Kampf")
                .addActionListener(e -> wilderness.start());

        return wilderness;
    }

    private static Lifeform generateEnemy(int level){
        Lifeform result = null;
        int rnd = rollDice();
        if(rnd%2==0){
            result = new Tiger("Tiger");
        }else{
            result = new NPC("Bandit");
        }
        return result;
    }
}
