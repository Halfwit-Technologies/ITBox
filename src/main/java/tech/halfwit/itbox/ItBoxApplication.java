package tech.halfwit.itbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tech.halfwit.subnetcalculator.NetAddress;
import tech.halfwit.subnetcalculator.Subnet;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ItBoxApplication extends Application {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        SceneManager manager = SceneManager.getInstance();
        manager.loadScene("main-page.fxml");
    }

    @Override
    public void stop() {}

    public static void main(String[] args) {
        //byte test = (byte) 256;
        //int mask = 0xFF;
        //System.out.println(test & mask);
        Subnet test = new Subnet("test",new NetAddress(new byte[]{(byte)172,(byte)16,(byte)0,(byte)0}),15);
        /*
        int subnetMaskNet = (0xFFFFFFFF << (32-27));
        System.out.println(subnetMaskNet);
        byte[] temp = ByteBuffer.allocate(4).putInt(subnetMaskNet).array();
        System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]);
        NetAddress subnetMask = new NetAddress(temp);
        System.out.println(subnetMask);

         */
        //launch();
    }
}
