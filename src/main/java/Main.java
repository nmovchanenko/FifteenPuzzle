package main.java;

import main.java.game.GameRules;
import main.java.game.GameField;

class Main {

    public static void main(String[] args) {
        // создать и вывести поле с цифрами
        GameField.initializeGameField();

        // играть
        GameRules.runGame();
    }
}
