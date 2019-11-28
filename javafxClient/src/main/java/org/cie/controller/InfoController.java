package org.cie.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoController implements Initializable {

    @FXML
    ListView<String> carsList;

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> data = FXCollections.observableArrayList();
        carsList = new ListView<String>(data);

    }


    public void carSelected(ListView.EditEvent editEvent) {
        editEvent.getIndex();
    }
}
