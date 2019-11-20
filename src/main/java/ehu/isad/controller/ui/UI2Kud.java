package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.HerrialdeakDBKud;
import ehu.isad.controller.db.HerrialdeakDBKud;
import ehu.isad.model.Herrialdea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UI2Kud implements Initializable {

  // Reference to the main application.
  private Main mainApp;


  @FXML
  private ComboBox cbHerrialdeak;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }



  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  public void partaideakErakutsi() {
    List<Herrialdea> herrialdeak = HerrialdeakDBKud.getInstantzia().lortuHerrialdeak();
    cbHerrialdeak.getItems().addAll(herrialdeak);
    cbHerrialdeak.getSelectionModel().selectFirst();
  }
}