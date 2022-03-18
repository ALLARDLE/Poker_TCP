package model.player;

import view.server.ServeurTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PokerPlayerTCP implements Runnable {

    private static final int GET_USERNAME = 1;
    private static final int SEND_GAME = 2;

    private final IPlayer player;
    private boolean playerTurn = false;

    private final ServeurTCP myServ;
    private final Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public PokerPlayerTCP(Socket socket, ServeurTCP myServ) {
        this.socket = socket;
        this.myServ = myServ;
        String username = "";
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            username = getUsername();

        } catch (IOException e) {
            System.out.println("Player lost: " + e);
        }
        player = new PokerPlayer(username, 2000);
        myServ.getPokerGameController().addPlayer(player);
    }

    /**
     *
     */
    @Override
    public void run() {
            // écoute en permanence et envoie des informations lorsqu'il y a des changements sur le jeu
            // insérer un Observer sur certaines variables
            System.out.println(player.getName());
    }


    /**
     * Communication avec le client pour obtenir son username
     *
     * @return username
     */
    private String getUsername() {
        System.out.println("Demande Username");
        String inputReq;
        try {
            output.println(String.valueOf(GET_USERNAME));
            while (true) {
                if ((inputReq = input.readLine()) != null) {
                    String retVal = "Hello " + inputReq;
                    System.out.println("Username = " + inputReq);
                    output.println(retVal);
                    return inputReq;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}