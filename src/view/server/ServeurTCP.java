package view.server;
import controller.PokerGameController;
import model.player.IPlayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurTCP extends Thread {

    private static int nbConnexions = 0;        // nombre de clients connectés
    private static final int maxConnexions = 1;     // nombre de clients maximum

    private Socket clientSocket;
    private IContext contexte;
    private IProtocole protocole;

    private final int portNumber;

    private PokerGameController pokerGameController;


    public ServeurTCP(int port) {
        portNumber = port;
        pokerGameController = new PokerGameController(new ArrayList<IPlayer>());
    }

    public ServeurTCP(IContext b,IProtocole p, int port) {
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
        ServerSocket serverSocket = null;       // socket du serveur
        try {
            serverSocket = new ServerSocket (portNumber);       // lance un socket pour le serveur
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
            Processus st = new Processus( clientSocket , this );        // lance l'exécutant pour la connexion client
            st.start();
        }

        System.out.println("Deja " + nbConnexions + " clients. Maximum autorisé atteint");

        try {
            serverSocket.close();
            nbConnexions --;
        } catch (IOException e) {
            System.out.println("Could not close");
        }

    }


    public IProtocole getProtocole() {
        return protocole;
    }

    public IContext getContexte() {
        return contexte;
    }


}
