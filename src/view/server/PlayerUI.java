package view.server;

import javafx.scene.Group;
import model.card.ICard;
import model.player.IPlayer;

public class PlayerUI extends Group {

    private IPlayer player;
    public PlayerUI(IPlayer p) {
        player = p;
    }

    public void printCards()   {
        for (ICard card: player.getHand().getAllCards())    {
            this.getChildren().add(new CardUI(card));
        }
    }

    public IPlayer getPlayer() {
        return player;
    }
}
