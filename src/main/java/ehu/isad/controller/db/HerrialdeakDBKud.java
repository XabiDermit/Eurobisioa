package ehu.isad.controller.db;

import ehu.isad.model.Herrialdea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeakDBKud {

  // singleton patroia

  private static HerrialdeakDBKud instantzia = new HerrialdeakDBKud();

  public static HerrialdeakDBKud getInstantzia(){
      return instantzia;
  };

  private HerrialdeakDBKud (){}

  public List<Herrialdea> lortuHerrialdeak(){

    List<Herrialdea> emaitza = new ArrayList<>();
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select izena, bandera, tv from Herrialde";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {

        String izena = rs.getString("izena");
        String bandera = rs.getString("bandera");
        String tv = rs.getString("tv");

        Herrialdea herrialdea= new  Herrialdea(izena, bandera, tv);
        emaitza.add(herrialdea);
      }
    }catch (SQLException e){
      System.err.println(e);
    }


    return emaitza;
  }



}
