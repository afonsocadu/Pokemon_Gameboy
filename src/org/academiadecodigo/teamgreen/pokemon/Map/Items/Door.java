package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Door extends ItemOfMap{

    private Picture picture;

    public Door(int x, int y) {
        super(false);
        picture = new Picture(x, y, "door.png");
        picture.draw();
    }
}
