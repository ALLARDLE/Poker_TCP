package controller;

import model.card.ICard;

import java.util.List;

public interface ICardController {
    void dealPLayerHand();
    void dealFlop();
    void dealTurn();
    void dealRiver();
    List<ICard> getCommunityCards();
}
