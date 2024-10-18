package org.example.app;

import java.util.List;

public class Pile {
    private int currentSize;
    private List<Card> pile;
    private boolean isFaceUp;

    public static Pile of(List<Card> pile, boolean isFaceUp) {
        return new Pile(pile, isFaceUp);
    }

    private Pile(List<Card> pile, boolean isFaceUp) {
        this.pile = pile;
        this.isFaceUp = isFaceUp;
        this.currentSize = pile.size();
    }
}
