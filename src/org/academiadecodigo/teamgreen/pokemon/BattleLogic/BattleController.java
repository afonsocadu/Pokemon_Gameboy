package org.academiadecodigo.teamgreen.pokemon.BattleLogic;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.teamgreen.pokemon.Actors.AshKetchum;
import org.academiadecodigo.teamgreen.pokemon.Actors.Pokemon;
import org.academiadecodigo.teamgreen.pokemon.Actors.Trainer;
import org.academiadecodigo.teamgreen.pokemon.Game;
import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;

public class BattleController implements KeyboardHandler {

    private boolean isCombatRunning;
    private boolean isBattleRunning;
    private boolean isPrintingMessage;
    private boolean isSwitchingPokemon;
    private Rectangle battleWindow;
    private Rectangle battleBackground;
    private AshKetchum ashKetchum;
    private Trainer trainer;
    private Pokemon currentPlayerPokemon;
    private Picture currentPlayerPokemonPicture;
    private Text currentPlayerPokemonHP;
    private Pokemon currentTrainerPokemon;
    private Picture currentTrainerPokemonPicture;
    private Text currentTrainerPokemonHP;
    private Rectangle messageWindow;
    private Text messageLog;
    private Text combatMoveOne;
    private Text combatMoveTwo;
    private Text combatMoveThree;
    private Text combatMoveFour;
    private Text lastUsedPlayerCombatMove;
    private Text lastUsedTrainerCombatMove;
    private Text faintedPlayerPokemon;
    private Text faintedTrainerPokemon;
    private int choosenAttack;


    public BattleController() {
        isBattleRunning = false;
        isCombatRunning = false;
    }

    public BattleController(AshKetchum ashKetchum, Trainer trainer) {

        this.ashKetchum = ashKetchum;
        this.trainer = trainer;
        this.currentPlayerPokemon = ashKetchum.getFirstNotFaintedPokemon();
        this.currentTrainerPokemon = trainer.getFirstNotFaintedPokemon();

    }

    public void startBattle() {

        isBattleRunning = true;
        isCombatRunning = false;
        isPrintingMessage = false;
        isSwitchingPokemon = false;

        battleBackground = new Rectangle(GameSettings.WIDTH / 2 - 158, GameSettings.HEIGHT / 2 - 133, 316, 509);
        battleBackground.setColor(Color.BLACK);
        battleBackground.fill();

        battleWindow = new Rectangle(GameSettings.WIDTH / 2 - 105, GameSettings.HEIGHT / 2 - 100, 215, 200);
        battleWindow.setColor(Color.WHITE);
        battleWindow.fill();

        messageWindow = new Rectangle(GameSettings.WIDTH / 2 - 105, GameSettings.HEIGHT / 2 + 110, 215, 100);
        messageWindow.setColor(Color.WHITE);
        messageWindow.fill();

        messageLog = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 110, "Battle start");
        messageLog.draw();

        currentPlayerPokemonPicture = new Picture(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 40, currentPlayerPokemon.getPathToFile());
        currentTrainerPokemonPicture = new Picture(GameSettings.WIDTH / 2 + 40, GameSettings.HEIGHT / 2 - 100, currentTrainerPokemon.getPathToFile());

        currentPlayerPokemonPicture.draw();
        currentTrainerPokemonPicture.draw();

