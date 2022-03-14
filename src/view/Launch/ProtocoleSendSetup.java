package view.Launch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import view.server.IContext;
import view.server.IProtocole;

public class ProtocoleSendSetup implements IProtocole {


    public void execute(IContext c, InputStream unInput, OutputStream unOutput) {

        String inputReq;
        BufferedReader is = new BufferedReader(new InputStreamReader(unInput));
        PrintStream os = new PrintStream(unOutput);

        try {

            System.out.println("Serveur avec  Client ");
            while(true){
                if ((inputReq = is.readLine()) != null) {
                    String valeurExpediee = "";
                    System.out.println(" Msg 2 Recu " + inputReq);
                    String chaines[] = inputReq.split(" ");
                    System.out.println(" Ordre Recu " + chaines[0]);

                    if (chaines[0].contentEquals("NOM")) {
                        valeurExpediee = " Bienvenue ";

                        System.out.print("Le joueur ");

                        /** creer le joueur*/

                        inputReq = chaines[1];
                        System.out.print(inputReq);
                        System.out.print(" a rejoin la partie");
                        valeurExpediee = valeurExpediee + inputReq;}

                    else if(chaines[0].contentEquals("LEAVE")){
                        valeurExpediee = "Le joueur " + chaines[1] + " QUITTE LA PARTIE";
                        System.out.println("Le joueur " + chaines[1] + " QUITTE LA PARTIE");
                    }

                    else if(chaines[0].contentEquals("CHECK")){
                        valeurExpediee = "Le joueur " + chaines[1] + " CHECK";
                        System.out.println("Le joueur " + chaines[1] + " CHECK");
                    }

                    else if(chaines[0].contentEquals("BET")){
                        valeurExpediee = "Le joueur " + chaines[1] + " MISE " + chaines[2];
                        System.out.println("Le joueur " + chaines[1] + " MISE " + chaines[2]);
                    }

                    else if(chaines[0].contentEquals("CALL")){
                        valeurExpediee = "Le joueur " + chaines[1] + " CALL";
                        System.out.println("Le joueur " + chaines[1] + " CALL");
                    }

                    else if(chaines[0].contentEquals("RAISE")){
                        valeurExpediee = "Le joueur " + chaines[1] + " AUGMENTE DE LA MISE DE : " + chaines[2];
                        System.out.println("Le joueur " + chaines[1] + " AUGMENTE DE LA MISE DE : " + chaines[2]);
                    }

                    else if(chaines[0].contentEquals("FOLD")){
                        valeurExpediee = "Le joueur " + chaines[1] + " SE COUCHE";
                        System.out.println("Le joueur " + chaines[1] + " SE COUCHE");
                    }

                    else {
                        valeurExpediee = " Ordre inconnu ";
                        System.out.println(" Ordre inconnu ");
                    }

                    os.println(valeurExpediee);
                }

            }

        } catch (Exception e) {
            System.out.println(" Pb d'exception ");
        }
    }
}



