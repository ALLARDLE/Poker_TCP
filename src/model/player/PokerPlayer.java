package model.player;


import model.hand.IHand;


public class PokerPlayer implements IPlayer {
    private final String name;
    private int money;
    private IHand hand;

    private boolean isDealer = false;
    private boolean isSmallBlind = false;
    private boolean isBigBlind = false;

    public PokerPlayer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String getName() {return name;}

    @Override
    public void setHand(IHand hand) {this.hand = hand;}

    @Override
    public IHand getHand() {return hand;}

    @Override
    public void setMoney(int money) {this.money = money;}

    @Override
    public int getMoney() {return money;}

    public boolean isBigBlind() {return isBigBlind;}

    public void setBigBlind(boolean bigBlind) {isBigBlind = bigBlind;}

    public boolean isDealer() {return isDealer;}

    public void setDealer(boolean dealer) {isDealer = dealer;}

    public boolean isSmallBlind() {return isSmallBlind;}

    public void setSmallBlind(boolean smallBlind) {isSmallBlind = smallBlind;}

    @Override
    public String toString() {
        return "PokerPlayer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", hand=" + hand +
                ", isDealer=" + isDealer +
                ", isSmallBlind=" + isSmallBlind +
                ", isBigBlind=" + isBigBlind +
                '}';
    }
}
