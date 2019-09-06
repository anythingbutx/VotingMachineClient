package gui.ballots;

import java.util.List;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import network.util.CandidateDTO;

public abstract class Page extends ScrollPane {

    protected final VBox vBoxColumns;


    public Page() {

        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);
        
        vBoxColumns = new VBox();
        vBoxColumns.setAlignment(javafx.geometry.Pos.CENTER);
        vBoxColumns.setMaxHeight(Double.MAX_VALUE);
        vBoxColumns.setMaxWidth(Double.MAX_VALUE);
        this.setContent(vBoxColumns);
    }

    public VBox getvBoxColumns() {
        return vBoxColumns;
    }
    
    /***********     Abstract methods        *************/
    
    abstract public void initialize(String title, List<CandidateDTO> candidates);
    abstract public Person getSelectedPerson(boolean clone);
    abstract public String getTitle(); 
    
}
