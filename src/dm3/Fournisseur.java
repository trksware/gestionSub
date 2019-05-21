package dm3;

import java.util.ArrayList;

public class Fournisseur extends Personne {

	private String nomFournisseur;
	private int numeroFournisseur;
	private ArrayList<ServiceOffert> listServiceOffert;

	public ArrayList<ServiceOffert> getListServiceOffert() {
		return listServiceOffert;
	}

	public void setListServiceOffert(ArrayList<ServiceOffert> listServiceOffert) {
		this.listServiceOffert = listServiceOffert;
	}

	public Fournisseur(String adresse, String ville, String province, String codePost, String nomFournisseur,
				   int numeroFournisseur) {
		super(adresse, ville, province, codePost);
		this.nomFournisseur = nomFournisseur;
		this.numeroFournisseur = numeroFournisseur;
	}

	
	public Fournisseur(String adresse, String ville, String province, String codePost, String nomFournisseur,
					   int numeroFournisseur,ArrayList<ServiceOffert> plistServiceOffert) {
		super(adresse, ville, province, codePost);
		this.nomFournisseur = nomFournisseur;
		this.numeroFournisseur = numeroFournisseur;
		this.listServiceOffert = plistServiceOffert;
	}

	public void ajouterServiceOffert(ServiceOffert pServiceOffert) {
		listServiceOffert.add(pServiceOffert);
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public int getNumeroFournisseur() {
		return numeroFournisseur;
	}
	public void setNumeroFournisseur(int numeroFournisseur) {
		this.numeroFournisseur = numeroFournisseur;
	}
}

