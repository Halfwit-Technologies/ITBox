package tech.halfwit.itbox;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static SceneManager instance;
    private static Stage currStage;

    private SceneManager() {
        currStage = ItBoxApplication.getStage();
    }

    public static SceneManager getInstance() {
        if(instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void loadScene(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ItBoxApplication.class.getResource(fxmlFile));
            currStage.setScene(new Scene(fxmlLoader.load(), 1920, 1080));
            currStage.setTitle("ITBox - Halfwit Technologies");
            currStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
