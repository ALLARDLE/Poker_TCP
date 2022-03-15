package model.player;


import model.card.IHand;


public class PokerPlayer implements IPlayer {
    private final String name;
    private boolean inGame;
    private int money;
    private IHand hand;

    private boolean isDealer = false;
    private boolean isSmallBlind = false;
    private boolean isBigBlind = false;

    public PokerPlayer(String name, int money) {
        this.name = name;
        this.money = money;
        inGame = true;
    }

    @Override
    public boolean isInGame() {
        return inGame;
    }

    @Override
    public void setInGame(boolean inGame)   {
        this.inGame = inGame;
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

    @Override
    public boolean isBigBlind() {return isBigBlind;}

    @Override
    public void setBigBlind(boolean bigBlind) {isBigBlind = bigBlind;}

    @Override
    public boolean isDealer() {return isDealer;}

    @Override
    public void setDealer(boolean dealer) {isDealer = dealer;}

    @Override
    public boolean isSmallBlind() {return isSmallBlind;}

    @Override
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
