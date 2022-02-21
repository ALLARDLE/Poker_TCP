package Cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<ICard> cards;

    public Hand(List<ICard> hand){
        this.cards = hand;
    }


    public List<ICard> getCards() {
        return cards;
    }

    /**
     * Fusionne la main actuelle avec d'autres cartes
     */
    public void mergeHand(Hand other){

        for (ICard c : other.cards){
            this.addCardToBottom(c);
        }
    }

    /**
     *  Ajoute un carte en bas de la main
     */
    public void addCardToBottom(ICard c) {

        cards.add(0, c);
    }

    /**
     * Supprime la premiere carte de la main
     */
    public ICard removeCardFromTop() {

        if (handSize() < 1) {
            return null;
        }
        return cards.remove(handSize() - 1);
    }

    /**
     * Taille de la main
     */
    public int handSize() {
        return cards.size();
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
