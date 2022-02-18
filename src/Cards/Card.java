package Cards;

import java.util.Objects;

/**
 * @author Allard Léni & Billon François
 *
 * Classe définissant le fonctionnement d'une carte
 */
abstract class Card {
    private Color color;
    private Value value;

    public Value getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return Objects.equals(getColor(), card.getColor()) && Objects.equals(getValue(), card.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getValue());
    }
}
