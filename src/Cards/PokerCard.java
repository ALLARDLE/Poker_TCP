package Cards;

import java.util.Objects;

public class PokerCard extends Card {
    private final PokerColor color;
    private final Value value;

    public PokerCard(PokerColor color, Value value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokerCard pokerCard)) return false;
        if (!super.equals(o)) return false;
        return getColor().equals(pokerCard.getColor()) && getValue().equals(pokerCard.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor(), getValue());
    }

    @Override
    public String toString()    {
        return "Card{" + color + ", " + value + '}';
    }
}
