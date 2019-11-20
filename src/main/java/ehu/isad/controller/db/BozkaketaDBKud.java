package ehu.isad.controller.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BozkaketaDBKud {

    //singleton patroia

    private static BozkaketaDBKud instantzia = new BozkaketaDBKud();
    public static BozkaketaDBKud getInstantzia() {return instantzia;}
    private BozkaketaDBKud(){}

    public boolean bozkatuDu(String pHerrialdea)  {
        try{

            String statement = "select * from Bozkaketa where bozkatuDu= '"+ pHerrialdea +"' and urtea= strftime('%Y', 'now');";
            ResultSet rs = null;
            rs = DBKudeatzaile.getInstantzia().execSQL(statement);
            while (rs.next()) {

               System.out.println(rs.getString("bozkatuDu"));
               return true;
            }


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return false;

    }
}
