package org.academiadecodigo.teamgreen.pokemon.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.teamgreen.pokemon.Map.TreeType;

public class Tree extends ItemOfMap {

    private Picture tree;

    public Tree() {
        super(false);
    }

    public Tree(int x, int y, TreeType type) {
        super(false);
        switch(type){
            case SMALL:
                tree = new Picture(x, y, "treeSmall.png");
                break;
            case MEDIUM:
                tree = new Picture(x, y, "treeMedium.png");
                break;
            case BIG:
                tree = new Picture(x, y, "treeBig.png");
                break;
        }
        tree.draw();
    }

}