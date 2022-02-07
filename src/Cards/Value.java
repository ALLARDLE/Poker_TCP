package Cards;


/**
 * @author Allard Léni & Billon François
 *
 * Définie la valeur d'une carte d'un jeu de poker
 *
 */


public class Value {
    public enum Values  {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public final Values value;

    public Value(Values value) throws ValueException {
        if (isValidValue(value)) {
            this.value = value;
        }
        else {
            throw new ValueException();
        }
    }

    public boolean isValidValue(Values value)   {
        for (Values values: Values.values())   {
            if (values == value)    {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Value = " + value;
    }
}
