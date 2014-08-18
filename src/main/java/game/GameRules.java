package main.java.game;

import java.util.Scanner;

public class GameRules {

    private static final String INIT_MESSAGE = "\nПереместите костяшку. Введите 2, 4, 6 или 8:  ";

    private static int enterNumber() {
        Scanner scanner = new Scanner(System.in);
        int enteredNumber = 0;

        System.out.print(INIT_MESSAGE);

        if(scanner.hasNextInt()) {
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
            case 0:
                stopGame();
                break;
            default:
                System.out.println("Вы можете ввести только 2, 4, 6 или 8");
                break;
        }
    }

    private static void stopGame() {
    }

    private static void moveNumber(Direction direction) {
        System.out.println("\nmoving number " + direction.toString() + "...");

        GameMechanic.replace(direction);

        GameField.displayGameField();
    }

    public static void runGame() {
        do {
            play();
        } while (GameMechanic.isCompletedGame());
    }

}
