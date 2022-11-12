package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grass extends ItemOfMap {

    private Picture grass;

    public Grass(int x, int y) {
        super(true);
        grass = new Picture(x, y, "grass.png");
        grass.draw();
    }

}