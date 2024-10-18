package org.example.app;

import java.util.List;

public class Card {
    enum COLOR {
        WHITE,
        BLUE,
        BLACK,
        RED,
        GREEN,
        COLORLESS,
        MULTICOLOR,
    }

    private String cardName;
    private String manaCost;  // what is the mana value of this card? ex. "Muldrotha = 3BGU"
    private List<COLOR> colors;   // extract the colors of a card from the mana cost.
    private String superType; // using Muldrotha again, her supertype is "Legendary" and "Creature"
    private String subType; // using Muldrotha, her subtype is "Elemental" and "Avatar"
    private String effectText; // take the effect text straight from the card.
    private String setName; // since cards can be reprinted in multiple sets, we will only use one.
    private int power;
    private int toughness;

    public static Card of(String cardName, String manaCost, String superType, String subType, String effectText, String setName) {
        return new Card(cardName, manaCost, superType, subType, effectText, setName);
    }

    public static Card of(String cardName, String manaCost, String superType, String subType, String effectText,
        String setName, int power, int toughness) {
        return new Card(cardName, manaCost, superType, subType, effectText, setName, power, toughness);
    }
    
    // used for cards without a power and toughness
    private Card(String cardName, String manaCost, String superType, String subType, String effectText, String setName) {
        this.cardName = cardName;
        this.manaCost = manaCost;
        this.superType = superType;
        this.subType = subType;
        this.effectText = effectText;
        this.setName = setName;
        findColors();
    }

    // used for cards with a power and toughness
    private Card(String cardName, String manaCost, String superType, String subType, String effectText,
        String setName, int power, int toughness) {
        this(cardName, manaCost, superType, subType, effectText, setName);
        this.power = power;
        this.toughness = toughness;
    }
    
    private void findColors() {
        for (char c : manaCost.toCharArray()) {
            switch (c) {
                case 'W': 
                    colors.add(COLOR.WHITE);
                    break;
                case 'U':
                    colors.add(COLOR.BLUE);
                    break;
                case 'B':
                    colors.add(COLOR.BLACK);
                    break;
                case 'R':
                    colors.add(COLOR.RED);
                    break;
                case 'G':
                    colors.add(COLOR.GREEN);
                    break;
            }
        }

        if (colors.isEmpty()) colors.add(COLOR.COLORLESS);
        else if (colors.size() > 1) colors.add(COLOR.MULTICOLOR);
    }

    public void setColor(COLOR colors) {
        // TODO: implement a way to set colors due to card effects
    }

}
