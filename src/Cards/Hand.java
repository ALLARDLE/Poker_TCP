package Cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<ICard> cards;

    public Hand(ArrayList<ICard> hand){
        this.cards = hand;
    }

    public void mergeHand(Hand other){
        /**
         * Fusionne la main actuelle avec d'autres cartes
         */
        for (ICard c : other.cards){
            this.addCardToBottom(c);
        }
    }

    public void addCardToBottom(ICard c) {
        /**
         *  Ajoute un carte en bas de la main
         */
        cards.add(0, c);
    }

    public ICard removeCardFromTop() {
        /**
         * Suprime la premiere carte de la main
         */
        if (handSize() < 1) {
            return null;
        }
        return cards.remove(handSize() - 1);
    }

    public int handSize() {
        /**
         * Taille de la main
         */
        return cards.size();
    }
}
