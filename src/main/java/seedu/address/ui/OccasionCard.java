package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.occasion.Occasion;

/**
 * An UI component that displays information of a {@code Occasion}.
 * @author xueyantian
 */

public class OccasionCard extends UiPart<Region> {

    private static final String FXML = "OccasionListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */
    public final Occasion occasion;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label occasionName;
    @FXML
    private Label occasionDate;
    @FXML
    private FlowPane tags;

    public OccasionCard(Occasion occasion, int displayedIndex) {
        super(FXML);
        this.occasion = occasion;
        id.setText(displayedIndex + ". ");
        occasionName.setText(occasion.getOccasionName().fullOccasionName);
        occasionDate.setText("Date: " + occasion.getOccasionDate().fullOccasionDate);
        occasion.getTags().forEach((value) -> tags.getChildren().add(new Label(value.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        //short circuit if same object
        if (other == this) {
            return true;
        }

        //instanceof handles nulls
        if (!(other instanceof OccasionCard)) {
            return false;
        }

        //state check
        OccasionCard card = (OccasionCard) other;
        return id.getText().equals(card.id.getText())
                && occasionName.getText().equals((card.occasionName.getText()))
                && occasionDate.getText().equals((card.occasionDate.getText()));
    }
}
