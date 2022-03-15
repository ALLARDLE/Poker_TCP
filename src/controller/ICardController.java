package controller;

import model.card.ICard;
import model.card.IDeck;
import model.player.IPlayer;

import java.util.List;

public interface ICardController {
    void resetController(IDeck deck);
    void dealPlayerHand(List<IPlayer> players);
    void dealFlop();
    void dealTurn();
    void dealRiver();
    List<ICard> getCommunityCards();
}
