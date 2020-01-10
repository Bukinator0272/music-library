package view;

import controller.GenreController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import model.impl.GenreImpl;
import model.interfaces.Genre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GenreSceneView {

    private GenreController controller = new GenreController();

    @FXML
    private TableView<Genre> genresTable;

//    @FXML
//    private TableColumn<Genre, Long> idColumn;

    @FXML
    private TableColumn<Genre, String> nameColumn;

    @FXML
    private Button editTableButton;

    @FXML
    private Button add_genre_btn;

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
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        editableColumns();
        contextMenu();
        genresTable.setItems(initData());
    }

    private ObservableList<Genre> initData() throws SQLException {
        ObservableList<Genre> genres = FXCollections.observableArrayList();
        List<Genre> genresDH = controller.getGenres();
        genres.addAll(genresDH);


        for (Genre genre : genresDH) {
            System.out.println(genre.getName());
        }

        return genres;
    }


    private void contextMenu() {


        genresTable.setRowFactory(tv -> {
            TableRow<Genre> row = new TableRow<>();
            ContextMenu menu = new ContextMenu();
            MenuItem deleteItem = new MenuItem("Delete");
            menu.getItems().add(deleteItem);

            deleteItem.setOnAction(arg0 -> {
                try {
                    Genre genre = row.getItem();
                    controller.deleteGenre(genre);
                    ObservableList<Genre> genres = genresTable.getItems();
                    genres.remove(genre);
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

    private void editableColumns() {
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            Genre genre = event.getRowValue();
            String newValue = event.getNewValue();
            String oldValue = event.getOldValue();

            if (!newValue.equals(oldValue) && !newValue.isEmpty()) {
                genre.setName(event.getNewValue());
                try {
                    controller.saveGenre(genre);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Значение жанра обновилось.");
                return;
            }
            genre.setName(event.getOldValue());

        });
        genresTable.setEditable(true);
    }

    public void addGenre(ActionEvent actionEvent) {
        ObservableList<Genre> genres = genresTable.getItems();
        genres.add(new GenreImpl("New Genre"));
        genresTable.edit(genres.size() - 1, nameColumn);
    }
}
