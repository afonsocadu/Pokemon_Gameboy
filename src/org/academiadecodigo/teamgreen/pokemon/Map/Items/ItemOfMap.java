package org.academiadecodigo.teamgreen.pokemon.Map.Items;

public class ItemOfMap {

    private boolean canStep;

    public ItemOfMap(boolean canStep) {
        this.canStep = canStep;
    }

    public ItemOfMap() {

    }

    public boolean getCanStep() {
        return canStep;
    }


}