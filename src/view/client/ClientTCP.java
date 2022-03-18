package view.client;

import java.io.*;
import java.net.*;

public class ClientTCP {

    private int numeroPort;

    private String nomServeur;

    private Socket socketServeur;

    private PrintStream socOut;

    private BufferedReader socIn;

    /** Un client se connecte a un serveur identifie par un nom (unNomServeur), sur un port unNumero */
    public  ClientTCP(String unNomServeur, int unNumero) {
        numeroPort = unNumero;
        nomServeur = unNomServeur;
    }

    public boolean connect() {
        boolean ok = false;
        try {
            System.out.println("Tentative : " + nomServeur + " -- " + numeroPort);
            socketServeur = new Socket(nomServeur, numeroPort);
            socOut = new PrintStream(socketServeur.getOutputStream());
            socIn = new BufferedReader(new InputStreamReader(socketServeur.getInputStream()));
            ok = true;
        } catch (UnknownHostException e) {
            System.err.println("Serveur inconnu : " + e);
        } catch (ConnectException e) {
            System.err.println("Exception lors de la connexion:" + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Exception lors de l'échange de données:" + e);
        }
        System.out.println("Connexion faite");
        return ok;
    }

    public void disconnect() {
        try {
            System.out.println("[ClientTCP] CLIENT : " + socketServeur);
            socOut.close();
            socIn.close();
            socketServeur.close();
        } catch (Exception e) {
            System.err.println("Exception lors de la deconnexion :  " + e);
        }
    }

    public void send(String message) {
        System.out.println("Requete client : " + message);
        socOut.println(message);
        socOut.flush();
    }

    public void receive()   {
        String serverMsg = null;
        try {
            serverMsg = socIn.readLine();
            System.out.println("Server message : " + serverMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}