package view;

import controller.GenreController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GenreEnterSceneView {

    private GenreController controller = new GenreController();

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextField newNameTextField;

    @FXML
    private Button addGenreButton;

    @FXML
    private Button updateGenreButton;

    @FXML
    private Button deleteGenreButton;

    @FXML
    private void onAddGenreButtonClickMethod() throws SQLException {
        controller.saveGenre(nameTextField.getText());
        Stage currentStage = (Stage) addGenreButton.getScene().getWindow();
        currentStage.close();
        openGenreTableScene();
    }

    @FXML
    private void onDeleteGenreButtonClickMethod() throws SQLException {
        controller.deleteGenre(searchTextField.getText());
        Stage currentStage = (Stage) deleteGenreButton.getScene().getWindow();
        currentStage.close();
        openGenreTableScene();
    }

    @FXML
    private void onUpdateGenreButtonClickMethod() throws SQLException {
        Stage currentStage = (Stage) updateGenreButton.getScene().getWindow();
        currentStage.close();
        openGenreTableScene();
    }

    @FXML
    private void openGenreTableScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/GenreScene.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Genres table");
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }
}
