package view.server;
import java.io.IOException;
import java.net.Socket;

/**
 * Le serveur a lancé le thread exécutant pour un client spécifique
 */
class Processus extends Thread {

    private Socket clientSocket;
    private ServeurTCP monServeurTCP;

    public Processus(Socket uneSocket, ServeurTCP unServeur) {
        super("ServeurThread");
        clientSocket = uneSocket;
        System.out.println("[Processus] CLIENT : " + clientSocket);
        monServeurTCP = unServeur;
    }

    public void run() {
            try {
                // exécution du protocole
                monServeurTCP.getProtocole().execute(monServeurTCP.getContexte(), clientSocket.getInputStream(), clientSocket.getOutputStream(), monServeurTCP);
                System.out.println("Processus fait");
            } catch (IOException e) {
                System.err.println("[Processus] Exception : " + e);
                e.printStackTrace();
            }
        }
    }
