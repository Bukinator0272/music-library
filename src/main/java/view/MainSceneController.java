package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitMainButton;

    @FXML
    private MenuButton mainMenuButton;

    @FXML
    private MenuItem vewLibraryButton;

    @FXML
    public void onExitClickMethod() {
        System.out.println("EIT");
    }
}
