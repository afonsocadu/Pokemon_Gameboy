package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.security.PrivateKey;

public class ImpassableBlock extends ItemOfMap {

    private Picture picture;

    public ImpassableBlock(int x, int y){
        super(false);
    }

    public ImpassableBlock(int x, int y, String pathToFile){
        super(false);
        picture = new Picture(x, y, pathToFile);
        picture.draw();
    }
}
