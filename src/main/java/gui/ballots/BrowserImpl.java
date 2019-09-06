/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ballots;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import network.util.BallotDTO;

public class BrowserImpl extends Browser {

    private Button doneTrigger;
    private List<Page> pages;
    private int pageIndex;

    public BrowserImpl() {
        super();
        this.pageIndex = 0;
        this.doneTrigger = new Button();
        this.rightButton.setOnAction((event) -> loadNextPage());
        this.leftButton.setOnAction((event) -> loadLastPage());
    }

    private void loadPage(Page page) {
        this.title.setText(page.getTitle());
        this.setCenter(page);
    }

    private void loadPageAtIndex(int i) {
        if (i >= 0 && i < pages.size()) {
            loadPage(this.pages.get(i));
            this.pageIndex = i;
        } else if (i == pages.size()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Submit ballot votes");
            alert.setContentText("Do you wish to submit your votes for the selected candidates?");      
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) this.doneTrigger.fire();
        }
        onLoadPage();
    }

    private void onLoadPage() {
        if (pageIndex == 0) {
            this.leftButton.setDisable(true);
        } else {
            this.leftButton.setDisable(false);
        }
    }

    private void loadNextPage() {
        loadPageAtIndex(pageIndex + 1);
    }

    private void loadLastPage() {
        loadPageAtIndex(pageIndex - 1);
    }

    @Override
    public Button initialize(List<BallotDTO> ballots) {
        this.pages = new ArrayList<Page>();
        for (BallotDTO dto : ballots) {
            Page page = new PageImpl();
            page.initialize(dto.getTitle(), dto.getCandidates());
            this.pages.add(page);
        }
        this.loadPageAtIndex(0);
        return this.doneTrigger;
    }

    @Override
    public List<Long> getAllSelectedID() {
        List<Long> ids = new ArrayList<>();
        pages.forEach((page) -> ids.add(page.getSelectedPerson(false).getCandidateID()));
        return ids;
    }

}
