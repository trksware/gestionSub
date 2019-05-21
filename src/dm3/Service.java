package dm3;



public class Service {
	
	private String nomService;
	private int codeService;
	private double montantService;
	private Fournisseur serviceFournisseur;
	
	public Service(String nomService, int codeService, double montantService, Fournisseur serviceFournisseur) {
		super();
		this.nomService = nomService;
		this.codeService = codeService;
		this.montantService = montantService;
		this.serviceFournisseur = serviceFournisseur;
	}
	
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	public int getCodeService() {
		return codeService;
	}
	public void setCodeService(int codeService) {
		this.codeService = codeService;
	}
	public double getMontantService() {
		return montantService;
	}
	public void setMontantService(double montantService) {
		this.montantService = montantService;
	}
	public Fournisseur getServiceFournisseur() {
		return serviceFournisseur;
	}
	public void setServiceFournisseur(Fournisseur serviceFournisseur) {
		this.serviceFournisseur = serviceFournisseur;
	}
	
}
