package view;

import controller.TrackController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.interfaces.Track;

import java.io.IOException;

public class TrackSceneView {

    private TrackController controller;

    @FXML
    private TableView<Track> tracksTable;

    @FXML
    private TableColumn<Track, Long> idColumn;

    @FXML
    private TableColumn<Track, String> nameColumn;

    @FXML
    private TableColumn<Track, String> authorColumn;

    @FXML
    private TableColumn<Track, String> albumColumn;

    @FXML
    private TableColumn<Track, String> genreColumn;

    //need to decide type of duration
    @FXML
    private TableColumn<Track, Long> durationColumn;

    @FXML
    private Button editTableButton;

    @FXML
    private void onEditTableButtonClickMethod() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/TrackEnterScene.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Track enter");
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
        Stage currentStage = (Stage) editTableButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        tracksTable.setItems(initData());
    }

    private ObservableList<Track> initData() {
        ObservableList<Track> tracks = FXCollections.observableArrayList();
//        for (int i = 0; i < controller.getTracksCount(); i++) {
//            tracks.add(controller.getTracks()[i]);
//        }
        return tracks;
    }

}
