package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.HerrialdeakDBKud;
import ehu.isad.controller.db.HerrialdeakDBKud;
import ehu.isad.model.Herrialdea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
    ArrayList<String> herrialdeIzenak = new ArrayList<>();
    for (int i = 0; i <herrialdeak.size() ; i++) {
      herrialdeIzenak.add(herrialdeak.get(i).getIzena());
    }
    cbHerrialdeak.getItems().addAll(herrialdeIzenak);
    cbHerrialdeak.getSelectionModel().selectFirst();
  }

  @FXML
  public void onClick(ActionEvent actionEvent) throws SQLException {
    String herrialdea = (String) cbHerrialdeak.getValue();
    Boolean bozkatu = BozkaketaDBKud.getInstantzia().bozkatuDu(herrialdea);
    if (bozkatu){mainApp.erroreLehioaErakutsi();}
    else{ mainApp.bozkaketakEratutsi();}
  }

  }