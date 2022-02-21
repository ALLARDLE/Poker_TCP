package Cards;


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
    public int isUpperTo(Object o) throws Exception {
        if (this == o) return 0;
        if (!(o instanceof PokerCard pokerCard)) throw new Exception();
        return getValue().isUpperTo(pokerCard.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokerCard pokerCard)) return false;
        return getColor().equals(pokerCard.getColor()) && getValue().equals(pokerCard.getValue());
    }

    @Override
    public String toString() {
        return "PokerCard{" +
                this.color.toString() +
                ", " + this.value.toString() +
                '}';
    }
}
