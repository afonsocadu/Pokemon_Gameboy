package org.academiadecodigo.teamgreen.pokemon.Actors;

import org.academiadecodigo.teamgreen.pokemon.BattleLogic.CombatMove;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.PhysSpec;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.PokemonType;
import org.academiadecodigo.teamgreen.pokemon.Direction;
import org.academiadecodigo.teamgreen.pokemon.Game;
import org.academiadecodigo.teamgreen.pokemon.Map.Items.Truck;
import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class AshKetchum implements KeyboardHandler {

    private Picture ash;
    private int ashLogicalX;
    private int ashLogicalY;
    private Direction lookingDirection;
    private boolean isMovementLocked;
    private Pokemon[] pokemonTeam;
    private Pokemon mew;
    private CombatMove[] mewCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];


    public AshKetchum() {
        int x = GameSettings.PLAYER_INIT_X_COORD;
        int y = GameSettings.PLAYER_INIT_Y_COORD;

        ash = new Picture(x, y, "ash_south.png");

        isMovementLocked = false;

        ashLogicalX = ash.getX() / GameSettings.IMG_PIXEL_SIZE;
        ashLogicalY = ash.getY() / GameSettings.IMG_PIXEL_SIZE;

        pokemonTeam = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];

        ArrayList<String> affectedStats = new ArrayList<>();
        CombatMove extremeSpeed = new CombatMove("Extreme Speed", PokemonType.NORMAL, PhysSpec.PHYSICAL, 80, 100, 5);
        CombatMove flamethrower = new CombatMove("Flamethrower", PokemonType.FIRE, PhysSpec.PHYSICAL, 90, 100, 15);
        CombatMove surf = new CombatMove("Surf", PokemonType.WATER, PhysSpec.SPECIAL, 90, 100, 15);
        CombatMove calmMind = new CombatMove("Calm Mind", PokemonType.PSYCHIC, PhysSpec.SELF_STAT_CHANGE, 0, 101, 20, 1.5, affectedStats);
        CombatMove iceBeam = new CombatMove("Ice Beam", PokemonType.ICE, PhysSpec.SPECIAL, 90, 100, 10, 10);
        CombatMove thunderbolt = new CombatMove("ThunderBolt", PokemonType.ELECTRIC, PhysSpec.SPECIAL, 90, 100, 15, 10);
        CombatMove recover = new CombatMove("Recover", PokemonType.NORMAL, PhysSpec.SELF_STAT_CHANGE, 0, 101, 10, 0.5, affectedStats);
        CombatMove psychic = new CombatMove("Psychic", PokemonType.PSYCHIC, PhysSpec.SPECIAL, 90, 100, 10, 10);

        CombatMove[] suicuneCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        CombatMove movePlaceholder2 = new CombatMove();
        CombatMove movePlaceholder3 = new CombatMove();
        CombatMove movePlaceholder4 = new CombatMove();
        suicuneCombatMoves[0] = new CombatMove("Extreme Speed", PokemonType.NORMAL, PhysSpec.PHYSICAL, 80, 100, 5);
        ;
        suicuneCombatMoves[1] = new CombatMove("Surf", PokemonType.WATER, PhysSpec.SPECIAL, 90, 100, 15);
        affectedStats.add("Defense");
        affectedStats.add("Special Defense");
        suicuneCombatMoves[2] = new CombatMove("Calm Mind", PokemonType.PSYCHIC, PhysSpec.SELF_STAT_CHANGE, 0, 101, 20, 1.5, affectedStats);
        affectedStats.clear();
        suicuneCombatMoves[3] = new CombatMove("Ice Beam", PokemonType.ICE, PhysSpec.SPECIAL, 90, 100, 10, 10);
        ;
        Pokemon suicune = new Pokemon("Suicune", PokemonType.WATER, PokemonType.NONE, 0, 0, "sui sui", "suicune_back.png", suicuneCombatMoves, 75, 115, 100, 90, 115, 85);

        CombatMove[] ho_ohCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        ho_ohCombatMoves[0] = new CombatMove("Flamethrower", PokemonType.FIRE, PhysSpec.PHYSICAL, 90, 100, 15);
        affectedStats.add("Defense");
        affectedStats.add("Special Defense");
        ho_ohCombatMoves[1] = new CombatMove("Calm Mind", PokemonType.PSYCHIC, PhysSpec.SELF_STAT_CHANGE, 0, 101, 20, 1.5, affectedStats);
        affectedStats.clear();
        ho_ohCombatMoves[2] = new CombatMove("ThunderBolt", PokemonType.ELECTRIC, PhysSpec.SPECIAL, 90, 100, 15, 10);
        affectedStats.add("HP");
        ho_ohCombatMoves[3] = new CombatMove("Recover", PokemonType.NORMAL, PhysSpec.SELF_STAT_CHANGE, 0, 101, 10, 0.5, affectedStats);
        affectedStats.clear();
        Pokemon ho_oh = new Pokemon("Ho-oh", PokemonType.FIRE, PokemonType.FLYING, 0, 0, "oh oh", "ho_oh_back.png", ho_ohCombatMoves, 130, 90, 106, 110, 154, 90);

        mewCombatMoves[0] = new CombatMove("Psychic", PokemonType.PSYCHIC, PhysSpec.SPECIAL, 90, 100, 10, 10);
        affectedStats.add("Defense");
        affectedStats.add("Special Defense");
        mewCombatMoves[1] = new CombatMove("Calm Mind", PokemonType.PSYCHIC, PhysSpec.SELF_STAT_CHANGE, 0, 101, 20, 1.5, affectedStats);
        affectedStats.clear();
        affectedStats.add("HP");
        mewCombatMoves[2] = new CombatMove("Recover", PokemonType.NORMAL, PhysSpec.SELF_STAT_CHANGE, 0, 101, 10, 0.5, affectedStats);
        affectedStats.clear();
        mewCombatMoves[3] = new CombatMove("ThunderBolt", PokemonType.ELECTRIC, PhysSpec.SPECIAL, 90, 100, 15, 10);
        mew = new Pokemon("Mew", PokemonType.PSYCHIC, PokemonType.NONE, 0, 0, "mew mew", "mew_back.png", mewCombatMoves, 100, 100, 100, 100, 100, 100);

        Pokemon placeholder3 = new Pokemon();
        Pokemon placeholder4 = new Pokemon();
        Pokemon placeholder5 = new Pokemon();
        Pokemon placeholder6 = new Pokemon();
        pokemonTeam[0] = new Pokemon("Suicune", PokemonType.WATER, PokemonType.NONE, 0, 0, "sui sui", "suicune_back.png", suicuneCombatMoves, 75, 115, 100, 90, 115, 85);
        pokemonTeam[1] = new Pokemon("Ho-oh", PokemonType.FIRE, PokemonType.FLYING, 0, 0, "oh oh", "ho_oh_back.png", ho_ohCombatMoves, 130, 90, 106, 110, 154, 90);
        pokemonTeam[2] = placeholder3;
        pokemonTeam[3] = placeholder4;
        pokemonTeam[4] = placeholder5;
        pokemonTeam[5] = placeholder6;

        ash.draw();
    }

    public void setNewPosition(int x, int y, String path) {
        ash.delete();
        ash = new Picture(x, y, path);
        ash.draw();
    }

    public void translate(int x, int y) {
        ash.translate(x, y);
    }

    public int getX() {
        return ash.getX();
    }

    public int getY() {
        return ash.getY();
    }

    public void initPlayerKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent keyboardEvent;

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_UP);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_Z);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            // WALK TO TOP
            case KeyboardEvent.KEY_UP:
                if (isMovementLocked) {
                    return;
                }
                Game.ashKetchum.setNewPosition(this.getX(), this.getY(), "ash_north.png");
                lookingDirection = Direction.UP;

                if ((ashLogicalY != 0) && (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1].getCanStep())) {
                    ashLogicalY--;
                    Game.ashKetchum.translate(0, -GameSettings.IMG_PIXEL_SIZE);
                }

                break;

            // WALKT TO LEFT
            case KeyboardEvent.KEY_LEFT:
                if (isMovementLocked) {
                    return;
                }
                Game.ashKetchum.setNewPosition(this.getX(), this.getY(), "ash_west.png");
                lookingDirection = Direction.LEFT;

                if ((ashLogicalX != 0) && (Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY].getCanStep())) {
                    ashLogicalX--;
                    Game.ashKetchum.translate(-GameSettings.IMG_PIXEL_SIZE, 0);
                }

                break;

            // WALKT TO RIGHT
            case KeyboardEvent.KEY_RIGHT:
                if (isMovementLocked) {
                    return;
                }
                Game.ashKetchum.setNewPosition(this.getX(), this.getY(), "ash_east.png");
                lookingDirection = Direction.RIGHT;

                if ((ashLogicalX != GameSettings.ARRAY_BACKGROUND_WIDTH_LENGTH) && (Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY].getCanStep())) {
                    ashLogicalX++;
                    Game.ashKetchum.translate(GameSettings.IMG_PIXEL_SIZE, 0);
                }

                break;

            // WALK TO BOTTOM
            case KeyboardEvent.KEY_DOWN:
                if (isMovementLocked) {
                    return;
                }
                Game.ashKetchum.setNewPosition(this.getX(), this.getY(), "ash_south.png");
                lookingDirection = Direction.DOWN;

                if ((ashLogicalY != GameSettings.ARRAY_BACKGROUND_HEIGHT_LENGTH) && (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1].getCanStep())) {
                    ashLogicalY++;
                    Game.ashKetchum.translate(0, GameSettings.IMG_PIXEL_SIZE);
                }

                break;

            case KeyboardEvent.KEY_Z:

                if (!Game.battleController.getIsBattleRunning()) {
                    if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1] instanceof Truck) {
                        pokemonTeam[2] = mew;
                    }
                }

                if (checkIfTrainerDefeated() || checkIfPlayerDefeated()) {
                    break;
                }
                if (!Game.battleController.getIsBattleRunning()) {
                    interactWithPerson(lookingDirection);
                }


                break;
        }
    }


    public void interactWithPerson(Direction direction) {

        switch (direction) {

            case UP:
                if (isMovementLocked) {

                    if (((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1]).getIsDialogOver()) {
                        ((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1]).endDialog();
                        if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1] instanceof Trainer) {
                            Game.initBattleController((Trainer) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1]);
                        }
                        break;
                    }
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1]).continueDialog();
                    break;
                }

                if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1] instanceof Person) {
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1]).initTalk(lookingDirection);
                    break;
                }
                break;

            case LEFT:
                if (isMovementLocked) {
                    if (((Person) Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY]).getIsDialogOver()) {
                        ((Person) Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY]).endDialog();
                        if (Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY] instanceof Trainer) {
                            Game.initBattleController((Trainer) Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY]);
                        }
                        break;
                    }
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY]).continueDialog();
                    break;
                }

                if (Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY] instanceof Person) {
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY]).initTalk(lookingDirection);
                    break;
                }
                break;

            case RIGHT:
                if (isMovementLocked) {
                    if (((Person) Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY]).getIsDialogOver()) {
                        ((Person) Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY]).endDialog();
                        if (Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY] instanceof Trainer) {
                            Game.initBattleController((Trainer) Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY]);
                        }
                        break;
                    }
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY]).continueDialog();
                    break;
                }

                if (Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY] instanceof Person) {
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY]).initTalk(lookingDirection);
                    break;
                }
                break;

            case DOWN:
                if (isMovementLocked) {
                    if (((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1]).getIsDialogOver()) {
                        ((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1]).endDialog();
                        if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1] instanceof Trainer) {
                            Game.initBattleController((Trainer) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1]);
                        }
                        break;
                    }
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1]).continueDialog();
                    break;
                }

                if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1] instanceof Person) {
                    ((Person) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1]).initTalk(lookingDirection);
                    break;
                }
                break;
        }
    }


    public void setIsMovementLocked(boolean bol) {
        isMovementLocked = bol;
    }

    public boolean getIsMovementLocked() {
        return isMovementLocked;
    }

    public Pokemon[] getPokemonTeam() {
        return pokemonTeam;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public boolean checkIfTrainerDefeated() {

        switch (lookingDirection) {

            case UP:
                if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1] instanceof Trainer) {
                    if (((Trainer) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY - 1]).getIsDefeated()) {
                        return true;
                    }
                }
                break;

            case LEFT:
                if (Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY] instanceof Trainer) {
                    if (((Trainer) Game.worldMap.itemsOfMap[ashLogicalX - 1][ashLogicalY]).getIsDefeated()) {
                        return true;
                    }
                }
                break;

            case RIGHT:
                if (Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY] instanceof Trainer) {
                    if (((Trainer) Game.worldMap.itemsOfMap[ashLogicalX + 1][ashLogicalY]).getIsDefeated()) {
                        return true;
                    }
                }
                break;

            case DOWN:
                if (Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1] instanceof Trainer) {
                    if (((Trainer) Game.worldMap.itemsOfMap[ashLogicalX][ashLogicalY + 1]).getIsDefeated()) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public boolean checkIfPlayerDefeated() {

        for (int i = 0; i < GameSettings.MAX_POKEMON_TEAM_NUMBER; i++) {

            if (!this.pokemonTeam[i].getIsFainted()) {
                return false;
            }
        }
        return true;
    }

    public Pokemon getFirstNotFaintedPokemon() {

        for (int i = 0; i < GameSettings.MAX_POKEMON_TEAM_NUMBER; i++) {
            if (!this.pokemonTeam[i].getIsFainted()) {
                return this.pokemonTeam[i];
            }
        }
        return null;
    }
}

