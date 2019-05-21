package dm3;
//Classe abstraite qui sert a permettre aux classes de Fournisseur et Membre de partager 
//plusieurs attributs, comme leur adresse, nom, et cetera.
public abstract class Personne {
	
	private String adresse;
	private String ville;
	private String province;
	private String codePost;
	
	public Personne(String adresse, String ville, String province, String codePost) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.codePost = codePost;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCodePost() {
		return codePost;
	}
	public void setCodePost(String codePost) {
		this.codePost = codePost;
	}
}
