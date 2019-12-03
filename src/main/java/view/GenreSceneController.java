package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GenreSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    void onaddGenreButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void ondeleteGenreButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void ongetGenreButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void onupdateGenreButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
