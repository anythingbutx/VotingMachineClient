package gui.ballots;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import network.util.BallotDTO;

public abstract class Browser extends BorderPane {

    protected final HBox bottomHbox;
    protected final VBox bottomHbox_topVbox;
    protected final Button leftButton;
    protected final VBox bottomHbox_bottomVbox;
    protected final Button rightButton;
    protected final VBox topVbox;
    protected final Label title;

    public Browser() {

        bottomHbox = new HBox();
        bottomHbox_topVbox = new VBox();
        leftButton = new Button();
        bottomHbox_bottomVbox = new VBox();
        rightButton = new Button();
        topVbox = new VBox();
        title = new Label();

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);

        BorderPane.setAlignment(bottomHbox, javafx.geometry.Pos.CENTER);
        bottomHbox.setAlignment(javafx.geometry.Pos.CENTER);
        bottomHbox.setMaxHeight(USE_PREF_SIZE);
        bottomHbox.setMaxWidth(Double.MAX_VALUE);
        bottomHbox.setMinHeight(USE_PREF_SIZE);
        bottomHbox.setMinWidth(USE_PREF_SIZE);
        bottomHbox.setPrefHeight(50.0);
        bottomHbox.setPrefWidth(200.0);

        bottomHbox_topVbox.setAlignment(javafx.geometry.Pos.CENTER);

        leftButton.setAlignment(javafx.geometry.Pos.CENTER);
        leftButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        leftButton.setMnemonicParsing(false);
        leftButton.setText("btn0");
        leftButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        bottomHbox_topVbox.setPadding(new Insets(20.0));

        bottomHbox_bottomVbox.setAlignment(javafx.geometry.Pos.CENTER);

        rightButton.setAlignment(javafx.geometry.Pos.CENTER);
        rightButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        rightButton.setMnemonicParsing(false);
        rightButton.setText("btn1");
        rightButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        bottomHbox_bottomVbox.setPadding(new Insets(20.0));
        bottomHbox.setPadding(new Insets(20.0));
        BorderPane.setMargin(bottomHbox, new Insets(0.0));
        setBottom(bottomHbox);

        BorderPane.setAlignment(topVbox, javafx.geometry.Pos.CENTER);
        topVbox.setAlignment(javafx.geometry.Pos.CENTER);
        topVbox.setMaxHeight(USE_PREF_SIZE);
        topVbox.setMaxWidth(Double.MAX_VALUE);
        topVbox.setPrefHeight(50.0);
        topVbox.setOpaqueInsets(new Insets(0.0));
        BorderPane.setMargin(topVbox, new Insets(0.0));
        topVbox.setPadding(new Insets(10.0));

        title.setAlignment(javafx.geometry.Pos.CENTER);
        title.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        title.setText("Label");
        title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        title.setFont(new Font(24.0));
        setTop(topVbox);

        bottomHbox_topVbox.getChildren().add(leftButton);
        bottomHbox.getChildren().add(bottomHbox_topVbox);
        bottomHbox_bottomVbox.getChildren().add(rightButton);
        bottomHbox.getChildren().add(bottomHbox_bottomVbox);
        topVbox.getChildren().add(title);
    }

    public HBox getBottomHbox() {
        return bottomHbox;
    }

    public VBox getBottomHbox_topVbox() {
        return bottomHbox_topVbox;
    }

    public Button getLeftButton() {
        return leftButton;
    }

    public VBox getBottomHbox_bottomVbox() {
        return bottomHbox_bottomVbox;
    }

    public Button getRightButton() {
        return rightButton;
    }

    public VBox getTopVbox() {
        return topVbox;
    }

    public Label getTitle() {
        return title;
    }

    /**
     * ********* Abstract methods        ************
     */
    abstract public Button initialize(List<BallotDTO> ballots);

    abstract public List<Long> getAllSelectedID();
}
