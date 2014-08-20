package main.java.game;

public class GameMechanic {

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
                break;
        }
    }

    private static void replaceRight(int i, int j) {
        int number;
        if (j - 1 >= 0) {
            number = GameField.getGameField()[i][j - 1];
            GameField.getGameField()[i][j] = number;
            GameField.getGameField()[i][j - 1] = 0;
        } else {
            showError();
        }
    }

    private static void replaceDown(int i, int j) {
        int number;
        if (i - 1 >= 0) {
            number = GameField.getGameField()[i - 1][j];
            GameField.getGameField()[i][j] = number;
            GameField.getGameField()[i - 1][j] = 0;
        } else {
            showError();
        }
    }

    private static void replaceUp(int i, int j) {
        int number;
        if (i + 1 < GameField.getGameField()[i].length) {
            number = GameField.getGameField()[i + 1][j];
            GameField.getGameField()[i][j] = number;
            GameField.getGameField()[i + 1][j] = 0;
        } else {
            showError();
        }
    }

    private static void replaceLeft(int i, int j) {
        int number;
        if (j + 1 < GameField.getGameField()[j].length) {
            number = GameField.getGameField()[i][j + 1];
            GameField.getGameField()[i][j] = number;
            GameField.getGameField()[i][j + 1] = 0;
        } else {
            showError();
        }
    }

    private static void showError() {
        System.out.println("Вы не можете сделать такой ход!");
    }

    public static void replace(Direction direction) {
        label:
        for (int i = 0; i < GameField.getGameField().length; i++) {
            for (int j = 0; j < GameField.getGameField()[i].length; j++) {
                if (GameField.getGameField()[i][j] == 0) {
                    replaceAccordingDirection(i, j, direction);
                    break label;
                }
            }
        }
    }
}
