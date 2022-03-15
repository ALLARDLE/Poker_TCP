package model.player;


import model.card.IHand;


public interface IPlayer {
    boolean isInGame();
    void setInGame(boolean inGame);

    String getName();

    void setHand(IHand hand);
    IHand getHand();

    void setMoney(int money);
    int getMoney();

    boolean isBigBlind();
    void setBigBlind(boolean bigBlind);

    boolean isSmallBlind();
    void setSmallBlind(boolean smallBlind);

    boolean isDealer();
    void setDealer(boolean dealer);
}
