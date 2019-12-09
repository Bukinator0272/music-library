package view;

import controller.GenreController;
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
import model.interfaces.Genre;

import java.io.IOException;
import java.sql.SQLException;

public class GenreSceneView {

    private GenreController controller;

    @FXML
    private TableView<Genre> genresTable;

    @FXML
    private TableColumn<Genre, Long> idColumn;

    @FXML
    private TableColumn<Genre, String> nameColumn;

    @FXML
    private Button editTableButton;

    @FXML
    private void onEditTableButtonClickMethod() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/GenreEnterScene.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Genre enter");
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
        Stage currentStage = (Stage) editTableButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void initialize() throws SQLException {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genresTable.setItems(initData());
    }

    private ObservableList<Genre> initData() throws SQLException {
        ObservableList<Genre> genres = FXCollections.observableArrayList();
        for (int i = 0; i < controller.getGenresCount(); i++) {
            genres.add(controller.getGenres().get(i));
        }
        return genres;
    }

}
