package main.java.game;

import java.util.Arrays;
import java.util.Scanner;

public class GameRules {

    private static final int[][] WIN_COMBINATION = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
    };

    private static int enterNumber() {
        Scanner scanner = new Scanner(System.in);
        int enteredNumber = 0;

        System.out.print("\nПереместите костяшку. Введите 2, 4, 6 или 8:  ");

        if (scanner.hasNextInt()) {
            enteredNumber = scanner.nextInt();
        } else {
            System.out.println("Вы можете вводить только числа");
        }

        return enteredNumber;
    }


    private static void play() {
        switch (enterNumber()) {
            case 2:
                moveNumber(Direction.DOWN);
                break;
            case 4:
                moveNumber(Direction.RIGHT);
                break;
            case 6:
                moveNumber(Direction.LEFT);
                break;
            case 8:
                moveNumber(Direction.UP);
                break;
            default:
                System.out.println("Вы можете ввести только 2, 4, 6 или 8");
                break;
        }
    }

    private static void moveNumber(Direction direction) {
        System.out.println("\nmoving number " + direction.toString() + "...");
        GameMechanic.replace(direction);
        GameField.displayGameField();
    }

    private static boolean isCompletedGame() {
        return Arrays.deepEquals(GameField.getGameField(), WIN_COMBINATION);
    }

    public static void runGame() {
        do play();
        while (!isCompletedGame());

        System.out.println("\nCONGRATS, YOU WIN!");
    }
}