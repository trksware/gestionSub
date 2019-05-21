package dm3;

import java.util.Date;

public class ServiceOffert {
	
	private String commentaire;
	private Date dateServiceOffert;
	private Date dateHeureFactureation;
	private Fournisseur fournisseur;
	private Membre membre;
	private Service service;
	
	
	public ServiceOffert(String commentaire, Date dateServiceOffert, Date dateHeureFactureation,
			Fournisseur fournisseur, Membre membre, Service service) {
		super();
		this.commentaire = commentaire;
		this.dateServiceOffert = dateServiceOffert;
		this.dateHeureFactureation = dateHeureFactureation;
		this.fournisseur = fournisseur;
		this.membre = membre;
		this.service = service;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Date getDateServiceOffert() {
		return dateServiceOffert;
	}


	public void setDateServiceOffert(Date dateServiceOffert) {
		this.dateServiceOffert = dateServiceOffert;
	}


	public Date getDateHeureFactureation() {
		return dateHeureFactureation;
	}


	public void setDateHeureFactureation(Date dateHeureFactureation) {
		this.dateHeureFactureation = dateHeureFactureation;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public Membre getMembre() {
		return membre;
	}


	public void setMembre(Membre membre) {
		this.membre = membre;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}
	

	

	

}
