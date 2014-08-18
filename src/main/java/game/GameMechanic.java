package main.java.game;

public class GameMechanic {

    private static final int[][] WIN_COMBINATION = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
    };

    private static void replaceAccordingDirection(int i, int j, Direction direction) {

        switch (direction) {
            case DOWN:
                replaceDown(i, j);
                break;
            case UP:
                replaceUp(i, j);
                break;
            case RIGHT:
                replaceRight(i, j);
                break;
            case LEFT:
                replaceLeft(i, j);
                break;
            default:
                showError();
                break;
        }
    }

    private static void replaceRight(int i, int j) {
        int number;
        if (j - 1 >= 0) {
            number = GameField.getFieldArray()[i][j - 1];
            GameField.getFieldArray()[i][j] = number;
            GameField.getFieldArray()[i][j - 1] = 0;
        } else {
            showError();
        }
    }

    private static void replaceDown(int i, int j) {
        int number;
        if (i - 1 >= 0) {
            number = GameField.getFieldArray()[i - 1][j];
            GameField.getFieldArray()[i][j] = number;
            GameField.getFieldArray()[i - 1][j] = 0;
        } else {
            showError();
        }
    }

    private static void replaceUp(int i, int j) {
        int number;
        if (i + 1 < GameField.getFieldArray()[i].length) {
            number = GameField.getFieldArray()[i + 1][j];
            GameField.getFieldArray()[i][j] = number;
            GameField.getFieldArray()[i + 1][j] = 0;
        } else {
            showError();
        }
    }

    private static void replaceLeft(int i, int j) {
        int number;
        if (j + 1 < GameField.getFieldArray()[j].length) {
            number = GameField.getFieldArray()[i][j + 1];
            GameField.getFieldArray()[i][j] = number;
            GameField.getFieldArray()[i][j + 1] = 0;
        } else {
            showError();
        }
    }

    private static void showError() {
        System.out.println("Вы не можете сделать такой ход!");
    }

    public static void replace(Direction direction) {
        for (int i = 0; i < GameField.getFieldArray().length; i++) {
            for (int j = 0; j < GameField.getFieldArray()[i].length; j++) {
                if (GameField.getFieldArray()[i][j] == 0) {
                    replaceAccordingDirection(i, j, direction);
                    break;
                }
            }
        }
    }

    public static boolean isCompletedGame() {
        return GameField.getFieldArray() != WIN_COMBINATION;
    }

}
