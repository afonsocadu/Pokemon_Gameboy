package org.academiadecodigo.teamgreen.pokemon;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.teamgreen.pokemon.Actors.AshKetchum;
import org.academiadecodigo.teamgreen.pokemon.Actors.Trainer;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.BattleController;
import org.academiadecodigo.teamgreen.pokemon.Map.WorldMap;
import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;

public class Game {

    public static WorldMap worldMap;
    public static AshKetchum ashKetchum;
    public static BattleController battleController;
    public static int winCounter;

    public Game() {
        mainFrame();
        SoundHandler.RunMusic("/Users/codecadet/Desktop/code/PokemonAC__/pokemongSong.wav");

        worldMap = new WorldMap();
        ashKetchum = new AshKetchum();
        battleController = new BattleController();

        ashKetchum.initPlayerKeyboard();

        winCounter = 0;
    }

    private void mainFrame() {
        Rectangle mainFrame = new Rectangle(0, 0, GameSettings.WIDTH, GameSettings.HEIGHT);
        mainFrame.setColor(Color.WHITE);
        mainFrame.draw();
    }

    public static void initBattleController(Trainer trainer){

        battleController = new BattleController(ashKetchum, trainer);
        battleController.startBattle();
    }
}