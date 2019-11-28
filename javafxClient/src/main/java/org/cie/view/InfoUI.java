package org.cie.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoUI extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CarInfoApp");

        try {
            FXMLLoader loader = new FXMLLoader();
            //加载窗口

            BorderPane rootLayout = new BorderPane();
            Scene scene = new Scene(rootLayout,750,1170);
            primaryStage.setScene(scene);
            primaryStage.show();

            //加载登录页面
            loader.setLocation(LoginUI.class.getResource("/root.fxml"));
            AnchorPane anchorPane = loader.load();
            rootLayout.setCenter(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
