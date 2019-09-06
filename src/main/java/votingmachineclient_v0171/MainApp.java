package votingmachineclient_v0171;

import gui.ballots.Browser;
import gui.ballots.BrowserImpl;
import gui.login.Login;
import gui.login.LoginImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import network.util.BallotDTO;
import network.util.CandidateDTO;
import network.util.RestConnector;

public class MainApp extends Application {

    private final RestConnector restConnector = new RestConnector();
    private final AnchorPane mainPane = new AnchorPane();
    private Login loginPane = new LoginImpl();
    private Browser browserPane = new BrowserImpl();
    private final Scene scene = new Scene(mainPane);
    private String voterID;

    @Override
    public void start(Stage stage) throws Exception {

        loginPane.getLoginBtn().setOnAction((event) -> {
            voterID = loginPane.getVoterID();
            List<BallotDTO> dtoList = restConnector.getBallots(voterID);
            if (dtoList != null && !dtoList.isEmpty()) {
                browserPane.initialize(dtoList).setOnAction((e) -> {
                    List<Long> ids = browserPane.getAllSelectedID();
                    ids.forEach((id) -> restConnector.postVote(voterID, id));
                    voterID = "";
                    this.clearAndAdd(mainPane, loginPane);
                });
                this.clearAndAdd(mainPane, browserPane);
            } else {
                voterID = "";
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Login values are incorrect!");
                alert.setContentText("No Ballots found for given voter id.");
                alert.showAndWait();
            }

        });

        mainPane.getChildren().add(loginPane);
        stage.setScene(scene);
        stage.show();
    }

    private void clearAndAdd(Pane pane, Pane addPane) {
        pane.getChildren().clear();
        pane.getChildren().add(addPane);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
