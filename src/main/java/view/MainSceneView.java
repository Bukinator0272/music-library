package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneView {

    @FXML
    public void onViewTracksButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/TrackScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Tracks table");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void onViewGenresButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/GenreScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Genres table");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
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
}
