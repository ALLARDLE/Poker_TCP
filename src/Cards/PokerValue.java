package Cards;


public class PokerValue implements IValue {
    public enum Values  {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
    
    private final Values value;
    
    public PokerValue(Values value) throws ValueException {
        if (isValidValue(value)) {
            this.value = value;
        }
        else {
            throw new ValueException();
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
        return "Value=" + value;
    }
}
