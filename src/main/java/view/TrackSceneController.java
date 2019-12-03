package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TrackSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    private Button addTrackButton;

    @FXML
    private Button getTrackButton;

    @FXML
    private Button updateTrackButton;

    @FXML
    private Button deleteTrackButton;

    @FXML
    void onaddTrackButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void ondeleteTrackButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void ongetTrackButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void onupdateTrackButtonClickMethod(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
