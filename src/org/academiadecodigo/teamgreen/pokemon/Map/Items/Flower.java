package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Flower extends ItemOfMap{

    private Picture flower;

    public Flower() {
        super(true);
    }

    public Flower(int x, int y) {
        super(true);
        flower = new Picture(x, y, "flower.png");
        flower.draw();
    }

}