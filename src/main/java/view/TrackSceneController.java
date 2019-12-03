package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TrackSceneController {

    @FXML
    private TableView<?> tracksTable;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableColumn<?, ?> albumColumn;

    @FXML
    private TableColumn<?, ?> genreColumn;

    @FXML
    private TableColumn<?, ?> durationColumn;

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
    public void onAddTrackButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Enter smth");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void onDeleteTrackButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Need to write search from DB");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    @FXML
    void onGetTrackButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Need to write search from DB");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    @FXML
    void onUpdateTrackButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Need to write search from DB");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    @FXML
    void initialize() {

    }

}
