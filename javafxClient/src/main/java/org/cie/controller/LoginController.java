package org.cie.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.cie.model.User;
import org.cie.view.InfoUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends BaseController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Text text;

    public void loginAction(ActionEvent actionEvent) {
        User user = new User(usernameField.getText(), passwordField.getText());
        String result = null;
        try {
            result = sendPostJson("login/login", user);
            if (result.equals("success")) {
                //javafx 中如何在控制器中实现界面跳转
                InfoUI infoUI = new InfoUI();
                infoUI.start(new Stage());
                Stage stage = (Stage) rootPane.getScene().getWindow();
                stage.close();
                //frame.dispose();//关闭窗口
                new InfoUI();//打开登录后的信息显示窗口
            } else {
                System.out.println("login failed");
                text.setText("Password incorrect or no such user. ");
                //JOptionPane.showMessageDialog(null, "password incorrect", "login failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HttpHostConnectException e) {
            text.setText("Connection error. ");
            e.printStackTrace();
        } catch (Exception e) {
            text.setText("View load error.");
            e.printStackTrace();
        }

    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setting(ActionEvent actionEvent) {
        try {
            Runtime run = Runtime.getRuntime();
            String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            IOUtils.copy(this.getClass().getResourceAsStream("/db.properties"),
                    new FileOutputStream(path + "\\db.properties"));
            System.out.println(path + "\\db.properties");
            run.exec(path + "\\db.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
