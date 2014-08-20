package main.java.game;

import java.util.ArrayList;
import java.util.Collections;

public class GameField {

    private static final int[][] GAME_FIELD = new int[4][4];

    private static final ArrayList<Integer> LIST = new ArrayList<>();

    private static void randomizeNumbers() {
        for (int i = 0; i < GAME_FIELD.length * GAME_FIELD.length; i++){
            LIST.add(i);
        }
        Collections.shuffle(LIST);
    }

    private static void fillOutField() {
        randomizeNumbers();

        int listIndex = 0;
        for (int i = 0; i < GAME_FIELD.length; i++) {
            for (int j = 0; j < GAME_FIELD[i].length; j++) {
                GAME_FIELD[i][j] = LIST.get(listIndex++);
            }
        }
    }

    private static void showNumbers(int number) {
        if (number == 0) System.out.print("  |");
        else fitNumberToCell(number);
    }

    private static void fitNumberToCell(int number) {
        if (number >= 10) System.out.print(number + "|");
        else System.out.print(number + " |");
    }

    public static void initializeGameField() {
        fillOutField();
        displayGameField();
    }

    public static void displayGameField() {
        for (int i = 0; i < GAME_FIELD.length; i++, System.out.println()) {
            for (int j = 0; j < GAME_FIELD[i].length; j++) {
                showNumbers(GAME_FIELD[i][j]);
            }
        }
    }

    public static int[][] getGameField() {
        return GAME_FIELD;
    }
}