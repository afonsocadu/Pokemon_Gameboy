package org.academiadecodigo.teamgreen.pokemon.Map;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.teamgreen.pokemon.Actors.*;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.CombatMove;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.PhysSpec;
import org.academiadecodigo.teamgreen.pokemon.BattleLogic.PokemonType;
import org.academiadecodigo.teamgreen.pokemon.Map.Items.*;
import org.academiadecodigo.teamgreen.pokemon.Settings.GameSettings;

public class WorldMap {

    public static ItemOfMap[][] itemsOfMap;
    public static Picture background;

    public WorldMap() {
        itemsOfMap = new ItemOfMap[GameSettings.ARRAY_BACKGROUND_WIDTH_LENGTH][GameSettings.ARRAY_BACKGROUND_HEIGHT_LENGTH];
        background = new Picture(0, 0, "background.png");

        background.draw();

        for (int x = 0; x < GameSettings.ARRAY_BACKGROUND_WIDTH_LENGTH; x++) {
            for(int y = 0; y < GameSettings.ARRAY_BACKGROUND_HEIGHT_LENGTH; y++) {
                itemsOfMap[x][y] = new blankSpace();
            }
        }

        makeBorder();
        makeMap();
    }

    /*
        *** TO DRAW MAP HERE (makeMap)  ***
    */
    private void makeMap() {

        makeImpassableTerrain(GameSettings.WIDTH/2-12*16, GameSettings.HEIGHT/2-6*16);



        // ----- HOUSES AND DOORS-----

        makeHouseSmall(32, 32);
        makeHouseSmall(96, 32);
        makeHouseSmall(480, 576);
        makeHouseSmall(1088,496);
        makeHouseSmall(1152,496);
        makeHouseSmall(1216,496);
        makeHouseSmall(1024,560);
        makeHouseSmall(1280,560);

        makeHouseLarge(32, 400);

        makeLaboratory(496, 112);

        makeHouseTemple(1392, 80);

        // ----- WATER -----

        for(int x=212; x < 404; x+=32){
            for(int y = 544; y < 640; y+=32){
                makeWater(x,y);
            }
        }

        for(int x=1024; x < 1344; x+=32){
            for(int y = 176; y < 336; y+=32){
                makeWater(x,y);
            }
        }
        for(int x=992; x < 1024; x+=32){
            for(int y = 208; y < 304; y+=32){
                makeWater(x,y);
            }
        }

        for(int x=1344; x < 1376; x+=32){
            for(int y = 208; y < 304; y+=32){
                makeWater(x,y);
            }
        }

        for(int x=1056; x < 1312; x+=32){
            for(int y = 144; y < 240; y+=32){
                makeWater(x,y);
            }
        }

        for(int x=1056; x < 1312; x+=32){
            for(int y = 336; y < 368; y+=32){
                makeWater(x,y);
            }
        }

        // ----- GRASS -----

        new Picture(32,240,"grassTwo.png").draw();
        new Picture(172,32,"grassOne.png").draw();
        new Picture(160,240,"grassThree.png").draw();
        new Picture(764,32,"grassFour.png").draw();


        // ----- TREES -----

        makeSmallTree(224,640,11,1);
        makeSmallTree(192,560,1,4);
        makeSmallTree(1040,128,1,2);
        makeSmallTree(1008,160,3,1);
        makeSmallTree(1008,176,1,1);
        makeSmallTree(1008,320,1,1);
        makeSmallTree(976,192,3,1);
        makeSmallTree(976,304,3,1);
        makeSmallTree(1008,336,3,1);
        makeSmallTree(1040,352,1,2);

        makeMediumTree(32, 208);
        makeMediumTree(64, 208);
        makeMediumTree(96, 208);
        makeMediumTree(160, 208);
        makeMediumTree(192,208);
        makeMediumTree(224,208);
        makeMediumTree(256,208);
        makeMediumTree(256,176);
        makeMediumTree(256,144);
        makeMediumTree(192,528);
        makeMediumTree(192,624);
        makeMediumTree(400,528);
        makeMediumTree(400,624);

        for(int x = 128; x < 992; x +=32){
            makeMediumTree(x,0);
        }

        for(int x = 992; x < GameSettings.WIDTH -32; x +=32){
            for(int y = 0; y < 64; y+=32){
                makeMediumTree(x,y);
            }
        }

        for(int y = 128; y < 256;y +=32){
            makeMediumTree(672,y);
        }

        for(int x = 352; x < 576; x += 32){
            makeMediumTree(x,432);
        }

        for(int x = 1032; x < 1096; x += 32){
            for (int y = 496; y < 557; y += 32){
                makeMediumTree(x, y);
            }
        }

        for(int x = 1000; x < 1032; x += 32){
            for (int y = 496; y < 656; y += 32){
                makeMediumTree(x, y);
            }
        }

        for(int x = 1280; x < 1344; x += 32){
            for (int y = 496; y < 560; y += 32){
                makeMediumTree(x, y);
            }
        }

        makeMediumTree(1312,624);

        for(int x = 1000; x < 1320; x += 32){
            for (int y = 464; y < 496; y += 32){
                makeMediumTree(x, y);
            }
        }

        for(int x = 464; x < 496; x += 32){
            for (int y = 112; y < 208; y += 32){
                makeMediumTree(x, y);
            }
        }



        for(int x=1472; x < 1520; x+=32){
            for(int y = 192; y < 448; y+=32){
                makeBigTree(x,y);
            }
        }

        for(int x=1376; x < 1520; x+=32){
            for(int y = 448; y < 736; y+=32){
                makeBigTree(x,y);
            }
        }

        for(int x=1472; x < 1520; x+=32){
            for(int y = 64; y < 188; y+=32){
                makeBigTree(x,y);
            }
        }


    /*    // ----- FLOWERS -----

        makeFlower(172,32,7,4);
        makeFlower(32,240,6,5);
        makeFlower(172,240,8,5);
        makeFlower(224,528,11,1);
        makeFlower(400,560,1,4);
        makeFlower(764,32,12,10);
        makeFlower(976,208,1,6);
        makeFlower(1376,208,1,6);
        makeFlower(1056,128,16,1);
        makeFlower(1056,368,16,1);
*/

        Pokemon placeholder2 = new Pokemon();
        Pokemon placeholder3 = new Pokemon();
        Pokemon placeholder4 = new Pokemon();
        Pokemon placeholder5 = new Pokemon();
        Pokemon placeholder6 = new Pokemon();

        //CombatMove shadowPunch = new CombatMove("Shadow Punch", PokemonType.GHOST, PhysSpec.PHYSICAL, 60, 101, 20);
        //CombatMove poisonJab = new CombatMove("Poison Jab", PokemonType.POISON, PhysSpec.PHYSICAL,80, 100, 20, 30);
        //CombatMove bite = new CombatMove("Bite", PokemonType.DARK, PhysSpec.PHYSICAL, 60, 100, 25);
        //CombatMove flameCharge = new CombatMove("Flame Charge", PokemonType.FIRE, PhysSpec.PHYSICAL, 50, 100, 20);
        //CombatMove waterPulse = new CombatMove("Water Pulse", PokemonType.WATER, PhysSpec.SPECIAL, 60, 100, 20);
        //CombatMove waterPulse = new CombatMove("Water Pulse", PokemonType.WATER, PhysSpec.SPECIAL, 60, 100, 20);

        CombatMove[] gengarCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        gengarCombatMoves[0] = new CombatMove("Shadow Punch", PokemonType.GHOST, PhysSpec.PHYSICAL, 60, 101, 20);
        CombatMove[] beedrillCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        beedrillCombatMoves[0] = new CombatMove("Poison Jab", PokemonType.POISON, PhysSpec.PHYSICAL,80, 100, 20, 30);
        CombatMove[] mukCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        mukCombatMoves[0] = new CombatMove("Bite", PokemonType.DARK, PhysSpec.PHYSICAL, 60, 100, 25);
        CombatMove[] poochyenaCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        poochyenaCombatMoves[0] = new CombatMove("Bite", PokemonType.DARK, PhysSpec.PHYSICAL, 60, 100, 25);
        CombatMove[] blazikenCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        blazikenCombatMoves[0] = new CombatMove("Flame Charge", PokemonType.FIRE, PhysSpec.PHYSICAL, 50, 100, 20);
        CombatMove[] omastarCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        omastarCombatMoves[0] = new CombatMove("Water Pulse", PokemonType.WATER, PhysSpec.SPECIAL, 60, 100, 20);
        CombatMove[] umbreonCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        umbreonCombatMoves[0] = new CombatMove("Bite", PokemonType.DARK, PhysSpec.PHYSICAL, 60, 100, 25);
        CombatMove[] blastoiseCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        blastoiseCombatMoves[0] = new CombatMove("Water Pulse", PokemonType.WATER, PhysSpec.SPECIAL, 60, 100, 20);
        CombatMove[] charizardCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        charizardCombatMoves[0] = new CombatMove("Flame Charge", PokemonType.FIRE, PhysSpec.PHYSICAL, 50, 100, 20);
        CombatMove[] vaporeonCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        vaporeonCombatMoves[0] = new CombatMove("Water Pulse", PokemonType.WATER, PhysSpec.SPECIAL, 60, 100, 20);
        CombatMove[] flareonCombatMoves = new CombatMove[GameSettings.MAX_COMBAT_MOVE_NUMBER];
        flareonCombatMoves[0] = new CombatMove("Flame Charge", PokemonType.FIRE, PhysSpec.PHYSICAL, 50, 100, 20);


        //Pokemon gengar = new Pokemon("Gengar", PokemonType.GHOST, PokemonType.POISON, 0, 0, "gen gen", "gengar_front.png", gengarCombatMoves, 65, 60, 60, 130, 75, 110);
        //Pokemon beedrill = new Pokemon("Beedrill", PokemonType.BUG, PokemonType.POISON, 0, 0, "bee bee", "beedrill_front.png", beedrillCombatMoves, 90, 40, 65, 45, 80, 75);
        //Pokemon muk = new Pokemon("Muk", PokemonType.POISON, PokemonType.NONE, 0, 0, "muk muk", "muk_front.png", mukCombatMoves, 105, 75, 105, 65, 100, 50);
        //Pokemon poochyena = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);
        //Pokemon blaziken = new Pokemon("Blaziken", PokemonType.FIRE, PokemonType.FIGHTING, 0, 0, "blaz blaz", "blaziken_front.png", blazikenCombatMoves, 120, 70, 80, 110, 70, 80);
        //Pokemon omastar = new Pokemon("Omastar", PokemonType.ROCK, PokemonType.WATER, 0, 0, "omas omas", "omastar_front.png", omastarCombatMoves, 60, 125, 70, 115, 70, 55);
        //Pokemon umbreon = new Pokemon("Umbreon", PokemonType.DARK, PokemonType.NONE, 0, 0, "umb umb", "umbreon_front.png", umbreonCombatMoves, 65, 110, 95, 60, 130, 65);
        //Pokemon blastoise = new Pokemon("Blastoise", PokemonType.WATER, PokemonType.NONE, 0, 0, "blas blas", "blastoise_front.png", blastoiseCombatMoves, 83, 100, 79, 85, 105, 78);
        //Pokemon charizard = new Pokemon("Charizard", PokemonType.FIRE, PokemonType.FLYING, 0, 0, "char char", "charizard_front.png", charizardCombatMoves, 130, 111, 78, 130, 85, 100);
        //Pokemon vaporeon = new Pokemon("Vaporeon", PokemonType.WATER, PokemonType.NONE, 0, 0, "vap vap", "vaporeon_front.png", vaporeonCombatMoves, 65, 60, 130, 110, 95, 65);
        //Pokemon flareon = new Pokemon("Flareon", PokemonType.FIRE, PokemonType.NONE, 0, 0, "fla fla", "flareon_front.png", flareonCombatMoves, 130, 60, 65, 95, 110, 65);

        Pokemon[] magmaGruntOne = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        magmaGruntOne[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);
        magmaGruntOne[1] = new Pokemon("Muk", PokemonType.POISON, PokemonType.NONE, 0, 0, "muk muk", "muk_front.png", mukCombatMoves, 105, 75, 105, 65, 100, 50);
        magmaGruntOne[2] = placeholder3;
        magmaGruntOne[3] = placeholder4;
        magmaGruntOne[4] = placeholder5;
        magmaGruntOne[5] = placeholder6;
        makeTrainer(128, 96, "We will release Groundon and destroy all the seas! A mere child will not stop us.", magmaGruntOne, EnemyType.MAGMA_GRUNT);

        Pokemon[] magmaGruntTwo = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        magmaGruntTwo[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);
        magmaGruntTwo[1] = new Pokemon("Gengar", PokemonType.GHOST, PokemonType.POISON, 0, 0, "gen gen", "gengar_front.png", gengarCombatMoves, 65, 60, 60, 130, 75, 110);
        magmaGruntTwo[2] = placeholder3;
        magmaGruntTwo[3] = placeholder4;
        magmaGruntTwo[4] = placeholder5;
        magmaGruntTwo[5] = placeholder6;
        makeTrainer(240, 240, "Ours is a righteous cause, we are making land for people and pokemon alike! Get ready to be defeated.", magmaGruntTwo, EnemyType.MAGMA_GRUNT);

        Pokemon[] magmaGruntThree = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        magmaGruntThree[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);;
        magmaGruntThree[1] = new Pokemon("Muk", PokemonType.POISON, PokemonType.NONE, 0, 0, "muk muk", "muk_front.png", mukCombatMoves, 105, 75, 105, 65, 100, 50);
        magmaGruntThree[2] = new Pokemon("Flareon", PokemonType.FIRE, PokemonType.NONE, 0, 0, "fla fla", "flareon_front.png", flareonCombatMoves, 130, 60, 65, 95, 110, 65);
        magmaGruntThree[3] = placeholder4;
        magmaGruntThree[4] = placeholder5;
        magmaGruntThree[5] = placeholder6;
        makeTrainer(400, 400, "If you will not help us defeat Team Aqua then you shall join them in defeat! Prepare to battle!", magmaGruntThree, EnemyType.MAGMA_GRUNT);

        Pokemon[] aquaGruntOne = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        aquaGruntOne[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);;
        aquaGruntOne[1] = new Pokemon("Umbreon", PokemonType.DARK, PokemonType.NONE, 0, 0, "umb umb", "umbreon_front.png", umbreonCombatMoves, 65, 110, 95, 60, 130, 65);
        aquaGruntOne[2] = placeholder3;
        aquaGruntOne[3] = placeholder4;
        aquaGruntOne[4] = placeholder5;
        aquaGruntOne[5] = placeholder6;
        makeTrainer(560, 464, "The day that Kyogre rises forth and drowns all the land beneath the wave grows closer! You will not stop us!", aquaGruntOne, EnemyType.AQUA_GRUNT);

        Pokemon[] aquaGruntTwo = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        aquaGruntTwo[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);;
        aquaGruntTwo[1] = new Pokemon("Gengar", PokemonType.GHOST, PokemonType.POISON, 0, 0, "gen gen", "gengar_front.png", gengarCombatMoves, 65, 60, 60, 130, 75, 110);
        aquaGruntTwo[2] = placeholder3;
        aquaGruntTwo[3] = placeholder4;
        aquaGruntTwo[4] = placeholder5;
        aquaGruntTwo[5] = placeholder6;
        makeTrainer(320, 32, "Water is the source of all life! We will return this planet to its primordial state and life will flourish once again!", aquaGruntTwo, EnemyType.AQUA_GRUNT);

        Pokemon[] aquaGruntThree = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        aquaGruntThree[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);;
        aquaGruntThree[1] = new Pokemon("Umbreon", PokemonType.DARK, PokemonType.NONE, 0, 0, "umb umb", "umbreon_front.png", umbreonCombatMoves, 65, 110, 95, 60, 130, 65);
        aquaGruntThree[2] = new Pokemon("Vaporeon", PokemonType.WATER, PokemonType.NONE, 0, 0, "vap vap", "vaporeon_front.png", vaporeonCombatMoves, 65, 60, 130, 110, 95, 65);
        aquaGruntThree[3] = placeholder4;
        aquaGruntThree[4] = placeholder5;
        aquaGruntThree[5] = placeholder6;
        makeTrainer(416, 352, "You and all of Team Magma stand no chance against us. What can you do against our might?", aquaGruntThree, EnemyType.AQUA_GRUNT);

        Pokemon[] magmaBoss = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        magmaBoss[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);
        magmaBoss[1] = new Pokemon("Blaziken", PokemonType.FIRE, PokemonType.FIGHTING, 0, 0, "blaz blaz", "blaziken_front.png", blazikenCombatMoves, 120, 70, 80, 110, 70, 80);;
        magmaBoss[2] = new Pokemon("Flareon", PokemonType.FIRE, PokemonType.NONE, 0, 0, "fla fla", "flareon_front.png", flareonCombatMoves, 130, 60, 65, 95, 110, 65);
        magmaBoss[3] = new Pokemon("Charizard", PokemonType.FIRE, PokemonType.FLYING, 0, 0, "char char", "charizard_front.png", charizardCombatMoves, 130, 111, 78, 130, 85, 100);
        magmaBoss[4] = placeholder5;
        magmaBoss[5] = placeholder6;
        makeTrainer(70*16, 37*16, "You really think you can stop us? Groundon will awaken and the seas will dry. Do not meddle in our will child. Begone.", magmaBoss, EnemyType.MAGMA_BOSS);

        Pokemon[] aquaBoss = new Pokemon[GameSettings.MAX_POKEMON_TEAM_NUMBER];
        aquaBoss[0] = new Pokemon("Poochyena", PokemonType.DARK, PokemonType.NONE, 0, 0, "pooch pooch", "poochyena_front.png", poochyenaCombatMoves, 55, 35, 35, 30, 30, 35);;
        aquaBoss[1] = new Pokemon("Omastar", PokemonType.ROCK, PokemonType.WATER, 0, 0, "omas omas", "omastar_front.png", omastarCombatMoves, 60, 125, 70, 115, 70, 55);
        aquaBoss[2] = new Pokemon("Vaporeon", PokemonType.WATER, PokemonType.NONE, 0, 0, "vap vap", "vaporen_front.png", vaporeonCombatMoves, 65, 60, 130, 110, 95, 65);
        aquaBoss[3] = new Pokemon("Blastoise", PokemonType.WATER, PokemonType.NONE, 0, 0, "blas blas", "blastoise_front.png", blastoiseCombatMoves, 83, 100, 79, 85, 105, 78);
        aquaBoss[4] = placeholder5;
        aquaBoss[5] = placeholder6;
        makeTrainer(74*GameSettings.IMG_PIXEL_SIZE, 6*GameSettings.IMG_PIXEL_SIZE, "Kyogre is the one and only who can save this planet and bring forth a stable place for all of life to flourish. I can not allow you to stop me", aquaBoss, EnemyType.AQUA_BOSS);

        Healer healer = new Healer(20*GameSettings.IMG_PIXEL_SIZE, 41*GameSettings.IMG_PIXEL_SIZE, false, "Hello! I have stayed behind to heal any trainer that wishes to challenge Team Magma and Team Aqua! They have to be stopped! Allow me to heal your Pokemon back to full health.");
        itemsOfMap[20][41] = healer;

        Person oldMan = new Person(19*GameSettings.IMG_PIXEL_SIZE, 41*GameSettings.IMG_PIXEL_SIZE, false, "Please help us! Team Magma and Team Aqua have invaded the city intent on waking the Legendary Pokemon that sleep in the cave next to our city. The inhabitants have fled but Team Magma and Team Aqua must be stopped! Or else the world will end!!!", "old_man_front.png");
        itemsOfMap[19][41] = oldMan;

        makeMewTruck();

    }

