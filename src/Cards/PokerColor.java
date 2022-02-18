package Cards;


import java.util.Objects;

/**
 * @author Allard Léni & Billon François
 *
 * Définie une couleur d'un jeu de cartes de poker
 *
 */

public class PokerColor implements IColor {
    public enum PokerColors {
        HEART, DIAMOND, SPADE, CLUB
    }

    public final PokerColors color;       // couleur

    public PokerColor(PokerColors color) throws ColorException {
        if (isValidColor(color))    {
            this.color = color;
        }
        else    {
            throw new ColorException("Bad color");
        }
    }
    public boolean isValidColor() {
        switch (this.color) {
            case HEART, DIAMOND, SPADE, CLUB -> { return true; }
            default -> { return false; }
        }
    }


    private boolean isValidColor(PokerColors color) {
        for (PokerColors pokerColors: PokerColors.values()) {
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
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "PokerColor=" + color;
    }
}

