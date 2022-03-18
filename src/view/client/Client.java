package view.client;

public class Client {

    private final ClientTCP tcp;

    private final String username;

    private final int numeroPort;

    private final String nomServeur;


    /** On associe un joueur à un client qui se connecte a un serveur identifie par un nom (unNomServeur), sur un port unNumero */
    public  Client(String PlayerName, int PlayerPort, String unNomServeur) {
        username = PlayerName;
        numeroPort = PlayerPort;
        nomServeur = unNomServeur;
        tcp = new ClientTCP(nomServeur, numeroPort);
    }

    /** On envoie au serveur le nom du joueur*/
    public void sendName(){
        tcp.transmettreChaine(username);
    }

    public void leave(){String ord = "LEAVE " + username;
        tcp.transmettreChaine(ord);
        tcp.deconnecterDuServeur();
    }

    public void Check(){String ord = "CHECK " + username;
        tcp.transmettreChaine(ord);
    }
    public void Bet(int amount){
        String ord = "BET " + username + " " + String.valueOf(amount);
        tcp.transmettreChaine(ord);
    }
    public void Call(){
        String ord = "CALL " + username;
        tcp.transmettreChaine(ord);
    }

    public void Raise(int amount){
        String ord = "RAISE " + username + " " + String.valueOf(amount);
        tcp.transmettreChaine(ord);
    }
    public void Fold(){
        String ord = "FOLD " + username;
        tcp.transmettreChaine(ord);
    }


    public ClientTCP getTcp() {
        return tcp;
    }
}
