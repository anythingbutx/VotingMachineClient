package gui.ballots;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;

public class PersonImpl extends Person {

    private final Long id;
    private final Glow glow;
    private final double glowHover, glowSelect;
    private final String imageURL;
    private boolean selected, selectionEnabled;
    private final String cssBorder = "-fx-border-color: transparent;\n" + "-fx-border-insets: 0;\n" + "-fx-border-width: 4;\n";
    private final String cssBorderBlack = "-fx-border-color: black;\n" + "-fx-border-insets: 0;\n" + "-fx-border-width: 4;\n";
    
    
    public PersonImpl(Long id, String name, String imageURL) {
        super();
        this.id = id;
        this.nameLabel.setText(name);
        this.imageURL = imageURL;
        this.selected = false;
        this.selectionEnabled = false;
        this.glow = new Glow();
        this.glowHover = 0.3;
        this.glowSelect = 0.6;
        
        this.setStyle(cssBorder);
        
        if (this.imageURL.indexOf("http") == 0) {
            imageView.setImage(new Image(this.imageURL));
        } else {
            imageView.setImage(new Image(getClass().getResource(this.imageURL).toExternalForm()));
        }
        this.glow.setLevel(0.0);
        this.setEffect(glow);

        imageView.setOnMouseEntered((event) -> {
            if (this.selectionEnabled) {
                this.glow.setLevel(this.glowHover);
            }
        });

        imageView.setOnMouseExited((event) -> {
            if (this.selectionEnabled) {
                this.glow.setLevel(0.0);
            }
        });
    }

    public PersonImpl(Long id, String name) {
        this(id, name, "/pictures/human_avatar_portrait.png");
    }

    @Override
    public void select() {
        if (this.selectionEnabled) {
            if (this.selected) {
                this.unselect();
            } else {
                this.setStyle(cssBorderBlack);
                this.selected = true;
            }
        }
    }

    @Override
    public void unselect() {
        if (this.selectionEnabled) {
            this.setStyle(cssBorder);
            this.selected = false;
        }
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void enableSelect(boolean bool) {
        this.selectionEnabled = bool;
        if (this.selectionEnabled && this.isSelected()) {
            this.setStyle(cssBorderBlack);
        } else {
            this.setStyle(cssBorder);
        }
    }

    @Override
    public Person makeClone() {
        return new PersonImpl(this.id, this.nameLabel.getText(), this.imageURL);
    }

    @Override
    public Long getCandidateID() {
        return this.id;
    }

}
