package Cards;

/**
 * @author Allard Léni & Billon François
 *
 * Classe abstraite définissant le fonctionnement d'une carte
 */
class Card {
    private final PokerColor color;
    private final Value value;

    public Card(PokerColor color, Value value)   {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" + color + ", " + value + '}';
    }
}
