package main.java;

import main.java.game.GameRules;
import main.java.game.GameField;

public class Main {

    public static void main(String[] args) {
        GameField.initializeGameField();
        GameRules.runGame();
    }
}
