package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;

public class IntermediateController implements ISubject {

    @FXML
    private ImageView backButton;

    private final String theme = "theme_2";

    private static IntermediateController instance;

    public static IntermediateController getInstance() {
        return instance;
    }

    public IntermediateController() {
        instance = this;
    }



}
