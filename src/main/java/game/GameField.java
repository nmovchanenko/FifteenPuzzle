package main.java.game;

import java.util.ArrayList;
import java.util.Collections;

public class GameField {

    private static int[][] gameField = new int[4][4];

    private static ArrayList<Integer> list = new ArrayList<Integer>();

    private static void randomizeNumbers() {
        for (int i = 0; i < 16; i++){
            list.add(i);
        }
        Collections.shuffle(list);
    }

    private static void fillOutField() {
        randomizeNumbers();
        int listIndex = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = list.get(listIndex++);
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
        for (int i = 0; i < gameField.length; i++, System.out.println()) {
            for (int j = 0; j < gameField[i].length; j++) {
                showNumbers(gameField[i][j]);
            }
        }
    }

    public static int[][] getGameField() {
        return gameField;
    }
}
