package gui.ballots;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class Person extends VBox {

    protected final HBox hBoxTop, hBoxBottom;
    protected final ImageView imageView;
    protected final Label nameLabel;

    public Person() {

        hBoxTop = new HBox();
        imageView = new ImageView();
        hBoxBottom = new HBox();
        nameLabel = new Label();

        hBoxTop.setAlignment(javafx.geometry.Pos.CENTER);

        HBox.setHgrow(imageView, javafx.scene.layout.Priority.NEVER);
        VBox.setVgrow(imageView, javafx.scene.layout.Priority.NEVER);
        imageView.setFitHeight(200.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        hBoxBottom.setAlignment(javafx.geometry.Pos.CENTER);

        VBox.setVgrow(nameLabel, javafx.scene.layout.Priority.ALWAYS);
        nameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        nameLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        nameLabel.setText("Label");
        nameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        nameLabel.setFont(new Font(14.0));

        hBoxTop.getChildren().add(imageView);
        getChildren().add(hBoxTop);
        hBoxBottom.getChildren().add(nameLabel);
        getChildren().add(hBoxBottom);
    }

    public HBox getHBoxTop() {
        return hBoxTop;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public HBox getHBoxBottom() {
        return hBoxBottom;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    /***********     Abstract methods        *************/
    
    
    abstract public Long getCandidateID();
    
    abstract public void select();
    
    abstract public void unselect();
    
    abstract public boolean isSelected();
    
    abstract public void enableSelect(boolean bool);
    
    abstract public Person makeClone();

}
