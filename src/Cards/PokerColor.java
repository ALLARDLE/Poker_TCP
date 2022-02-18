package Cards;


/**
 * @author Allard Léni & Billon François
 *
 * Définie une couleur d'un jeu de cartes de poker
 *
 */

public class PokerColor extends Color {
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

    @Override
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
    public String toString() {
        return "Color = " + color;
    }
}

