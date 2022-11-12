package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Truck extends ItemOfMap{

    Picture picture;

    public Truck(){
        super(false);
    }
    public Truck(int x, int y) {
        super(false);
        picture = new Picture(x, y, "mew_truck.png");
        picture.draw();
    }
}
