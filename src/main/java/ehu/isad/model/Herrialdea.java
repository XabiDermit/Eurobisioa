package ehu.isad.model;

public class Herrialdea {

  private String izena;
  private String bandera;
  private String tv;

  public Herrialdea(String pIzena, String pBandera, String pTv) {
    this.izena = pIzena;
    this.bandera = pBandera;
    this.tv = pTv;
  }

  @Override
  public String toString() {
    return  izena + " " + bandera +" "+  tv ;

  }

}
