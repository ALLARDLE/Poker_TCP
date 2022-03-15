package view.server;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.player.PokerPlayer;

public class ServerGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Poker TCP Serveur");     // titre de la fenêtre
        //primaryStage.getIcons().add(new Image("/res/back.png"));        // ajout de l'icone

        Group root = new Group();
        PlayerUI player1 = new PlayerUI(new PokerPlayer("TestUI", 200));
        player1.printCards();

        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}