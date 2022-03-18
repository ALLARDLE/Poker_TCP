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

    public void listen(){

    }
    /** On envoie au serveur le nom du joueur*/
    public void sendName(){
        tcp.send(username);
    }

    public void leave(){String ord = "LEAVE " + username;
        tcp.send(ord);
        tcp.disconnect();
    }

    public void Check(){String ord = "CHECK " + username;
        tcp.send(ord);
    }
    public void Bet(int amount){
        String ord = "BET " + username + " " + String.valueOf(amount);
        tcp.send(ord);
    }
    public void Call(){
        String ord = "CALL " + username;
        tcp.send(ord);
    }

    public void Raise(int amount){
        String ord = "RAISE " + username + " " + String.valueOf(amount);
        tcp.send(ord);
    }
    public void Fold(){
        String ord = "FOLD " + username;
        tcp.send(ord);
    }


    public ClientTCP getTcp() {
        return tcp;
    }
}
