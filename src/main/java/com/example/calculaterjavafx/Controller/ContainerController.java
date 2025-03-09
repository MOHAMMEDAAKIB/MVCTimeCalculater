package com.example.calculaterjavafx.Controller;

import com.example.calculaterjavafx.Model.Container;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class ContainerController {
    @FXML private TableView<Container> table;
    @FXML private TableColumn<Container, String> idCol;
    @FXML private TableColumn<Container, String> locationCol;
    @FXML private TableColumn<Container, String> statusCol;
    @FXML private TextField idField;
    @FXML private TextField locationField;
    @FXML private TextField statusField;

    private ObservableList<Container> containerList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        idCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId()));
        locationCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocation()));
        statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        table.setItems(containerList);
    }

    @FXML
    public void handleAddContainer() {
        String id = idField.getText();
        String location = locationField.getText();
        String status = statusField.getText();

        if (id.isEmpty() || location.isEmpty() || status.isEmpty()) {
            System.out.println("Please fill all fields!");
            return;
        }

        Container newContainer = new Container(id, location, status);
        containerList.add(newContainer);
        idField.clear();
        locationField.clear();
        statusField.clear();
        idField.focusedProperty();
    }
    


    public void TimeCalculaterOnAction(ActionEvent actionEvent ) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/calculaterjavafx/viwe/TimeCalculater.fxml"));
            Parent parent = loader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Time Calculator");
            newStage.setScene(new Scene(parent));
            newStage.centerOnScreen();
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
