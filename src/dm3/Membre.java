package dm3;

import java.util.ArrayList;

public class Membre extends Personne {
	
	private String nomMembre;
	private String prenomMembre;
	private String statutMembre;
	private int numeroCarteMembre;
	private ArrayList<ServiceOffert> listServiceRecus;
	
	public Membre(String adresse, String ville, String province, String codePost, String nomMembre, String prenomMembre,
			String statutMembre, int numeroCarteMembre, ArrayList<ServiceOffert> plistServiceRecus) {
		super(adresse, ville, province, codePost);
		this.nomMembre = nomMembre;
		this.prenomMembre = prenomMembre;
		this.statutMembre = statutMembre;
		this.numeroCarteMembre = numeroCarteMembre;
		this.listServiceRecus = plistServiceRecus;
	}
	
	public Membre(String adresse, String ville, String province, String codePost, String nomMembre, String prenomMembre,
			String statutMembre, int numeroCarteMembre) {
		super(adresse, ville, province, codePost);
		this.nomMembre = nomMembre;
		this.prenomMembre = prenomMembre;
		this.statutMembre = statutMembre;
		this.numeroCarteMembre = numeroCarteMembre;
	}
	
	public String getNomMembre() {
		return nomMembre;
	}
	
	public void ajouterServiceOffert(ServiceOffert pServiceOffert) {
		listServiceRecus.add(pServiceOffert);
	}
	
	public void setNomMembre(String nomMembre) {
		this.nomMembre = nomMembre;
	}
	public String getPrenomMembre() {
		return prenomMembre;
	}
	public void setPrenomMembre(String prenomMembre) {
		this.prenomMembre = prenomMembre;
	}
	public String getStatutMembre() {
		return statutMembre;
	}
	public void setStatutMembre(String statutMembre) {
		this.statutMembre = statutMembre;
	}
	public int getNumeroCarteMembre() {
		return numeroCarteMembre;
	}
	public void setNumeroCarteMembre(int numeroCarteMembre) {
		this.numeroCarteMembre = numeroCarteMembre;
	}

	public ArrayList<ServiceOffert> getListServiceRecus() {
		return listServiceRecus;
	}

	public void setListServiceRecus(ArrayList<ServiceOffert> listServiceRecus) {
		this.listServiceRecus = listServiceRecus;
	}
}
