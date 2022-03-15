package view.server;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label myLabel = new Label("Hello wolrd");
        StackPane myPane = new StackPane();
        myPane.getChildren().add(myLabel);

        Scene myScene = new Scene(myPane, 200, 200);

        stage.setScene(myScene);
        stage.setTitle("HelloWorldTitle");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
