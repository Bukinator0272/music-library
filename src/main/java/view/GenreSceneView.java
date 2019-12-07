package view;

import java.io.IOException;
import java.util.UUID;

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
import model.impl.GenreImpl;
import model.interfaces.Genre;

public class GenreSceneView {

    @FXML
    private TableView<Genre> genresTable;

    @FXML
    private TableColumn<Genre, UUID> idColumn;

    @FXML
    private TableColumn<Genre, String> nameColumn;

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

    private ObservableList<Genre> initData() {
        ObservableList<Genre> genres = FXCollections.observableArrayList();
        genres.add(new GenreImpl(UUID.randomUUID(), "pog1"));
        genres.add(new GenreImpl(UUID.randomUUID(), "pog2"));
        genres.add(new GenreImpl(UUID.randomUUID(), "pog3"));
        genres.add(new GenreImpl(UUID.randomUUID(), "pog4"));
        genres.add(new GenreImpl(UUID.randomUUID(), "pog5"));
        return genres;
    }

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genresTable.setItems(initData());
    }
}
