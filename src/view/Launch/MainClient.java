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

        while (true)    {
            client.listen();
        }

        if ( client.getTcp().connecterAuServeur() ) {
            Clt.SendName();
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
                    Clt.leave();
                    break;
                case "Check":
                    Clt.Check();
                    break;
                case "Bet":
                    System.out.println("Entrez le montant de la mise :");
                    int bet = sc.nextInt();
                    Clt.Bet(bet);
                    break;
                case "Call":
                    Clt.Call();
                    break;
                case "Raise":
                    System.out.println("Entrez le montant de l'augmentation :");
                    int raise = sc.nextInt();
                    Clt.Raise(raise);
                    break;
                case "Fold":
                    Clt.Fold();
                    break;
                default:
                    System.out.println(" Ordre inconnu ");
                    break;
            }
        }



    }
}
