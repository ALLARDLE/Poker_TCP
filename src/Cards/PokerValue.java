package Cards;

import java.util.Objects;

public class PokerValue implements IValue {
    public enum Values  {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
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
