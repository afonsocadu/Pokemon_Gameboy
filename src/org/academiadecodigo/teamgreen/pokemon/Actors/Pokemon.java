package org.academiadecodigo.teamgreen.pokemon.Actors;

import org.academiadecodigo.teamgreen.pokemon.BattleLogic.CombatMove;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.PokemonType;

public class Pokemon extends Person {

    private String pokemonName;
    private PokemonType mainType;
    private PokemonType secondaryType;
    private String pathToFile;
    private CombatMove[] combatMoves;
    private int attack;
    private int defense;
    private int currentHP;
    private int maxHP;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private int accuracy;
    private boolean isFainted;

    public Pokemon(String pokemonName, PokemonType mainType, PokemonType secondaryType, int x, int y, String dialog, String pathToFile, CombatMove[] combatMoves, int attack, int defense, int maxHP, int specialAttack, int specialDefense, int speed) {

        super(x, y, false, dialog);
        this.pokemonName = pokemonName;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
        this.pathToFile = pathToFile;
        this.combatMoves = combatMoves;
        this.attack = attack;
        this.defense = defense;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.accuracy = 100;
        this.isFainted = false;
    }

    public Pokemon() {
        super();
        this.isFainted = true;
    }

    public CombatMove[] getCombatMoves() {
        return combatMoves;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public int getAttack() {
        return attack;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void restoreMaxHP(){
        currentHP = maxHP;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void dealDamage(CombatMove combatMove, Pokemon attacker) {

        int finalDamage = 0;

        switch (combatMove.getAttackStatUsed()) {

            case PHYSICAL:
                finalDamage = ((combatMove.getDamage() * attacker.getAttack() / this.defense));
                if (combatMove.getMoveType() == this.mainType || combatMove.getMoveType() == this.secondaryType) {
                    finalDamage = (int) (1.5 * finalDamage);
                }
                break;

            case SPECIAL:
                finalDamage = ((combatMove.getDamage() * attacker.getSpecialAttack() / this.specialDefense));
                if (combatMove.getMoveType() == this.mainType || combatMove.getMoveType() == this.secondaryType) {
                    finalDamage = (int) (1.5 * finalDamage);
                }
                break;
        }

        if (isSuperEffectiveMainStat(combatMove)) {
            finalDamage = finalDamage * 2;
        }

        if (isSuperEffectiveSecondaryStat(combatMove)) {
            finalDamage = finalDamage * 2;
        }

        if (isResistantMainStat(combatMove)) {
            finalDamage = finalDamage / 2;
        }

        if (isResistantSecondaryStat(combatMove)) {
            finalDamage = finalDamage / 2;
        }

        if (finalDamage <= 0) {
            finalDamage = 1;
        }

        if (isImmuneMainStat(combatMove)) {
            finalDamage = 0;
        }

        if (isImmuneSecondaryStat(combatMove)) {
            finalDamage = 0;
        }

        this.currentHP = this.currentHP - finalDamage;
    }

    private boolean isImmuneSecondaryStat(CombatMove combatMove) {

        switch (combatMove.getMoveType()) {

            case NORMAL:
                if (secondaryType == PokemonType.GHOST) {
                    return true;
                }

            case FIRE:
                return false;

            case WATER:
                return false;

            case GRASS:
                return false;

            case ELECTRIC:
                if (secondaryType == PokemonType.GROUND) {
                    return true;
                }

            case ICE:
                return false;

            case FIGHTING:
                if (secondaryType == PokemonType.GHOST) {
                    return true;
                }

            case POISON:
                if (secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case GROUND:
                if (secondaryType == PokemonType.FLYING) {
                    return true;
                }

            case FLYING:
                return false;

            case PSYCHIC:
                if (secondaryType == PokemonType.DARK) {
                    return true;
                }

            case BUG:
                return false;

            case ROCK:
                return false;

            case GHOST:
                if (secondaryType == PokemonType.NORMAL) {
                    return true;
                }

            case DRAGON:
                if (secondaryType == PokemonType.FAIRY) {
                    return true;
                }

            case DARK:
                return false;

            case STEEL:
                return false;

            case FAIRY:
                return false;
        }
        return false;
    }

    private boolean isImmuneMainStat(CombatMove combatMove) {

        switch (combatMove.getMoveType()) {

            case NORMAL:
                if (mainType == PokemonType.GHOST) {
                    return true;
                }

            case FIRE:
                return false;

            case WATER:
                return false;

            case GRASS:
                return false;

            case ELECTRIC:
                if (mainType == PokemonType.GROUND) {
                    return true;
                }

            case ICE:
                return false;

            case FIGHTING:
                if (mainType == PokemonType.GHOST) {
                    return true;
                }

            case POISON:
                if (mainType == PokemonType.STEEL) {
                    return true;
                }

            case GROUND:
                if (mainType == PokemonType.FLYING) {
                    return true;
                }

            case FLYING:
                return false;

            case PSYCHIC:
                if (mainType == PokemonType.DARK) {
                    return true;
                }

            case BUG:
                return false;

            case ROCK:
                return false;

            case GHOST:
                if (mainType == PokemonType.NORMAL) {
                    return true;
                }

            case DRAGON:
                if (mainType == PokemonType.FAIRY) {
                    return true;
                }

            case DARK:
                return false;

            case STEEL:
                return false;

            case FAIRY:
                return false;
        }
        return false;
    }

    private boolean isResistantSecondaryStat(CombatMove combatMove) {

        switch (combatMove.getMoveType()) {

            case NORMAL:
                if (secondaryType == PokemonType.ROCK || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case FIRE:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.WATER || secondaryType == PokemonType.ROCK || secondaryType == PokemonType.DRAGON) {
                    return true;
                }

            case WATER:
                if (secondaryType == PokemonType.WATER || secondaryType == PokemonType.GRASS || secondaryType == PokemonType.DRAGON) {
                    return true;
                }

            case GRASS:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.GRASS || secondaryType == PokemonType.POISON || secondaryType == PokemonType.BUG || secondaryType == PokemonType.DRAGON || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case ELECTRIC:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.ELECTRIC || secondaryType == PokemonType.DRAGON) {
                    return true;
                }

            case ICE:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.WATER || secondaryType == PokemonType.ICE || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case FIGHTING:
                if (secondaryType == PokemonType.POISON || secondaryType == PokemonType.FLYING || secondaryType == PokemonType.PSYCHIC || secondaryType == PokemonType.BUG || secondaryType == PokemonType.FAIRY) {
                    return true;
                }

            case POISON:
                if (secondaryType == PokemonType.POISON || secondaryType == PokemonType.GROUND || secondaryType == PokemonType.ROCK || secondaryType == PokemonType.GHOST) {
                    return true;
                }

            case GROUND:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.BUG) {
                    return true;
                }

            case FLYING:
                if (secondaryType == PokemonType.ELECTRIC || secondaryType == PokemonType.ROCK || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case PSYCHIC:
                if (secondaryType == PokemonType.PSYCHIC || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case BUG:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.POISON || secondaryType == PokemonType.FLYING || secondaryType == PokemonType.GHOST || secondaryType == PokemonType.STEEL || secondaryType == PokemonType.FAIRY) {
                    return true;
                }

            case ROCK:
                if (secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.GROUND || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case GHOST:
                if (secondaryType == PokemonType.DARK) {
                    return true;
                }

            case DRAGON:
                if (secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case DARK:
                if (secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.DARK || secondaryType == PokemonType.FAIRY) {
                    return true;
                }

            case STEEL:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.WATER || secondaryType == PokemonType.ELECTRIC || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case FAIRY:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.DARK) {
                    return true;
                }
        }
        return false;
    }

    private boolean isResistantMainStat(CombatMove combatMove) {

        switch (combatMove.getMoveType()) {

            case NORMAL:
                if (mainType == PokemonType.ROCK || mainType == PokemonType.STEEL) {
                    return true;
                }

            case FIRE:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.WATER || mainType == PokemonType.ROCK || mainType == PokemonType.DRAGON) {
                    return true;
                }

            case WATER:
                if (mainType == PokemonType.WATER || mainType == PokemonType.GRASS || mainType == PokemonType.DRAGON) {
                    return true;
                }

            case GRASS:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.GRASS || mainType == PokemonType.POISON || mainType == PokemonType.BUG || mainType == PokemonType.DRAGON || mainType == PokemonType.STEEL) {
                    return true;
                }

            case ELECTRIC:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.ELECTRIC || mainType == PokemonType.DRAGON) {
                    return true;
                }

            case ICE:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.WATER || mainType == PokemonType.ICE || mainType == PokemonType.STEEL) {
                    return true;
                }

            case FIGHTING:
                if (mainType == PokemonType.POISON || mainType == PokemonType.FLYING || mainType == PokemonType.PSYCHIC || mainType == PokemonType.BUG || mainType == PokemonType.FAIRY) {
                    return true;
                }

            case POISON:
                if (mainType == PokemonType.POISON || mainType == PokemonType.GROUND || mainType == PokemonType.ROCK || mainType == PokemonType.GHOST) {
                    return true;
                }

            case GROUND:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.BUG) {
                    return true;
                }

            case FLYING:
                if (mainType == PokemonType.ELECTRIC || mainType == PokemonType.ROCK || mainType == PokemonType.STEEL) {
                    return true;
                }

            case PSYCHIC:
                if (mainType == PokemonType.PSYCHIC || mainType == PokemonType.STEEL) {
                    return true;
                }

            case BUG:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.FIGHTING || mainType == PokemonType.POISON || mainType == PokemonType.FLYING || mainType == PokemonType.GHOST || mainType == PokemonType.STEEL || mainType == PokemonType.FAIRY) {
                    return true;
                }

