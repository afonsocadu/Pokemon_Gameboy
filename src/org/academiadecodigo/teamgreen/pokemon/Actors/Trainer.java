package org.academiadecodigo.teamgreen.pokemon.Actors;

import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;

public class Trainer extends Person {
    private Pokemon[] pokemonTeam;
    private boolean isDefeated;

    public Trainer(int x, int y, String dialog, Pokemon[] pokemonTeam, EnemyType enemyType) {
        super(x, y, false, dialog, enemyType);
        this.pokemonTeam = pokemonTeam;
        this.isDefeated = false;
    }

    public Pokemon[] getPokemonTeam() {
        return pokemonTeam;
    }

    @Override
    public void endDialog(){

        super.getDialogBox().delete();
        super.getDialogText().delete();
    }

    public boolean getIsDefeated(){
        return isDefeated;
    }

    public void setIsDefeated(boolean bol){
        this.isDefeated = bol;
    }

    public Pokemon getFirstNotFaintedPokemon(){

        for (int i = 0; i < GameSettings.MAX_POKEMON_TEAM_NUMBER; i++){
            if (!this.pokemonTeam[i].getIsFainted()){
                return this.pokemonTeam[i];
            }
        }
        return null;
    }

}