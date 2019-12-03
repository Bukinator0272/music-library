package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class GenreSceneController {

    @FXML
    private TableView<?> genreTable;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Button addGenreButton;

    @FXML
    private Button getGenreButton;

    @FXML
    private Button updateGenreButton;

    @FXML
    private Button deleteGenreButton;

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
    public void onAddGenreButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Enter smth");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void onGetGenreButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Need to write search from DB");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    @FXML
    void onUpdateGenreButtonClickMethod() {
        Parent root = onSomeViewButtonClickMethod("/fxml/EnterScene.fxml");
        Stage stage = new Stage();
        stage.setTitle("Need to write search from DB");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    @FXML
    void onDeleteGenreButtonClickMethod() {
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
