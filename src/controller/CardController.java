package controller;

import model.card.ICard;
import model.card.IDeck;
import model.card.PokerHand;
import model.player.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class CardController implements ICardController {

    private IDeck deck;
    private final List<ICard> communityCards = new ArrayList<>();

    public CardController (IDeck deck)   {
        this.deck = deck;
    }

    /**
     * Réinitialise le controller
     * @param deck
     */
    public void resetController(IDeck deck)   {
        this.deck = deck;
        communityCards.clear();
    }

    /**
     * Distribue les cartes aux joueurs
     */
    @Override
    public void dealPlayerHand(List<IPlayer> players) {
        if (deck.getNumberOfCardsLeft() > 0)    {
            for (IPlayer player : players)  {
                player.setHand(new PokerHand(deck.getCard(), deck.getCard()));
            }
        }
    }

    @Override
    public void dealFlop() {
        for (int i=0; i<3; i++) {
            communityCards.add(deck.getCard());
        }
    }

    @Override
    public void dealTurn() {
        deck.getCard();     // on brûle une carte
        communityCards.add(deck.getCard());
    }

    @Override
    public void dealRiver() {
        dealTurn();
    }

    @Override
    public List<ICard> getCommunityCards()  { return communityCards; }
}
