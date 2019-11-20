package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.OrdezkaritzaDbKud;
import ehu.isad.model.Ordezkaritza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UI4Kud implements Initializable {

    @FXML
    private TableView<Ordezkaritza> taula;
    @FXML
    private TableColumn<Ordezkaritza, String> herrialdea;
    @FXML
    private TableColumn<Ordezkaritza, String> artista;
    @FXML
    private TableColumn<Ordezkaritza, String> abestia;
    @FXML
    private TableColumn<Ordezkaritza, Integer> puntuak;

    @FXML
    private Button btnGorde;
    @FXML
    private Label lblMezua;

    private ObservableList<Ordezkaritza> ordezkaritzaModels = FXCollections.observableArrayList();



    private Main mainApp;
    public void setMainApp(Main main) {mainApp = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void taulaBete(){
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        abestia.setCellValueFactory(new PropertyValueFactory<>("Abestia"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));

        ordezkaritzaModels.addAll(OrdezkaritzaDbKud.getInstantzia().ordezkaritzakLortu());
        taula.setItems(ordezkaritzaModels);

    }
    @FXML
    public void onClickTop3(ActionEvent actionEvent) throws SQLException {

        mainApp.top3Erakutsi();

    }

}
