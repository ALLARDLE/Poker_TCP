package view.Launch;

import view.server.ServeurTCP;

public class MainServeur {

    public static void main(String[] args) {
        ServeurTCP myServ1 = new ServeurTCP(new TestContext() , new ProtocoleSendSetup() , 6666 );
        myServ1.start();
    }
}