import controller.*;
import model.card.*;
import model.player.IPlayer;
import model.player.PokerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Création du paquet de cartes
            IDeck deck = new PokerDeck();
            deck.shuffle();

            // Connexion des joueurs ...
            // Simulation
            List<IPlayer> players = new ArrayList<>();
            for (int i=0; i<5; i++) {
                players.add(new PokerPlayer(String.format("Player%d", i), 2000));
            }

            // Création des controllers
            IScoreController scoreController = new PokerScoreController(players, 10);
            ICardController cardController = new CardController(players, deck);
            RoundController roundController = new RoundController(players, scoreController, cardController);

            cardController.dealPLayerHand();
            roundController.run();

            System.out.println(cardController.getCommunityCards());
            System.out.println(players.get(0).toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
