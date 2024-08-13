package com.cpllabs.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Paths;

public class MainController {
    @FXML
    private TextField outputPath, bundlePath, keyAlias;
    @FXML
    private TextField keyStorePathIn;
    @FXML
    private Pane keyStorePane;
    @FXML
    private CheckBox keyStoreCheckBox, buildUniversalCheckbox;
    @FXML
    private PasswordField keyStorePasswordIn, keyPassIn;

    private String bundleLocation, outputLocation, keyStoreLocation, keyStorePassword, keyAppAlias, keyPassword;

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
            info.setHeaderText(null);
            info.setContentText("Please Select App Bundle To Build APKS From");
            info.showAndWait();
            return null;
        } else {
            bundlePath.setText(selected.getAbsolutePath());
            bundleLocation = selected.getAbsolutePath();
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
            info.setHeaderText(null);
            info.setContentText("Please Select Output Folder");
            info.showAndWait();
            return null;
        } else {
            outputPath.setText(selected.getAbsolutePath());
            outputLocation = selected.getAbsolutePath();
            return selected.getAbsolutePath();
        }
    }

    @FXML
    protected void usingKeyStore() {
        if (keyStoreCheckBox.isSelected()) {
            keyStorePane.setDisable(false);
        } else {
            keyStorePane.setDisable(true);
        }
    }

    @FXML
    protected String chooseKeyStore() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Bundle File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "KeyStore", "*.keystore", "*.jks", "*.p12", "*.pfx"));
        File selected = fileChooser.showOpenDialog(null);
        if (selected == null) {
            Alert info = new Alert(Alert.AlertType.ERROR);
            info.setTitle("Select App Bundle");
            info.setHeaderText(null);
            info.setContentText("Please Select App Bundle To Build APKS From");
            info.showAndWait();
            return null;
        } else {
            keyStorePathIn.setText(selected.getAbsolutePath());
            keyStoreLocation = selected.getAbsolutePath();
            return selected.getAbsolutePath();
        }
    }

    @FXML
    protected void Build() {
        keyStorePassword = keyStorePasswordIn.getText();
        keyAppAlias = keyAlias.getText();
        keyPassword = keyPassIn.getText();
        boolean universal = buildUniversalCheckbox.isSelected();
        int outputCode =  new Builder().buildAPKS(bundleLocation, outputLocation, keyStoreLocation, keyStorePassword,keyPassword, keyAppAlias, universal);
        Alert outputAlert = new Alert(Alert.AlertType.NONE);
        if (outputCode == 0) {
            outputAlert.setAlertType(Alert.AlertType.INFORMATION);
            outputAlert.setTitle("Success");
            outputAlert.setHeaderText(null);
            outputAlert.setContentText("APKS Saved In " +  Paths.get(bundleLocation, "OUTPUT.apks"));
            outputAlert.show();
        }
        else {
            outputAlert.setAlertType(Alert.AlertType.ERROR);
            outputAlert.setTitle("Error");
            outputAlert.setHeaderText(null);
            outputAlert.setContentText("Some Error Occurred Executing Process");
            outputAlert.show();
        }
    }


}