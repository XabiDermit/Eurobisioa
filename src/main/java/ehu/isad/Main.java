package ehu.isad;

import ehu.isad.controller.ui.UI1Kud;
import ehu.isad.controller.ui.UI2Kud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent UI1;
  private Parent UI2;

  private Stage stage;

  private UI1Kud UI1Kud;
  private UI2Kud UI2Kud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Ezarpenak lortu");
    stage.setScene(new Scene(UI1, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderUI1 = new FXMLLoader(getClass().getResource("/UI1.fxml"));
    UI1 = (Parent) loaderUI1.load();
    UI1Kud = loaderUI1.getController();
    UI1Kud.setMainApp(this);

    FXMLLoader loaderUI2 = new FXMLLoader(getClass().getResource("/UI2.fxml"));
    UI2 = (Parent) loaderUI2.load();
    UI2Kud = loaderUI2.getController();
    UI2Kud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void herrialdeakErakutsi() {
    stage.setScene(new Scene(UI2));
    stage.show();
    UI2Kud.partaideakErakutsi();
  }
}
