package view.server;
import model.player.IPlayer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServeurTCP extends Thread {

    private static int nbConnexions = 0;        // nombre de clients connectés
    private static final int maxConnexions = 6;     // nombre de clients maximum

    private Socket clientSocket;
    private IContext contexte;
    private IProtocole protocole;

    private final int portNumber;

    private final List<IPlayer> players;        // liste des joueurs connectés au serveur

    public ServeurTCP(int port) {
        portNumber = port;
        players = new ArrayList<>();
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
                System.out.println("Attente du serveur pour la communication d'un client" );
                clientSocket = serverSocket.accept();       // le socket associé au client
                nbConnexions ++;
                System.out.println("Nombre de clients connectés : " + nbConnexions);
            } catch (IOException e) {
                System.out.println("Accept failed: " + serverSocket.getLocalPort() + ", " + e);
                System.exit(1);
            }
            Processus st = new Processus( clientSocket , this );        // lance le processus pour le
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
