package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class UI3Kud implements Initializable {

    private Main mainApp;

    @FXML
    private Label lblMezua;
    @FXML
    private ImageView ivBandera;
    @FXML
    private Button btnOk;

    public void setMainApp(Main main){mainApp = main;}

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void onClickAtzera(ActionEvent actionEvent) {
      //mainApp.erroreLehioaItxti();
      mainApp.herrialdeakErakutsi();
    }




}
