package gui.ballots;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import network.util.CandidateDTO;

public class PageImpl extends Page {

    private String title;
    private List<Person> persons;

    public PageImpl() {
        super();
    }

    private HBox hBoxRow() {
        HBox hBox = new HBox();
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setFillHeight(true);
        return hBox;
    }

    private VBox paddedContainer(int pad, Pane pane) {
        VBox container = new VBox();
        container.setAlignment(javafx.geometry.Pos.CENTER);
        container.setPadding(new Insets(pad, pad, pad, pad));
        container.getChildren().add(pane);
        return container;
    }
    
    private Person fromDTOtoPerson(CandidateDTO dto) {
        Person person;
        if (dto.getPhotoURL() == null || dto.getPhotoURL().isEmpty()) {
            person = new PersonImpl(dto.getId(), dto.getDisplayName());
        } else {
            person = new PersonImpl(dto.getId(), dto.getDisplayName(), dto.getPhotoURL());
        }
        return person;
    }

    private void addSelectionEvent() {
        for (Person person : this.persons) {
            person.setOnMousePressed((event) -> {
                for (Person p : this.persons) {
                    if (person == p) {
                        person.select();
                    } else {
                        p.unselect();
                    }
                }
            });
        }
    }

    private void addPersonsToPage(List<Person> list, int width) {
        int i = 1;
        HBox hb = hBoxRow();
        for (Person person : list) {
            hb.getChildren().add(paddedContainer(20, person));
            if ((i % width) == 0 || i == (list.size())) {
                this.vBoxColumns.getChildren().add(hb);
                hb = hBoxRow();
            }
            i++;
        }
    }

    @Override
    public void initialize(String title, List<CandidateDTO> list) {
        this.title = title;
        this.persons = new ArrayList<>();
        for (CandidateDTO dto : list) {
            Person person = fromDTOtoPerson(dto);
            person.enableSelect(true);
            this.persons.add(person);
        }
        addPersonsToPage(this.persons, 4);
        addSelectionEvent();
    }

    @Override
    public Person getSelectedPerson(boolean clone) {
        for (Person p : this.persons) {
            if (p.isSelected()) {
                if (clone) {
                    return p.makeClone();
                }
                return p;
            }
        }
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
