package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {

    @FXML
    void initialize() {

    }

    private Parent onSomeViewButtonClickMethod(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader.getRoot();
    }

    @FXML
    public void onViewTracksButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/TrackScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Tracks table");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void onViewGenresButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/GenreScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Genre table");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