            case ROCK:
                if (mainType == PokemonType.FIGHTING || mainType == PokemonType.GROUND || mainType == PokemonType.STEEL) {
                    return true;
                }

            case GHOST:
                if (mainType == PokemonType.DARK) {
                    return true;
                }

            case DRAGON:
                if (mainType == PokemonType.STEEL) {
                    return true;
                }

            case DARK:
                if (mainType == PokemonType.FIGHTING || mainType == PokemonType.DARK || mainType == PokemonType.FAIRY) {
                    return true;
                }

            case STEEL:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.WATER || mainType == PokemonType.ELECTRIC || mainType == PokemonType.STEEL) {
                    return true;
                }

            case FAIRY:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.FIGHTING || mainType == PokemonType.DARK) {
                    return true;
                }
        }
        return false;
    }

    private boolean isSuperEffectiveSecondaryStat(CombatMove combatMove) {

        switch (combatMove.getMoveType()) {

            case NORMAL:
                return false;

            case FIRE:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.ICE || secondaryType == PokemonType.BUG || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case WATER:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.GROUND || secondaryType == PokemonType.ROCK) {
                    return true;
                }

            case GRASS:
                if (secondaryType == PokemonType.WATER || secondaryType == PokemonType.GROUND || secondaryType == PokemonType.ROCK) {
                    return true;
                }

            case ELECTRIC:
                if (secondaryType == PokemonType.WATER || secondaryType == PokemonType.FLYING) {
                    return true;
                }

            case ICE:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.GROUND || secondaryType == PokemonType.FLYING || secondaryType == PokemonType.DRAGON) {
                    return true;
                }

            case FIGHTING:
                if (secondaryType == PokemonType.NORMAL || secondaryType == PokemonType.ICE || secondaryType == PokemonType.BUG || secondaryType == PokemonType.DARK || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case POISON:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.FAIRY) {
                    return true;
                }

            case GROUND:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.ELECTRIC || secondaryType == PokemonType.POISON || secondaryType == PokemonType.ROCK || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case FLYING:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.BUG) {
                    return true;
                }

            case PSYCHIC:
                if (secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.POISON || secondaryType == PokemonType.BUG || secondaryType == PokemonType.STEEL) {
                    return true;
                }

            case BUG:
                if (secondaryType == PokemonType.GRASS || secondaryType == PokemonType.PSYCHIC || secondaryType == PokemonType.DARK) {
                    return true;
                }

            case ROCK:
                if (secondaryType == PokemonType.FIRE || secondaryType == PokemonType.ELECTRIC || secondaryType == PokemonType.FLYING || secondaryType == PokemonType.BUG) {
                    return true;
                }

            case GHOST:
                if (secondaryType == PokemonType.PSYCHIC || secondaryType == PokemonType.GHOST) {
                    return true;
                }

            case DRAGON:
                if (secondaryType == PokemonType.DRAGON) {
                    return true;
                }

            case DARK:
                if (secondaryType == PokemonType.PSYCHIC || secondaryType == PokemonType.GHOST) {
                    return true;
                }

            case STEEL:
                if (secondaryType == PokemonType.ICE || secondaryType == PokemonType.ROCK || secondaryType == PokemonType.FAIRY) {
                    return true;
                }

            case FAIRY:
                if (secondaryType == PokemonType.FIGHTING || secondaryType == PokemonType.DRAGON || secondaryType == PokemonType.DARK) {
                    return true;
                }
        }
        return false;
    }

    public boolean getIsFainted() {
        return isFainted;
    }

    public void setIsFainted(boolean bol) {
        this.isFainted = bol;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public boolean isSuperEffectiveMainStat(CombatMove combatMove) {

        switch (combatMove.getMoveType()) {

            case NORMAL:
                return false;

            case FIRE:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.ICE || mainType == PokemonType.BUG || mainType == PokemonType.STEEL) {
                    return true;
                }

            case WATER:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.GROUND || mainType == PokemonType.ROCK) {
                    return true;
                }

            case GRASS:
                if (mainType == PokemonType.WATER || mainType == PokemonType.GROUND || mainType == PokemonType.ROCK) {
                    return true;
                }

            case ELECTRIC:
                if (mainType == PokemonType.WATER || mainType == PokemonType.FLYING) {
                    return true;
                }

            case ICE:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.GROUND || mainType == PokemonType.FLYING || mainType == PokemonType.DRAGON) {
                    return true;
                }

            case FIGHTING:
                if (mainType == PokemonType.NORMAL || mainType == PokemonType.ICE || mainType == PokemonType.BUG || mainType == PokemonType.DARK || mainType == PokemonType.STEEL) {
                    return true;
                }

            case POISON:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.FAIRY) {
                    return true;
                }

            case GROUND:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.ELECTRIC || mainType == PokemonType.POISON || mainType == PokemonType.ROCK || mainType == PokemonType.STEEL) {
                    return true;
                }

            case FLYING:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.FIGHTING || mainType == PokemonType.BUG) {
                    return true;
                }

            case PSYCHIC:
                if (mainType == PokemonType.FIGHTING || mainType == PokemonType.POISON || mainType == PokemonType.BUG || mainType == PokemonType.STEEL) {
                    return true;
                }

            case BUG:
                if (mainType == PokemonType.GRASS || mainType == PokemonType.PSYCHIC || mainType == PokemonType.DARK) {
                    return true;
                }

            case ROCK:
                if (mainType == PokemonType.FIRE || mainType == PokemonType.ELECTRIC || mainType == PokemonType.FLYING || mainType == PokemonType.BUG) {
                    return true;
                }

            case GHOST:
                if (mainType == PokemonType.PSYCHIC || mainType == PokemonType.GHOST) {
                    return true;
                }

            case DRAGON:
                if (mainType == PokemonType.DRAGON) {
                    return true;
                }

            case DARK:
                if (mainType == PokemonType.PSYCHIC || mainType == PokemonType.GHOST) {
                    return true;
                }

            case STEEL:
                if (mainType == PokemonType.ICE || mainType == PokemonType.ROCK || mainType == PokemonType.FAIRY) {
                    return true;
                }

            case FAIRY:
                if (mainType == PokemonType.FIGHTING || mainType == PokemonType.DRAGON || mainType == PokemonType.DARK) {
                    return true;
                }
        }
        return false;
    }

}