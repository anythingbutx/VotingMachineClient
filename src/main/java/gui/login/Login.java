package gui.login;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class Login extends BorderPane {

    protected final VBox vBox;
    protected final HBox hBox;
    protected final Label label;
    protected final PasswordField idField;
    protected final VBox vBox0;
    protected final Button btnLogin;

    public Login() {

        vBox = new VBox();
        hBox = new HBox();
        label = new Label();
        idField = new PasswordField();
        vBox0 = new VBox();
        btnLogin = new Button();

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
        
        //setPrefHeight(400.0);
        //setPrefWidth(600.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        label.setText("Voter ID:");
        HBox.setMargin(label, new Insets(10.0));
        label.setFont(new Font(14.0));

        idField.setMaxHeight(USE_PREF_SIZE);
        idField.setMaxWidth(USE_PREF_SIZE);
        idField.setMinHeight(USE_PREF_SIZE);
        idField.setMinWidth(USE_PREF_SIZE);
        idField.setPrefHeight(25.0);
        idField.setPrefWidth(150.0);
        HBox.setMargin(idField, new Insets(10.0));
        setCenter(vBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.CENTER);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setMaxWidth(Double.MAX_VALUE);
        vBox0.setPrefHeight(50.0);
        vBox0.setPrefWidth(100.0);

        btnLogin.setMnemonicParsing(false);
        btnLogin.setText("Login");
        setBottom(vBox0);

        hBox.getChildren().add(label);
        hBox.getChildren().add(idField);
        vBox.getChildren().add(hBox);
        vBox0.getChildren().add(btnLogin);

    }
    
    abstract public Button getLoginBtn();
    abstract public String getVoterID();
}
