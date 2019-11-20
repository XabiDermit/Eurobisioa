package ehu.isad.controller.db;

import ehu.isad.model.Ordezkaritza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdezkaritzaDbKud {

    //singleton patroia

    private static OrdezkaritzaDbKud instantzia = new OrdezkaritzaDbKud();
    public static  OrdezkaritzaDbKud getInstantzia(){return instantzia;}

    private OrdezkaritzaDbKud(){}

    public ArrayList<Ordezkaritza> ordezkaritzakLortu(){
        ArrayList<Ordezkaritza> ordezkaritzak = new ArrayList<>();
       try{
           String statement = "select * from Ordezkaritza";
           ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(statement);
           String herrialdea;
           String artista;
           String abestia;
           int puntuak;
           while(rs.next()){
               herrialdea= rs.getString("herrialdea");
               artista = rs.getString("artista");
               abestia = rs.getString("abestia");
               puntuak = rs.getInt("puntuak");
               Ordezkaritza ordezkaritza = new Ordezkaritza(herrialdea,artista,abestia,puntuak);
               ordezkaritzak.add(ordezkaritza);
           }
       } catch (SQLException ex) {
           // handle any errors
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
       }
        return ordezkaritzak;
    }

    public ArrayList<Ordezkaritza> top3Lortu(){
        ArrayList<Ordezkaritza> ordezkaritzak = new ArrayList<>();
        try{
            String statement = "select herrialdea, puntuak from Ordezkaritza where urtea= strftime('%Y', 'now') order by puntuak desc limit 3";
            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(statement);
            String herrialdea;
            String artista;
            String abestia;
            int puntuak;
            while(rs.next()){
                herrialdea= rs.getString("herrialdea");

                puntuak = rs.getInt("puntuak");
                Ordezkaritza ordezkaritza = new Ordezkaritza(herrialdea,puntuak);
                ordezkaritzak.add(ordezkaritza);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ordezkaritzak;

    }

}
