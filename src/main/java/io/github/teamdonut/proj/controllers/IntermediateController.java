package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.listener.ISubject;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 * Intermediate Screen controller class where the player can enter their name
 * @author Utsav Parajuli
 * @version 0.1
 */
public class IntermediateController implements ISubject {

    @FXML
    private ImageView backButton;

    private static IntermediateController instance;

    /**
     * This method will return the instance of the controller
     * @author Utsav Parajuli
     * @return this
     */
    public static IntermediateController getInstance() {
        return instance;
    }

    /**
     * Constructor
     * @author Utsav Parajuli
     */
    public IntermediateController() {
        instance = this;
    }
}