        currentPlayerPokemonHP = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 40, Integer.toString(currentPlayerPokemon.getCurrentHP()));
        currentTrainerPokemonHP = new Text(GameSettings.WIDTH / 2 + 40, GameSettings.HEIGHT / 2 - 100, Integer.toString(currentTrainerPokemon.getCurrentHP()));

        currentPlayerPokemonHP.draw();
        currentTrainerPokemonHP.draw();

        combatMoveOne = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 110, currentPlayerPokemon.getCombatMoves()[0].getMoveName());
        combatMoveTwo = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 135, currentPlayerPokemon.getCombatMoves()[1].getMoveName());
        combatMoveThree = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 160, currentPlayerPokemon.getCombatMoves()[2].getMoveName());
        combatMoveFour = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 185, currentPlayerPokemon.getCombatMoves()[3].getMoveName());

        lastUsedPlayerCombatMove = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 110, "");
        lastUsedTrainerCombatMove = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 135, "");
        faintedPlayerPokemon = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 185, "");
        faintedTrainerPokemon = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 160, "");


        initCombatKeyBoard();
    }

    public void initCombatKeyBoard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent keyboardEvent;

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_1);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_2);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_3);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_4);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_Z);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_X);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                if (isBattleRunning) {
                    if (isCombatRunning) {

                        if (currentPlayerPokemon.getSpeed() > currentTrainerPokemon.getSpeed()) {
                            processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[0]);
                            if (!checkForFaintedPokemon()) {
                                processTrainerCombatMove(0);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }

                        if (currentPlayerPokemon.getSpeed() < currentTrainerPokemon.getSpeed()) {
                            processTrainerCombatMove(0);
                            if (!checkForFaintedPokemon()) {
                                processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[0]);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }
                    }
                }
                break;

            case KeyboardEvent.KEY_2:
                if (isBattleRunning) {
                    if (isCombatRunning) {

                        if (currentPlayerPokemon.getSpeed() > currentTrainerPokemon.getSpeed()) {
                            processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[1]);
                            if (!checkForFaintedPokemon()) {
                                processTrainerCombatMove(0);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }

                        if (currentPlayerPokemon.getSpeed() < currentTrainerPokemon.getSpeed()) {
                            processTrainerCombatMove(0);
                            if (!checkForFaintedPokemon()) {
                                processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[1]);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }
                    }
                }
                break;

            case KeyboardEvent.KEY_3:
                if (isBattleRunning) {
                    if (isCombatRunning) {

                        if (currentPlayerPokemon.getSpeed() > currentTrainerPokemon.getSpeed()) {
                            processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[2]);
                            if (!checkForFaintedPokemon()) {
                                processTrainerCombatMove(0);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }

                        if (currentPlayerPokemon.getSpeed() < currentTrainerPokemon.getSpeed()) {
                            processTrainerCombatMove(0);
                            if (!checkForFaintedPokemon()) {
                                processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[2]);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }
                    }
                }
                break;

            case KeyboardEvent.KEY_4:
                if (isBattleRunning) {
                    if (isCombatRunning) {

                        if (currentPlayerPokemon.getSpeed() > currentTrainerPokemon.getSpeed()) {
                            processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[3]);
                            if (!checkForFaintedPokemon()) {
                                processTrainerCombatMove(0);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }

                        if (currentPlayerPokemon.getSpeed() < currentTrainerPokemon.getSpeed()) {
                            processTrainerCombatMove(0);
                            if (!checkForFaintedPokemon()) {
                                processPlayerCombatMove(currentPlayerPokemon.getCombatMoves()[3]);
                            }
                            isCombatRunning = false;
                            isPrintingMessage = true;
                            hideCombatMoveOptions();
                            break;
                        }
                    }
                }
                break;

            case KeyboardEvent.KEY_Z:
                if (!isBattleRunning && !isCombatRunning) {
                    break;
                }
                if (!checkForRemainingTrainerPokemon() || !checkForRemainingPlayerPokemon()) {
                    endBattle();
                    break;
                }

                checkForFaintedPokemon();
                if (isPrintingMessage) {
                    printCombatMessages();
                    break;
                }
                if (isSwitchingPokemon) {
                    if (currentPlayerPokemon.getCurrentHP() <= 0) {
                        switchPlayerPokemon();
                        break;
                    }
                    if (currentTrainerPokemon.getCurrentHP() <= 0) {
                        switchTrainerPokemon();
                        break;
                    }

                }

                if (isBattleRunning && !isCombatRunning) {
                    faintedTrainerPokemon.setText("");
                    faintedPlayerPokemon.setText("");
                    showCombatMoveOptions();
                    isCombatRunning = true;
                    break;
                }
                break;

            case KeyboardEvent.KEY_X:
                if (!isBattleRunning && !isCombatRunning) {
                    break;
                }
                if (isBattleRunning && !isCombatRunning) {
                    switchPlayerPokemon();
                    processTrainerCombatMove(0);
                    break;
                }
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public void processPlayerCombatMove(CombatMove combatMove) {

        if (combatMove.getCurrentUses() <= 0) {
            lastUsedPlayerCombatMove.setText("");
            messageLog.setText("Current attack is out of PP");
            messageLog.draw();
            return;
        }

        if (combatMove.getAttackStatUsed() != PhysSpec.PHYSICAL && combatMove.getAttackStatUsed() != PhysSpec.SPECIAL) {

            if (combatMove.getAttackStatUsed() == PhysSpec.SELF_STAT_CHANGE) {
                for (int i = 0; i < combatMove.getAffectedStats().size(); i++) {
                    switch (combatMove.getAffectedStats().get(i)) {

                        case "Defense":
                            currentPlayerPokemon.setDefense((int) (currentPlayerPokemon.getDefense() * combatMove.getModifier()));
                            break;

                        case "Special Defense":
                            currentPlayerPokemon.setSpecialDefense((int) (currentPlayerPokemon.getSpecialDefense() * combatMove.getModifier()));
                            break;

                        case "HP":
                            currentPlayerPokemon.setCurrentHP((int) (currentPlayerPokemon.getCurrentHP() + currentPlayerPokemon.getMaxHP() * combatMove.getModifier()));
                    }
                }

                messageLog.setText(currentPlayerPokemon.getPokemonName() + " stats have increased!");
                messageLog.draw();
                return;
            }
        }

        currentTrainerPokemon.dealDamage(combatMove, currentPlayerPokemon);
        currentTrainerPokemonHP.setText(Integer.toString(currentTrainerPokemon.getCurrentHP()));

        lastUsedPlayerCombatMove.setText(currentPlayerPokemon.getPokemonName() + " has used " + combatMove.getMoveName());
    }

    public void processTrainerCombatMove(int moveID) {

        if (currentTrainerPokemon.getCombatMoves()[moveID].getMoveName().equals("Flame Charge")) {
            currentTrainerPokemon.setSpeed(currentTrainerPokemon.getSpeed() * 2);
        }

        if (currentTrainerPokemon.getCombatMoves()[moveID].getCurrentUses() <= 0) {
            messageLog.setText(currentTrainerPokemon.getPokemonName() + " has no further uses of " + currentTrainerPokemon.getCombatMoves()[moveID].getMoveName());
            messageLog.draw();
            return;
        }

        currentPlayerPokemon.dealDamage(currentTrainerPokemon.getCombatMoves()[moveID], currentTrainerPokemon);
        currentPlayerPokemonHP.setText(Integer.toString(currentPlayerPokemon.getCurrentHP()));

        lastUsedTrainerCombatMove.setText(currentTrainerPokemon.getPokemonName() + " has used " + currentTrainerPokemon.getCombatMoves()[moveID].getMoveName());
    }

    public boolean checkForFaintedPokemon() {

        if (currentPlayerPokemon.getCurrentHP() <= 0) {
            currentPlayerPokemon.setIsFainted(true);
            currentPlayerPokemonPicture.delete();
            currentPlayerPokemonHP.delete();
            faintedPlayerPokemon.setText(currentPlayerPokemon.getPokemonName() + " has fainted");
            faintedPlayerPokemon.draw();
            isSwitchingPokemon = true;
            return true;
        }
        if (currentTrainerPokemon.getCurrentHP() <= 0) {
            currentTrainerPokemon.setIsFainted(true);
            currentTrainerPokemonPicture.delete();
            currentTrainerPokemonHP.delete();
            faintedTrainerPokemon.setText(currentTrainerPokemon.getPokemonName() + " has fainted");
            faintedTrainerPokemon.draw();
            isSwitchingPokemon = true;
            return true;
        }
        return false;
    }

    public void endBattle() {
        Game.winCounter++;
        this.battleBackground.delete();
        this.battleWindow.delete();
        this.currentTrainerPokemonPicture.delete();
        this.currentPlayerPokemonPicture.delete();
        this.combatMoveOne.delete();
        this.combatMoveTwo.delete();
        this.combatMoveThree.delete();
        this.combatMoveFour.delete();
        this.messageWindow.delete();
        this.currentTrainerPokemonHP.delete();
        this.currentPlayerPokemonHP.delete();
        this.faintedPlayerPokemon.delete();
        this.faintedTrainerPokemon.delete();
        this.lastUsedTrainerCombatMove.delete();
        this.lastUsedPlayerCombatMove.delete();
        Game.ashKetchum.setIsMovementLocked(false);
        this.isPrintingMessage = false;
        this.isBattleRunning = false;
        this.isCombatRunning = false;
        this.isSwitchingPokemon = false;

        for (int i = 0; i < trainer.getPokemonTeam().length; i++) {
            if (!trainer.getPokemonTeam()[i].getIsFainted()) {
                return;
            }
        }
        trainer.setIsDefeated(true);
    }

    public void showCombatMoveOptions() {

        messageLog.delete();
        lastUsedPlayerCombatMove.delete();
        lastUsedTrainerCombatMove.delete();
        faintedPlayerPokemon.delete();
        faintedTrainerPokemon.delete();
        combatMoveOne.draw();
        combatMoveTwo.draw();
        combatMoveThree.draw();
        combatMoveFour.draw();
    }

    public void hideCombatMoveOptions() {

        combatMoveOne.delete();
        combatMoveTwo.delete();
        combatMoveThree.delete();
        combatMoveFour.delete();
    }

    public boolean getIsBattleRunning() {
        return isBattleRunning;
    }

    public boolean checkForRemainingPlayerPokemon() {

        for (int i = 0; i < ashKetchum.getPokemonTeam().length; i++) {
            if (!ashKetchum.getPokemonTeam()[i].getIsFainted()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForRemainingTrainerPokemon() {

        for (int i = 0; i < trainer.getPokemonTeam().length; i++) {
            if (!trainer.getPokemonTeam()[i].getIsFainted()) {
                return true;
            }
        }
        return false;
    }

    public void switchPlayerPokemon() {

        for (int i = 0; i < GameSettings.MAX_POKEMON_TEAM_NUMBER; i++) {
            if (ashKetchum.getPokemonTeam()[i + 1].getPokemonName() == null) {
                isSwitchingPokemon = false;
                return;
            }

            if (currentPlayerPokemon.getPokemonName().equals(ashKetchum.getPokemonTeam()[i].getPokemonName())) {
                currentPlayerPokemonPicture.delete();
                currentPlayerPokemonHP.delete();
                currentPlayerPokemon = ashKetchum.getPokemonTeam()[i + 1];
                currentPlayerPokemonHP = new Text(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 40, Integer.toString(currentPlayerPokemon.getCurrentHP()));
                currentPlayerPokemonPicture = new Picture(GameSettings.WIDTH / 2 - 100, GameSettings.HEIGHT / 2 + 40, ashKetchum.getPokemonTeam()[i + 1].getPathToFile());
                currentPlayerPokemonPicture.draw();
                currentPlayerPokemonHP.draw();
                isSwitchingPokemon = false;
                break;
            }
        }
        combatMoveOne.setText(currentPlayerPokemon.getCombatMoves()[0].getMoveName());
        combatMoveTwo.setText(currentPlayerPokemon.getCombatMoves()[1].getMoveName());
        combatMoveThree.setText(currentPlayerPokemon.getCombatMoves()[2].getMoveName());
        combatMoveFour.setText(currentPlayerPokemon.getCombatMoves()[3].getMoveName());
    }

    public void switchTrainerPokemon() {

        for (int i = 0; i < GameSettings.MAX_POKEMON_TEAM_NUMBER; i++) {
            if (trainer.getPokemonTeam()[i + 1].getPokemonName() == null) {
                isSwitchingPokemon = false;
                return;
            }

            if (currentTrainerPokemon.getPokemonName().equals(trainer.getPokemonTeam()[i].getPokemonName())) {

                currentTrainerPokemonPicture.delete();
                currentTrainerPokemonHP.delete();

                currentTrainerPokemon = trainer.getPokemonTeam()[i + 1];
                currentTrainerPokemonHP = new Text(GameSettings.WIDTH / 2 + 40, GameSettings.HEIGHT / 2 - 100, Integer.toString(currentTrainerPokemon.getCurrentHP()));
                currentTrainerPokemonPicture = new Picture(GameSettings.WIDTH / 2 + 40, GameSettings.HEIGHT / 2 - 100, trainer.getPokemonTeam()[i+1].getPathToFile());
                currentTrainerPokemonPicture.draw();
                currentTrainerPokemonHP.draw();
                isSwitchingPokemon = false;
                return;
            }
        }
    }

    public void printCombatMessages() {

        //print attack of the player pokemon
        lastUsedPlayerCombatMove.draw();
        //print attack of the trainer pokemon
        lastUsedTrainerCombatMove.draw();
        //print if any of the pokemon faints
        faintedPlayerPokemon.draw();
        faintedTrainerPokemon.draw();

        isPrintingMessage = false;
    }
}
