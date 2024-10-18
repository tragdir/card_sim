package org.example.app;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initialize();
        startGame();
    }

    private static void initialize() {
        Pile deck = Pile.of(new ArrayList<Card>(), false);
        Pile hand = Pile.of(new ArrayList<Card>(), true);
    }

    private static void startGame() {
        // TODO: implement the start of a game.
    }
}
