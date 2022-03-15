package model.card;


/**
 * @author Allard Léni & Billon François
 *
 * Définie une couleur d'un jeu de cartes de poker
 *
 */

public class PokerColor implements ICardColor {
    public enum Colors {
        HEART, DIAMOND, SPADE, CLUB
    }

    private Colors color;       // couleur

    public PokerColor(Colors color) {
        if (isValidColor(color))    {
            this.color = color;
        }
    }

    private boolean isValidColor(Colors color) {
        for (Colors pokerColors: Colors.values()) {
            if (color == pokerColors)   {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokerColor that)) return false;
        return color == that.color;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}

