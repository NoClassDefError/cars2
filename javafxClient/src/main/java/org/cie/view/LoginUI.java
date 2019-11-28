package org.cie.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * javaFx的主类兼控制器
 */
public class LoginUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CarInfoApp");

        try {
            FXMLLoader loader = new FXMLLoader();
            //加载窗口

            BorderPane rootLayout = new BorderPane();
            Scene scene = new Scene(rootLayout,600,530);
            primaryStage.setScene(scene);
            primaryStage.show();

            //加载登录页面
            loader.setLocation(LoginUI.class.getResource("/loginui.fxml"));
            AnchorPane anchorPane = loader.load();
            rootLayout.setCenter(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

