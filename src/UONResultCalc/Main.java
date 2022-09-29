package UONResultCalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Program: 	UONResultCalc
 * Filename:	Main.java
 * @author:		� Richard Wilsher (2022)
 * Course:		BSC Computing (Software Engineering)
 * Tutor:		Mark Johnson
 * @version:	1.0 final
 * Date:		29/09/2022
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-view.fxml"));
        stage.setResizable(false);
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("UON Results Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}