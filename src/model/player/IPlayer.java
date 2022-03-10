package model.player;


import model.card.IHand;


public interface IPlayer {
    String getName();
    void setHand(IHand hand);
    IHand getHand();
    void setMoney(int money);
    int getMoney();
    boolean isBigBlind();
    boolean isSmallBlind();
}
