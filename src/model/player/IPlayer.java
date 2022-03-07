package model.player;


import model.hand.IHand;


public interface IPlayer {
    String getName();
    void setHand(IHand hand);
    IHand getHand();
    void setMoney(int money);
    int getMoney();
}
