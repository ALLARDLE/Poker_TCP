package model.card;


public class PokerValue implements ICardValue {
    public enum Values  {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
    
    private Values value;
    
    public PokerValue(Values value) {
        if (isValidValue(value)) {
            this.value = value;
        }
    }

    private boolean isValidValue(Values value)   {
        for (Values values: Values.values())   {
            if (values == value)    {
                return true;
            }
        }
        return false;
    }

    public Values getValue() {
        return value;
    }

    public void setValue(Values value) {
        this.value = value;
    }

    @Override
    public int isUpperTo(Object o) throws Exception {
        if (this == o) return 0;
        if (!(o instanceof PokerValue that)) throw new Exception();
        return this.value.compareTo(that.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokerValue that)) return false;
        return value == that.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
