import controller.PokerGameController;
import model.player.IPlayer;
import model.player.PokerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            // Connexion des joueurs ...
            // Simulation
            List<IPlayer> players = new ArrayList<>();
            for (int i=1; i<6; i++) {
                players.add(new PokerPlayer(String.format("Player%d", i), 2000));
            }

            // Création du plateau
            PokerGameController pokerGameController = new PokerGameController(players);
            pokerGameController.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
