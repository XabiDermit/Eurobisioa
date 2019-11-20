package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent UI1;
  private Parent UI2;
  private Parent UI3;
  private Parent UI4;
  private Parent UI5;


  private Stage stage;

  private UI1Kud UI1Kud;
  private UI2Kud UI2Kud;
  private UI3Kud UI3Kud;
  private UI4Kud UI4Kud;
  private UI5Kud UI5Kud;

  private Scene UI1Scene;
  private Scene UI2Scene;
  private Scene UI3Scene;
  private Scene UI4Scene;
  private Scene UI5Scene;



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

    FXMLLoader loaderUI3 = new FXMLLoader(getClass().getResource("/UI3.fxml"));
    UI3 = (Parent) loaderUI3.load();
    UI3Kud = loaderUI3.getController();
    UI3Kud.setMainApp(this);

    FXMLLoader loaderUI4 = new FXMLLoader(getClass().getResource("/UI4.fxml"));
    UI4 = (Parent) loaderUI4.load();
    UI4Kud = loaderUI4.getController();
    UI4Kud.setMainApp(this);

    FXMLLoader loaderUI5 = new FXMLLoader(getClass().getResource("/UI5.fxml"));
    UI5 = (Parent) loaderUI5.load();
    UI5Kud = loaderUI5.getController();
    UI5Kud.setMainApp(this);



  }


  public static void main(String[] args) {
    launch(args);
  }

  public void herrialdeakErakutsi() {
      if(UI2Scene==null){
          UI2Scene =new Scene(UI2);
      }
        stage.setScene(UI2Scene);
        stage.show();
        UI2Kud.partaideakErakutsi();
  }

  public void erroreLehioaErakutsi(){
      if(UI3Scene==null){
          UI3Scene = new Scene(UI3);
      }
      stage.setScene(UI3Scene);
      stage.show();
  }

  public void erroreLehioaItxti(){
      stage.close();
  }

  public void bozkaketakEratutsi(){
    if(UI4Scene==null){
      UI4Scene = new Scene(UI4);
    }
    stage.setScene(UI4Scene);
    stage.show();
    UI4Kud.taulaBete();
  }
}
