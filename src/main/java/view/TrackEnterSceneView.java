package view;

import controller.TrackController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackEnterSceneView {

    private TrackController controller;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField albumTextField;

    @FXML
    private TextField genreTextField;

    @FXML
    private TextField durationTextField;

    @FXML
    private TextField searchValueTextField;

    @FXML
    private TextField newValueTextField;

    @FXML
    private ToggleGroup objectPropertyToggleButtons;

    @FXML
    private RadioButton namePropertyToggleButton;

    @FXML
    private RadioButton authorPropertyToggleButton;

    @FXML
    private RadioButton albumPropertyToggleButton;

    @FXML
    private RadioButton genrePropertyToggleButton;

    @FXML
    private RadioButton durationPropertyToggleButton;

    @FXML
    private Button addTrackButton;

    @FXML
    private Button updateTrackButton;

    @FXML
    private Button deleteTrackButton;

    @FXML
    void onAddTrackButtonClickMethod() {
        controller.addTrack(
                nameTextField.getText(),
                authorTextField.getText(),
                albumTextField.getText(),
                genreTextField.getText(),
                Integer.parseInt(durationTextField.getText())
        );
        Stage currentStage = (Stage) addTrackButton.getScene().getWindow();
        currentStage.close();
        openTrackTableScene();
    }

    @FXML
    void onDeleteTrackButtonClickMethod() {
        //controller.deleteTrack(searchValueTextField.getText());
        Stage currentStage = (Stage) deleteTrackButton.getScene().getWindow();
        currentStage.close();
        openTrackTableScene();
    }

    @FXML
    void onUpdateTrackButtonClickMethod() {
        if (objectPropertyToggleButtons.getSelectedToggle() == namePropertyToggleButton) {
            // controller.updateTrack(searchValueTextField.getText(), 1, newValueTextField.getText());
            Stage currentStage = (Stage) updateTrackButton.getScene().getWindow();
            currentStage.close();
            openTrackTableScene();
            return;
        }
        if (objectPropertyToggleButtons.getSelectedToggle() == authorPropertyToggleButton) {
            // controller.updateTrack(searchValueTextField.getText(), 2, newValueTextField.getText());
            Stage currentStage = (Stage) updateTrackButton.getScene().getWindow();
            currentStage.close();
            openTrackTableScene();
            return;
        }
        if (objectPropertyToggleButtons.getSelectedToggle() == albumPropertyToggleButton) {
            // controller.updateTrack(searchValueTextField.getText(), 3, newValueTextField.getText());
            Stage currentStage = (Stage) updateTrackButton.getScene().getWindow();
            currentStage.close();
            openTrackTableScene();
            return;
        }
        if (objectPropertyToggleButtons.getSelectedToggle() == genrePropertyToggleButton) {
            //  controller.updateTrack(searchValueTextField.getText(), 4, newValueTextField.getText());
            Stage currentStage = (Stage) updateTrackButton.getScene().getWindow();
            currentStage.close();
            openTrackTableScene();
            return;
        }
        if (objectPropertyToggleButtons.getSelectedToggle() == durationPropertyToggleButton) {
            // controller.updateTrackDuration(searchValueTextField.getText(), Long.parseLong(durationTextField.getText()));
            Stage currentStage = (Stage) updateTrackButton.getScene().getWindow();
            currentStage.close();
            openTrackTableScene();
        }
    }

    @FXML
    private void openTrackTableScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/TrackScene.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Tracks table");
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

}
