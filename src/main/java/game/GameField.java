package main.java.game;

import java.util.ArrayList;
import java.util.Collections;

public class GameField {

    private static int[][] fieldArray = new int[4][4];

    private static ArrayList<Integer> list = new ArrayList<Integer>();

    private static void randomizeNumbers() {
        for (int i = 0; i < 16; i++){
            list.add(i);
        }

        Collections.shuffle(list);
    }

    private static void fillOutField() {
        randomizeNumbers();

        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                fieldArray[i][j] = list.get(count++);
            }
        }
    }

    private static void showNumbers(int number) {
        if (number == 0) {
            System.out.print("  |");
        } else {
            fitNumberToCell(number);
        }
    }

    private static void fitNumberToCell(int number) {
        if (number >= 10) {
            System.out.print(number + "|");
        } else {
            System.out.print(number + " |");
        }
    }

    public static void initializeGameField() {
        fillOutField();
        displayGameField();
    }

    public static void displayGameField() {
        for (int i = 0; i < fieldArray.length; i++, System.out.println()) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                showNumbers(fieldArray[i][j]);
            }
        }
    }

    public static int[][] getFieldArray() {
        return fieldArray;
    }
}
