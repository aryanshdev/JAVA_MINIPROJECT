package com.cpllabs.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;

public class HelloController {
    @FXML
    private TextField outputPath;
    @FXML
    private TextField bundlePath;
    @FXML
    private Pane keyStorePane;
    @FXML
    private CheckBox keyStoreCheckBox;

    @FXML
    protected String chooseAppBundle() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Bundle File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "App Bundle", "*.aab"));
        File selected = fileChooser.showOpenDialog(null);
        if (selected == null) {
            Alert info = new Alert(Alert.AlertType.ERROR);
            info.setTitle("Select App Bundle");
            info.setContentText("Please Select App Bundle To Build APKS From");
            info.showAndWait();
            return null;
        }
       else{
            bundlePath.setText(selected.getAbsolutePath());
            return selected.getAbsolutePath();
        }
    }
    @FXML
    protected String chooseOutputFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Output Folder");
        File selected = directoryChooser.showDialog(null);
        if (selected == null) {
            Alert info = new Alert(Alert.AlertType.ERROR);
            info.setTitle("Select Output Bundle");
            info.setContentText("Please Select Output Folder");
            info.showAndWait();
            return null;
        }
        else{
            outputPath.setText(selected.getAbsolutePath());
            return selected.getAbsolutePath();
        }
    }
    @FXML
    protected void usingKeyStore(){
        if(keyStoreCheckBox.isSelected()){
            keyStorePane.setDisable(false);
        }
        else {
            keyStorePane.setDisable(true);
        }
    }

}