package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.impl.TrackImpl;
import model.interfaces.Track;

import java.io.IOException;
import java.util.UUID;

public class TrackSceneView {

    @FXML
    private TableView<Track> tracksTable;

    @FXML
    private TableColumn<Track, UUID> idColumn;

    @FXML
    private TableColumn<Track, String> nameColumn;

    @FXML
    private TableColumn<Track, String> authorColumn;

    @FXML
    private TableColumn<Track, String> albumColumn;

    @FXML
    private TableColumn<Track, String> genreColumn;

    @FXML
    private TableColumn<Track, ?> durationColumn;

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

    private ObservableList<Track> initData() {
        ObservableList<Track> tracks = FXCollections.observableArrayList();
        tracks.add(new TrackImpl(UUID.randomUUID(), "pog1", "anime1", "rofl1", "kek1", 5));
        tracks.add(new TrackImpl(UUID.randomUUID(), "pog2", "anime2", "rofl2", "kek2", 10));
        tracks.add(new TrackImpl(UUID.randomUUID(), "pog3", "anime3", "rofl3", "kek3", 15));
        tracks.add(new TrackImpl(UUID.randomUUID(), "pog4", "anime4", "rofl4", "kek4", 20));
        tracks.add(new TrackImpl(UUID.randomUUID(), "pog5", "anime5", "rofl5", "kek5", 25));
        return tracks;
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

}
