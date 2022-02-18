package Cards;

import java.util.Objects;

public class PokerCard implements ICard {

    private final PokerColor color;
    private final PokerValue value;

    public PokerCard(PokerColor color, PokerValue value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public IValue getValue() {
        return this.value;
    }

    @Override
    public IColor getColor() {
        return this.color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokerCard pokerCard)) return false;
        return getColor().equals(pokerCard.getColor()) && getValue().equals(pokerCard.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor(), getValue());
    }

    @Override
    public String toString() {
        return "PokerCard{" +
                this.color.toString() +
                ", " + this.value.toString() +
                '}';
    }
}
