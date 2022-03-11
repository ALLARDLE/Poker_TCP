package controller;

import model.card.ICard;

import java.util.List;

public interface ICardController {
    void dealPlayerHand();
    void dealFlop();
    void dealTurn();
    void dealRiver();
    List<ICard> getCommunityCards();
}
