package Stewie.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a single chat message in the GUI, displayed as a horizontal box
 * containing a text label and an avatar image.
 * <p>
 * The dialog box aligns messages differently depending on whether it is from
 * the user or from Stewie. User messages are aligned to the right, while
 * Stewie's messages are aligned to the left.
 */
public class DialogBox extends HBox {
    /**
     * Creates a DialogBox containing a text message and an avatar image.
     *
     * @param text   The message text to display.
     * @param img    The avatar image to display alongside the text.
     * @param isUser True if the message is from the user, false if from Stewie.
     */
    public DialogBox(String text, Image img, boolean isUser) {
        Label label = new Label(text);
        label.setWrapText(true);
        ImageView displayPicture = new ImageView(img);
        displayPicture.setFitWidth(50);
        displayPicture.setFitHeight(50);

        if (isUser) {
            this.setAlignment(Pos.TOP_RIGHT);
            this.getChildren().addAll(label, displayPicture);
        } else {
            this.setAlignment(Pos.TOP_LEFT);
            this.getChildren().addAll(displayPicture, label);
        }

        this.setSpacing(10);
    }
}
