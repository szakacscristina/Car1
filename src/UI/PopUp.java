
package UI;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class PopUp {
    /*
     * Creates a JavaFX pop-up window with custom messages as Labels
     * */
    public static void createPopup(String...args){
        Stage newStage = new Stage();
        HBox content = new HBox();
        content.setAlignment(Pos.CENTER);

        for(String arg: args){
            Label message = new Label(arg);
            content.getChildren().add(message);
        }

        Scene scene = new Scene(content, 300, 50);
        newStage.setScene(scene);
        newStage.show();
    }
}