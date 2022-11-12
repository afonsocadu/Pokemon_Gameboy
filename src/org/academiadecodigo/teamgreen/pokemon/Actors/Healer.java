package org.academiadecodigo.teamgreen.pokemon.Actors;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.teamgreen.pokemon.Direction;
import org.academiadecodigo.teamgreen.pokemon.Game;
import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;

public class Healer extends Person{

    public Healer(){
        super();
    }

    public Healer(int x, int y, boolean canStep, String dialog) {

        super(canStep);
        super.initDialog = dialog;
        picture = new Picture(x, y, "nurse_joy_front.png");
        picture.draw();
    }

    @Override
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

    @Override
    public void continueDialog(){

        dialogBox.fill();
        dialogText.delete();
        splitDialogToPrint = " ";

        for (int i = 0; i < DIALOG_SIZE; i++){
            if (splitDialogIterator < splitDialog.length){
                splitDialogToPrint = splitDialogToPrint + splitDialog[splitDialogIterator];
                splitDialogIterator++;
                continue;
            }
            isDialogOver = true;
            healPokemon();
            break;
        }

        dialogText = new Text(picture.getX() + LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, picture.getY() - LOGICAL_HEIGHT * GameSettings.IMG_PIXEL_SIZE, splitDialogToPrint);
        dialogText.draw();

    }

    public void healPokemon(){

        for(int i = 0; i < GameSettings.MAX_POKEMON_TEAM_NUMBER; i++){

            Game.ashKetchum.getPokemonTeam()[i].setIsFainted(false);
            Game.ashKetchum.getPokemonTeam()[i].restoreMaxHP();
        }
    }

}
