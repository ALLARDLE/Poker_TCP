package view.Launch;

import view.server.PokerProtocol;
import view.server.ServeurTCP;


/**
 * Lance le serveur
 */
public class MainServeur {

    public static void main(String[] args) {
        ServeurTCP myServ = new ServeurTCP(new TestContext() , new PokerProtocol() , 8888 );
        new Thread(myServ).start();
    }
}