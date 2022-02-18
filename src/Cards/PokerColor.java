package Cards;


import java.util.Objects;

/**
 * @author Allard Léni & Billon François
 *
 * Définie une couleur d'un jeu de cartes de poker
 *
 */

public class PokerColor implements IColor {
    public enum Colors {
        HEART, DIAMOND, SPADE, CLUB
    }

    public final Colors color;       // couleur

    public PokerColor(Colors color) throws ColorException {
        if (isValidColor(color))    {
            this.color = color;
        }
        else    {
            throw new ColorException("Bad color");
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
        return "PokerColor=" + color;
    }
}

