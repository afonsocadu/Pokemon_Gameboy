package org.academiadecodigo.teamgreen.pokemon.BattleLogic;

import java.util.ArrayList;

public class CombatMove {

    private String moveName;
    private PokemonType moveType;
    private PhysSpec attackStatUsed;
    private int damage;
    private int accuracy;
    private int maxUses;
    private int currentUses;
    private int chanceOfEffect;
    private double modifier;
    private ArrayList<String> affectedStats = new ArrayList<>();

    public CombatMove() {
        this.moveName = "placeholder";
    }

    public CombatMove(String moveName, PokemonType moveType, PhysSpec attackStatUsed, int damage, int accuracy, int maxUses) {

        this.moveName = moveName;
        this.moveType = moveType;
        this.attackStatUsed = attackStatUsed;
        this.maxUses = maxUses;
        this.currentUses = maxUses;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public CombatMove(String moveName, PokemonType moveType, PhysSpec attackStatUsed, int damage, int accuracy, int maxUses, double modifier, ArrayList<String> affectedStats) {

        this.moveName = moveName;
        this.moveType = moveType;
        this.attackStatUsed = attackStatUsed;
        this.maxUses = maxUses;
        this.currentUses = maxUses;
        this.damage = damage;
        this.accuracy = accuracy;
        this.modifier = modifier;
        for (int i = 0; i < affectedStats.size(); i++){
            this.affectedStats.add(i, affectedStats.get(i));
        }
    }

    public CombatMove(String moveName, PokemonType moveType, PhysSpec attackStatUsed, int damage, int accuracy, int maxUses, int chanceOfEffect) {

        this.moveName = moveName;
        this.moveType = moveType;
        this.attackStatUsed = attackStatUsed;
        this.damage = damage;
        this.accuracy = accuracy;
        this.maxUses = maxUses;
        this.currentUses = maxUses;
        this.chanceOfEffect = chanceOfEffect;
    }

    public String getMoveName() {
        return moveName;
    }

    public int getDamage() {

        currentUses--;
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public PokemonType getMoveType() {
        return moveType;
    }

    public PhysSpec getAttackStatUsed() {
        return attackStatUsed;
    }

    public int getCurrentUses() {
        return currentUses;
    }

    public double getModifier() {
        return modifier;
    }

    public ArrayList<String> getAffectedStats() {
        return affectedStats;
    }
}
