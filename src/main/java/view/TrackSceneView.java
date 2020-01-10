package view;

import controller.GenreController;
import controller.TrackController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import model.impl.TrackImpl;
import model.interfaces.Genre;
import model.interfaces.Track;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TrackSceneView {

    private GenreController genreController = new GenreController();
    private TrackController trackController = new TrackController();

    @FXML
    public Button add_track_button;

    @FXML
    private TableView<Track> tracksTable;

    @FXML
    private TableColumn<Track, String> nameColumn;

    @FXML
    private TableColumn<Track, String> authorColumn;

    @FXML
    private TableColumn<Track, String> albumColumn;

    @FXML
    private TableColumn<Track, Genre> genreColumn;

    @FXML
    private TableColumn<Track, Integer> durationColumn;

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
    void initialize() throws SQLException {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));


        ObservableList<Genre> genres = FXCollections.observableArrayList();
        genres.setAll(genreController.getGenres());
        genreColumn.setCellFactory(ComboBoxTableCell.forTableColumn(genres));
        genreColumn.setOnEditCommit(
                event -> {
                    Genre oldValue = event.getOldValue();
                    Genre newValue = event.getNewValue();
                    if (oldValue != newValue) {
                        Track track = event.getRowValue();
                        track.setGenre(newValue);
                        try {
                            trackController.saveTrack(track);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        editableColumns();
        contextMenu();

        try {
            tracksTable.setItems(initData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Track> initData() throws SQLException {
        ObservableList<Track> tracks = FXCollections.observableArrayList();
        List<Track> tracksDH = trackController.getTracks();
        tracks.addAll(tracksDH);
        return tracks;
    }

    public void addTrack(ActionEvent actionEvent) {
        ObservableList<Track> tracks = tracksTable.getItems();
        tracks.add(new TrackImpl("New Track", "", "", null, 0));
        tracksTable.edit(tracks.size() - 1,nameColumn);
    }


    private void editableColumns() {
        nameColumn.setCellFactory(trackStringTableColumn -> new EditableStringTableCell<Track, String>());
        nameColumn.setOnEditCommit(new TextFieldEventHandler<>() {
            @Override
            public void setField(String value) {
                track.setName(value);
            }
        });

        authorColumn.setCellFactory(trackStringTableColumn -> new EditableStringTableCell<Track, String>());
        authorColumn.setOnEditCommit(new TextFieldEventHandler<>() {
            @Override
            public void setField(String value) {
                track.setAuthor(value);
            }
        });

        albumColumn.setCellFactory(trackStringTableColumn -> new EditableStringTableCell<Track, String>());
        albumColumn.setOnEditCommit(new TextFieldEventHandler<>() {
            @Override
            public void setField(String value) {
                track.setAlbum(value);
            }
        });


        durationColumn.setCellFactory(trackStringTableColumn -> new EditableIntegerTableCell<Track, Integer>());
        durationColumn.setOnEditCommit(new TextFieldEventHandler<>() {
            @Override
            public void setField(Integer value) {
                track.setDuration(value);
            }
        });

        tracksTable.setEditable(true);
    }

    private abstract class TextFieldEventHandler<T> implements EventHandler<TableColumn.CellEditEvent<Track, T>> {
        Track track;

        @Override
        public void handle(TableColumn.CellEditEvent<Track, T> event) {
            track = event.getRowValue();
            T newValue = event.getNewValue();
            T oldValue = event.getOldValue();
            if (newValue != null && !newValue.equals(oldValue)) {
                setField(newValue);
                try {
                    trackController.saveTrack(track);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Значение трека обновилось.");
                return;
            }
        }

        public abstract void setField(T value);
    }


    private void contextMenu() {
        tracksTable.setRowFactory(tv -> {
            TableRow<Track> row = new TableRow<>();
            ContextMenu menu = new ContextMenu();
            MenuItem deleteItem = new MenuItem("Delete");
            menu.getItems().add(deleteItem);

            deleteItem.setOnAction(arg0 -> {
                try {
                    Track track = row.getItem();
                    trackController.deleteTrack(track);
                    ObservableList<Track> genres = tracksTable.getItems();
                    genres.remove(track);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            row.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.SECONDARY && !row.isEmpty()) {
                    menu.show(row, event.getScreenX(), event.getScreenY());
                }
            });
            return row;
        });
    }
}
