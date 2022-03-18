package view.Launch;

import view.client.Client;

import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre nom :");
        String name = sc.next();

        System.out.println("Entrez le nom du serveur :");
        String serveur = sc.next();

        System.out.println("Sur quel port voulez vous vous connecter ?");
        int port = sc.nextInt();

        Client client = new Client(name, port, serveur);

        if (client.getTcp().connect()) {
            client.sendName();
        }

        while (true){
            System.out.println(" Que voulez vous faire ?");
            /**
             * Leave
             * Check
             * Bet
             * Call
             * Raise
             * Fold
             */
            String action = sc.next();
            switch (action) {
                case "Leave":
                    client.leave();
                    break;
                case "Check":
                    client.Check();
                    break;
                case "Bet":
                    System.out.println("Entrez le montant de la mise :");
                    int bet = sc.nextInt();
                    client.Bet(bet);
                    break;
                case "Call":
                    client.Call();
                    break;
                case "Raise":
                    System.out.println("Entrez le montant de l'augmentation :");
                    int raise = sc.nextInt();
                    client.Raise(raise);
                    break;
                case "Fold":
                    client.Fold();
                    break;
                default:
                    System.out.println(" Ordre inconnu ");
                    break;
            }
        }
    }
}
