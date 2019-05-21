package dm3;

public class Operateur {

    private String nomOperateur;
    private int numeroOperateur;

    public Operateur(String nomOperateur, int numeroOperateur){
        this.nomOperateur = nomOperateur;
        this.numeroOperateur=numeroOperateur;

    }

    public String getNomOperateur() {
        return nomOperateur;
    }
    public void setNomOperateur(String pnomFournisseur) {
        this.nomOperateur = pnomFournisseur;
    }
    public int getNumeroFournisseur() {
        return numeroOperateur;
    }
    public void setNumeroFournisseur(int numeroFournisseur) {
        this.numeroOperateur= numeroFournisseur;
    }


}
