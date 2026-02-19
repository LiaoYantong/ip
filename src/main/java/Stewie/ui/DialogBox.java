package Stewie.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {
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
