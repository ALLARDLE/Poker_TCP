package view.client;
import java.util.Scanner;

public class Client {

    private ClientTCP tcp;

    private String username;

    private int numeroPort;

    private String nomServeur;


    /** On associe un joueur à un client qui se connecte a un serveur identifie par un nom (unNomServeur), sur un port unNumero */
    public  Client(String PlayerName, int PlayerPort, String unNomServeur) {
        username = PlayerName;
        numeroPort = PlayerPort;
        nomServeur = unNomServeur;
        tcp = new ClientTCP(nomServeur,numeroPort);
    }

    /** On envoie au serveur le nom du joueur*/
    public String SendName(){
        return tcp.transmettreChaine("NOM " + username);
    }

    public String leave(){String ord = "LEAVE " + username;
        return tcp.transmettreChaine(ord);
    }

    public String Check(){String ord = "CHECK " + username;
        return tcp.transmettreChaine(ord);
    }
    public String Bet(int amount){
        String ord = "BET " + username + " " + String.valueOf(amount);
        return tcp.transmettreChaine(ord);
    }
    public String Call(){
        String ord = "CALL " + username;
        return tcp.transmettreChaine(ord);
    }

    public String Raise(int amount){
        String ord = "RAISE " + username + " " + String.valueOf(amount);
        return tcp.transmettreChaine(ord);
    }
    public String Fold(){
        String ord = "FOLD " + username;
        return tcp.transmettreChaine(ord);
    }


    public ClientTCP getTcp() {
        return tcp;
    }
}
