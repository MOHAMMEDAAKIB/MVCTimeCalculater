package com.example.calculaterjavafx.Controller;

import com.example.calculaterjavafx.Model.TimeCalculater;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalTime;


public class TimeCalculaterController {

    public TextField enterTimeOnAction;
    public TextField ExitTimeOnAction;
    public TextField AllocateTime;
    public Label states;
    public Label display;
    private LocalTime enter;
    private LocalTime exit;
    private LocalTime allocate;

    public void CurrentTimeOnAction(ActionEvent actionEvent) {
        states.setText("");
        display.setStyle(String.format("-fx-text-fill: #274472;"));
        display.setText(TimeCalculater.getCurrentTime());
    }

    public void CheckOnAction(ActionEvent actionEvent) {
        states.setText("");
        display.setStyle(String.format("-fx-text-fill: #274472;"));
        try {
            this.enter = TimeCalculater.convertTextToTime(enterTimeOnAction.getText() ,"HH:mm:ss");
            this.exit = TimeCalculater.convertTextToTime(ExitTimeOnAction.getText() ,"HH:mm:ss");
            this.allocate =TimeCalculater.convertTextToTime(AllocateTime.getText(), "HH:mm");

            boolean state = TimeCalculater.check(enter, exit, allocate);
            if (state) {
                display.setStyle(String.format("-fx-text-fill: green;"));
                display.setText("OK");

            }else {
                display.setStyle(String.format("-fx-text-fill: red;"));
                display.setText("Fine");
            }
        }catch (Exception e) {
            states.setStyle(String.format("-fx-text-fill: red;"));
            states.setText("something went wrong. Try again");
        }
    }

    public void UsedTimeOnAction(ActionEvent actionEvent) {
        states.setText("");
        display.setStyle(String.format("-fx-text-fill: #274472;"));
        try {
            this.enter = TimeCalculater.convertTextToTime(enterTimeOnAction.getText() , "HH:mm:ss");
            this.exit = TimeCalculater.convertTextToTime(ExitTimeOnAction.getText() ,"HH:mm:ss");
            display.setText(TimeCalculater.remainder(enter ,exit));
        }catch(Exception e) {
            states.setStyle(String.format("-fx-text-fill: red;"));
            states.setText("something went wrong. Try again");
        }

    }

}
