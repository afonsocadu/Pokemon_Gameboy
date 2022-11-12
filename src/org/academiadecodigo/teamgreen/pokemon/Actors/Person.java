package org.academiadecodigo.teamgreen.pokemon.Actors;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.teamgreen.pokemon.Direction;
import org.academiadecodigo.teamgreen.pokemon.Game;
import org.academiadecodigo.teamgreen.pokemon.Map.Items.ItemOfMap;
import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;

public class Person extends ItemOfMap {

    protected Rectangle dialogBox;
    protected Text dialogText;
    protected String initDialog;
    protected String[] splitDialog;
    protected String splitDialogToPrint;
    protected int splitDialogIterator;
    protected boolean isDialogOver;

    protected Picture picture;
    protected static final int LOGICAL_WIDTH = 20;
    protected static final int LOGICAL_HEIGHT = 2;
    protected static final int DIALOG_SIZE = 40;

    public Person(int x, int y, boolean canStep, String initDialog, EnemyType enemyType) {

        super(canStep);
        this.initDialog = initDialog;

        String pathToFile = "";
        switch (enemyType){

            case MAGMA_GRUNT:
                pathToFile = "magma_grunt_front.png";
                break;

            case AQUA_GRUNT:
                pathToFile = "aqua_grunt_front.png";
                break;

            case MAGMA_BOSS:
                pathToFile = "magma_boss_front.png";
                break;

            case AQUA_BOSS:
                pathToFile = "aqua_boss_front.png";
                break;
        }

        picture = new Picture(x, y, pathToFile);
        picture.draw();
    }

    public Person() {
        super();
    }

    public Person(boolean canStep) {
        super(canStep);
    }

    public Person(int x, int y, boolean canStep, String initDialog, String pathToFile) {
        super(canStep);
        this.initDialog = initDialog;
        picture = new Picture(x, y, pathToFile);
        picture.draw();
    }

    public Person(int x, int y, boolean canStep, String initDialog) {
        super(canStep);
        this.initDialog = initDialog;
    }

    public void initTalk(Direction direction){

        isDialogOver = false;
        splitDialogIterator = 0;
        splitDialog = initDialog.split("");

        dialogBox = new Rectangle(picture.getX() + GameSettings.IMG_PIXEL_SIZE, picture.getY() - LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, LOGICAL_WIDTH * GameSettings.IMG_PIXEL_SIZE, LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE);
        dialogBox.setColor(Color.WHITE);


        dialogText = new Text(0, 0, " ");

        Game.ashKetchum.setIsMovementLocked(true);
        continueDialog();
    }

    public void continueDialog(){

        dialogBox.fill();
        dialogText.delete();
        splitDialogToPrint = " ";

        if (Game.winCounter == 8){
            dialogBox = new Rectangle(picture.getX() + GameSettings.IMG_PIXEL_SIZE, picture.getY() - LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, LOGICAL_WIDTH * GameSettings.IMG_PIXEL_SIZE+200, 2*LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE);
            dialogBox.setColor(Color.WHITE);
            dialogText = new Text(picture.getX() + LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, picture.getY() - LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, "You are truly a great trainer, Rayquaza thanks you!");
            dialogText.draw();
            Picture rayquza = new Picture(19*GameSettings.IMG_PIXEL_SIZE, 34*GameSettings.IMG_PIXEL_SIZE, "rayquaza.png");
            rayquza.draw();
            return;
        }

        for (int i = 0; i < DIALOG_SIZE; i++){
            if (splitDialogIterator < splitDialog.length){
                splitDialogToPrint = splitDialogToPrint + splitDialog[splitDialogIterator];
                splitDialogIterator++;
                continue;
            }
            isDialogOver = true;
            break;
        }

        dialogText = new Text(picture.getX() + LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, picture.getY() - LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, splitDialogToPrint);
        dialogText.draw();

    }

    public void endDialog(){

        Game.ashKetchum.setIsMovementLocked(false);
        dialogText.delete();
        dialogBox.delete();
    }

    public boolean getIsDialogOver(){
        return isDialogOver;
    }

    public Rectangle getDialogBox() {
        return dialogBox;
    }

    public Text getDialogText() {
        return dialogText;
    }
}