package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.OrdezkaritzaDbKud;
import ehu.isad.model.Ordezkaritza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UI5Kud implements Initializable {



    @FXML
    private TableView<Ordezkaritza> taula;
    @FXML
    private TableColumn<Ordezkaritza,String> herrialdea;
    @FXML
    private TableColumn<Ordezkaritza,Integer> puntuak;
    @FXML
    private Button btnOk;
    @FXML
    private Label lblMezua;

    private Main mainApp;
    public void setMainApp(Main main) {mainApp = main;
    }

    private ObservableList<Ordezkaritza> ordezkaritzaModel= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void taulaBete(){
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));

        ordezkaritzaModel.addAll(OrdezkaritzaDbKud.getInstantzia().top3Lortu());

        taula.setItems(ordezkaritzaModel);


    }
}
