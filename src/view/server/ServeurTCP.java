package view.server;
import controller.PokerGameController;
import model.player.IPlayer;
import model.player.PokerPlayerTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurTCP implements Runnable {

    private static int nbConnexions = 0;        // nombre de clients connectés
    private static final int maxConnexions = 6;     // nombre de clients maximum

    private Socket clientSocket;
    private IContext contexte;
    private IProtocol protocole;

    private final int portNumber;

    private PokerGameController pokerGameController;


    public ServeurTCP(int port) {
        portNumber = port;
    }

    public ServeurTCP(IContext b, IProtocol p, int port) {
        this(port);
        contexte = b;
        protocole = p;
    }


    @Override
    public String toString() {
        return "[ServeurTCP] Port : " + portNumber + ", Contexte: " + contexte ;
    }

    @Override
    public void run() {
        pokerGameController = new PokerGameController(new ArrayList<IPlayer>());
        new Thread(pokerGameController).start();

        ServerSocket serverSocket = null;       // socket du serveur
        try {
            serverSocket = new ServerSocket(portNumber);       // lance un socket pour le serveur
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + portNumber + ", " + e);
            System.exit(1);
        }

        /* On autorise maxConnexions traitements */
        while (nbConnexions <= maxConnexions) {
            try {
                System.out.println("Serveur en attente de connexion...");
                // FONCTION BLOQUANTE
                clientSocket = serverSocket.accept();       // accepte la connexion d'un client
                nbConnexions ++;
                System.out.println("Nombre de clients connectés : " + nbConnexions);
            } catch (IOException e) {
                System.out.println("Accept failed: " + serverSocket.getLocalPort() + ", " + e);
                System.exit(1);
            }
            PokerPlayerTCP pokerPlayerTCP = new PokerPlayerTCP( clientSocket , this );        // lance l'exécutant pour la connexion client
            new Thread(pokerPlayerTCP).start();
        }

        System.out.println("Deja " + nbConnexions + " clients. Maximum autorisé atteint");

        try {
            serverSocket.close();
            nbConnexions --;
        } catch (IOException e) {
            System.out.println("Could not close");
        }

    }

    public PokerGameController getPokerGameController()   {
        return pokerGameController;
    }

    public IProtocol getProtocole() {
        return protocole;
    }

    public IContext getContexte() {
        return contexte;
    }


}
