package ehu.isad.model;

public class Ordezkaritza {

    private String herrialdea;
    private String artista;
    private String abestia;
    private int puntuak;

    public Ordezkaritza(String pHerrialdea, String pArtista, String pAbestia, int pPuntuak){
        this.herrialdea= pHerrialdea;
        this.artista= pArtista;
        this.abestia= pAbestia;
        this.puntuak= pPuntuak;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public int getPuntuak() {
        return puntuak;
    }
}
