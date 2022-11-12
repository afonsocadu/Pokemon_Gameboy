package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Water extends ItemOfMap {

    private Picture picture;

    public Water() {
        super(false);
    }

    public Water(int x, int y) {
        super(false);
        picture = new Picture(x, y, "water.png");
        picture.draw();
    }
}