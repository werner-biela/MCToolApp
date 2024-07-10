import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private CheckBox cbNetherCord;
    @FXML
    private TextArea textAreaResults;
    @FXML
    private TextField textFieldXCord;
    @FXML
    private TextField textFieldYCord;
    @FXML
    private Label lbCurrentLocation;

    @FXML
    private void onButtonClick(ActionEvent event) {
        // System.out.println("Button Test Pass");
        String inputX = textFieldXCord.getText();
        String inputY = textFieldYCord.getText();
        String regexTest = "[-0-9]+";

        if (inputX.isEmpty() || inputY.isEmpty()) {
            // System.out.println("Both cords must be input!");
            textAreaResults.clear();
            textAreaResults.appendText("Both cords must be input!");
        } else if (!inputX.matches(regexTest) || !inputY.matches(regexTest)) {
            // System.out.println("Only integers are accepted!");
            textAreaResults.clear();
            textAreaResults.appendText("Only integers are accepted!");
        } else {
            if (!cbNetherCord.isSelected()) {
                locateLocalChunk(inputX, inputY);
            } else {
                getNetherCords(inputX, inputY);
            }
        }
    }

    @FXML
    private void clearAll() {
        textFieldXCord.clear();
        textFieldYCord.clear();
        textAreaResults.clear();
        cbNetherCord.setSelected(false);
    }

    private void locateLocalChunk(String inputX, String inputY) {
        int x = Integer.parseInt(inputX);
        int y = Integer.parseInt(inputY);
        Point P0 = new Point(x, y);
        textAreaResults.clear();
        textAreaResults.appendText(P0.localChunk());
    }

    private void getNetherCords(String inputX, String inputY) {
        int x = Integer.parseInt(inputX);
        int y = Integer.parseInt(inputY);
        Point P0 = new Point(x, y);
        textAreaResults.clear();
        textAreaResults.appendText(P0.netherCoordinates());
    }
}
