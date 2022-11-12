package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.teamgreen.pokemon.Map.HouseType;

public class House extends ItemOfMap {

    private Picture house;

    public House() {
        super(false);
    }

    public House(int x, int y, HouseType type) {
        super(false);
        switch(type){
            case SMALL:
                house = new Picture(x, y, "housesmall.png");
                break;
            case MEDIUM:
                house = new Picture(x, y, "housemedium.png");
                break;
            case LARGE:
                house = new Picture(x, y, "houselarge.png");
                break;
            case LABORATORY:
                house = new Picture(x, y, "houselaboratory.png");
                break;
            case TEMPLE:
                house = new Picture(x, y,"housetemple.png");
        }
        house.draw();
    }

    public House(boolean b) {
        super(b);
    }
}