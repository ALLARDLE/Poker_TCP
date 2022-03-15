package view.server;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.card.ICard;

public class CardUI extends ImageView {

    private static final String back = "/res/back.png";     // image du dos de la carte
    private final String file;      // image de la carte

    private final ICard card;

    public CardUI(ICard c) {
        super(new Image(back));
        this.file = String.format("/res/%s_%s.PNG", c.getColor(), c.getValue());
        card = c;
    }

    public ICard getCard() {
        return card;
    }

    public void returnCard()    {

    }
}
