package model.card;

/**
 * @author Léni Allard & François Billon
 * Implémentation d'une carte de Poker.
 *
 */
public class PokerCard implements ICard {

    private final ICardColor color;
    private final ICardValue value;

    public PokerCard(ICardColor color, ICardValue value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public ICardValue getValue() { return this.value; }

    @Override
    public ICardColor getColor() { return this.color; }

    @Override
    public int isUpperTo(Object o) throws Exception {
        if (this == o) return 0;
        if (!(o instanceof Cards.PokerCard pokerCard)) throw new Exception();
        return getValue().isUpperTo(pokerCard.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cards.PokerCard pokerCard)) return false;
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