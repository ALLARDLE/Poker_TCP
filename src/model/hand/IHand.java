package model.hand;

import model.card.ICard;

import java.util.List;

public interface IHand {
    ICard getCard(int cardIndex);
    List<ICard> getAllCards();
    String toString();
}