    // -------------------- <MAKERS> --------------------
    private void makeBorder() {
        // Top and Bottom
        for(int i = 0; i < 49; i++) {
            makeMediumTree(i*32, 0);
            makeMediumTree(i*32, (GameSettings.HEIGHT - (32 + 16)));
        }

        // Left and Right
        for(int i = 1; i < 23; i++) {
            makeMediumTree(0, i*32);
            makeMediumTree((GameSettings.WIDTH - (32 + 16)), i*32);
        }
    }

    // ----- HOUSES -----

    private void makeHouseSmall(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 4;
        int numberOfSquaresInColumn = 4;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new House(x, y,HouseType.SMALL);
                }
                else if(arrayX == logicalX+1 && arrayY == logicalY+3){
                    itemsOfMap[arrayX][arrayY] = new Door(arrayX*GameSettings.IMG_PIXEL_SIZE, arrayY*GameSettings.IMG_PIXEL_SIZE-9);
                }
                else {
                    itemsOfMap[arrayX][arrayY] = new House();
                }
            }
        }
    }

    private void makeHouseMedium(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 4;
        int numberOfSquaresInColumn = 4;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new House(x, y, HouseType.MEDIUM);
                }
                else if(arrayX == logicalX+1 && arrayY == logicalY+3){
                    itemsOfMap[arrayX][arrayY] = new Door(arrayX*GameSettings.IMG_PIXEL_SIZE, arrayY*GameSettings.IMG_PIXEL_SIZE-9);
                }
                else {
                    itemsOfMap[arrayX][arrayY] = new House();
                }
            }
        }
    }

    private void makeHouseLarge(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 5;
        int numberOfSquaresInColumn = 5;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new House(x, y, HouseType.LARGE);
                }
                else if(arrayX == logicalX+3 && arrayY == logicalY+4){
                    itemsOfMap[arrayX][arrayY] = new Door(arrayX*GameSettings.IMG_PIXEL_SIZE, arrayY*GameSettings.IMG_PIXEL_SIZE-9);
                }
                else {
                    itemsOfMap[arrayX][arrayY] = new House();
                }
            }
        }
    }

    private void makeLaboratory(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 7;
        int numberOfSquaresInColumn = 5;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new House(x, y, HouseType.LABORATORY);
                }
                else if(arrayX == logicalX+4 && arrayY == logicalY+4){
                    itemsOfMap[arrayX][arrayY] = new Door(arrayX*GameSettings.IMG_PIXEL_SIZE, arrayY*GameSettings.IMG_PIXEL_SIZE-9);
                }
                else {
                    itemsOfMap[arrayX][arrayY] = new House();
                }
            }
        }
    }

    private void makeHouseTemple(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 4;
        int numberOfSquaresInColumn = 4;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new House(x, y, HouseType.TEMPLE);
                }
                else if(arrayX == logicalX+1 && arrayY == logicalY+3){
                    itemsOfMap[arrayX][arrayY] = new House(false);
                }
                else {
                    itemsOfMap[arrayX][arrayY] = new House();
                }
            }
        }
    }

    // ----- WATER -----

    private void makeWater(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 2;
        int numberOfSquaresInColumn = 2;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new Water(x, y);
                } else {
                    itemsOfMap[arrayX][arrayY] = new Water();
                }
            }
        }
    }


    // ----- GRASS -----

    private void makeGrass(int x, int y, int numberOfGrassX, int numberOfGrassY){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfGrassX; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfGrassY; arrayY++) {
                itemsOfMap[arrayX][arrayY] = new Grass(16*arrayX, 16*arrayY);
            }
        }
    }


    // ----- TREES -----


    private void makeSmallTree(int x, int y, int numberOfSmallTreeX, int numberOfSmallTreeY){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSmallTreeX; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSmallTreeY; arrayY++) {
                itemsOfMap[arrayX][arrayY] = new Tree(16*arrayX, 16*arrayY, TreeType.SMALL);
            }
        }
    }


    private void makeMediumTree(int x, int y){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 2;
        int numberOfSquaresInColumn = 2;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if(logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new Tree(x, y, TreeType.MEDIUM);
                } else {
                    itemsOfMap[arrayX][arrayY] = new Tree();
                }
            }
        }
    }


    private void makeBigTree(int x, int y) {
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        int numberOfSquaresInLine = 2;
        int numberOfSquaresInColumn = 3;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfSquaresInLine; arrayX++) {
            for (int arrayY = logicalY; arrayY < logicalY + numberOfSquaresInColumn; arrayY++) {
                if (logicalX == arrayX && logicalY == arrayY) {
                    itemsOfMap[arrayX][arrayY] = new Tree(x, y, TreeType.BIG);
                } else {
                    itemsOfMap[arrayX][arrayY] = new Tree();
                }
            }
        }
    }


    // ----- FLOWERS -----

    private void makeFlower(int x, int y, int numberOfFlowerX, int numberOfFlowerY){
        int logicalX = x / GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y / GameSettings.IMG_PIXEL_SIZE;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfFlowerX; arrayX++) {
            for(int arrayY = logicalY; arrayY < logicalY + numberOfFlowerY; arrayY++) {
                itemsOfMap[arrayX][arrayY] = new Flower(16*arrayX, 16*arrayY);
            }
        }
    }


    // ----- TRAINERS -----

    private void makeTrainer(int x, int y, String dialog, Pokemon[] trainerPokemonTeam, EnemyType enemyType) {
        // Trainer is  16 x 16 px
        itemsOfMap[x/GameSettings.IMG_PIXEL_SIZE][y/GameSettings.IMG_PIXEL_SIZE] = new Trainer(x,y, dialog, trainerPokemonTeam, enemyType);
    }


    // ----- IMPASSABLE TERRAIN -----

    private void makeImpassableTerrain(int x, int y){
        int xOffset = 34;
        int yOffset = -37;
        int logicalX = x/ GameSettings.IMG_PIXEL_SIZE;
        int logicalY = y/ GameSettings.IMG_PIXEL_SIZE;



        itemsOfMap[logicalX][logicalY] = new ImpassableBlock(x+xOffset, y+yOffset, "impassableCenter.png");

        for (int arrayX = logicalX+3; arrayX < logicalX+22; arrayX++) {
            for(int arrayY = logicalY-2; arrayY < logicalY+28; arrayY++) {
                itemsOfMap[arrayX][arrayY] = new ImpassableBlock(16*arrayX, 16*arrayY);
            }
        }
    }

    public void makeMewTruck(){

        Truck truck = new Truck(35*GameSettings.IMG_PIXEL_SIZE, 37*GameSettings.IMG_PIXEL_SIZE);
        for (int i = 35; i < 38; i++){
            for (int j = 37; j < 39; j++){
                itemsOfMap[i][j] = new Truck();
            }
        }

    }

    // </Makers>
}