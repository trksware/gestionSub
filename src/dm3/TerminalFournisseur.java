package dm3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalFournisseur {

	private Fournisseur fournisseurActuel;
	private Membre membreActuel;
	private Service serviceActuel;
	/**
	 * Fonction qui execute une simulation du terminal de fournisseur
	 * L'utilisateur doit s'identifier, ensuite il peut choisir entre plusieurs
	 * fonctionnalites du logiciel qui concernent le Fournisseur.
	 */
	@SuppressWarnings("resource")
	public void demarrer() {
		int tentatives = 0;
		boolean succes = false;
		int numeroFournisseur = 0;
		while (tentatives < 3 && !succes) {
			System.out.println("\nVeuillez entrer votre numéro de fournisseur\nPS: vous avez 3 tentatives et de format 9 chifres:");
			@SuppressWarnings("resource")
			Scanner readerNumeroFournisseur = new Scanner(System.in);
			
			try {
				String numeroFournisseurString = readerNumeroFournisseur.next();
				if(!numeroFournisseurString.contains("[a-zA-Z]+") && numeroFournisseurString.length() == 9) {
					numeroFournisseur = Integer.parseInt(numeroFournisseurString);
				}
			} catch (InputMismatchException e) {
				tentatives++;
				continue;
			}
			
			succes = ControleurBD.authentifierFournisseur(numeroFournisseur);
			tentatives++;
		}
		
		
		if (!succes) { System.out.println("\nAuthentification échoué!"); return;}
		fournisseurActuel = ControleurBD.getFournisseur(numeroFournisseur);	
		System.out.println("\nAuthentification réssie!");
		
		while (true) {
    		System.out.println("\nChoisissez le numéro qui vous correspond:");
			System.out.println("1.Offrir un service");
			System.out.println("2.Consulter le répertoir des fournisseurs");
			System.out.println("3.Retour");
			
			Scanner readerMenuFournisseur = new Scanner(System.in);
			System.out.println("\nVotre choix :");
			int choixMenuFournisseur = readerMenuFournisseur.nextInt();
			
			if(choixMenuFournisseur == 1) { offrirService(numeroFournisseur); }
			else if(choixMenuFournisseur == 2) { dispRapportFournisseur(); }
			else if(choixMenuFournisseur == 3) { return; }
			else { System.out.println("\nVeuillez svp faire un choix valide!"); }
		}
	}
	/**
	 * Fonction qui permet a un Fournisseur d'offrir un service a un Membre et de
	 * facturer ChocAn.
	 * Le service offert est enregistre afin de faciliter la creation de rapports.
	 * On offre aussi la possibilite d'afficher le repertoire des fournisseurs.
	 * Un resume des donnees entrees est presente a la fin afin de confirmer.
	 * @param numeroFournisseur Le numero du Fournisseur qui a offert un service
	 */
	private void offrirService(int numeroFournisseur){
		
		//authentification membre
		int tentatives = 0;
		boolean succes = false; 
		int numeroMembre = 0;
		while (tentatives < 3 && !succes) {
			System.out.println("\nVeuillez entrer votre numéro de membre (vous avez 3 tentatives):");
			@SuppressWarnings("resource")
			Scanner readerNumeroMembre = new Scanner(System.in);
			try {				
				String numeroMembreString = readerNumeroMembre.next();
				if(!numeroMembreString.contains("[a-zA-Z]+") && numeroMembreString.length() == 9) {
					numeroMembre = Integer.parseInt(numeroMembreString);
				}
			} catch (InputMismatchException e) {
				tentatives++;
				continue;
			}
			succes = ControleurBD.authentifierMembre(numeroMembre);
			tentatives++;
		}
		
		if (!succes) { System.out.println("\nAuthentification échoué!"); return;}
		membreActuel = ControleurBD.getMembre(numeroMembre);
		System.out.println("\nAuthentification réssie!");
		
		
		//date
		tentatives = 0;
		succes = false; 
		Date dateP=null;////////////date
		while (tentatives < 3 && !succes) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nA quelle date le service été offert (yyyy-MM-dd)");
			String date = scanner.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
			    dateP = dateFormat.parse(date);
			    succes = true;
			    
			} catch (ParseException e) {
				tentatives++;
				continue;
			}
		}
		
		if (!succes) { System.out.println("\nVous avez fait trop d'erreurs!"); return;}
		
		
		//date
		tentatives = 0;
		succes = false; 
		Date dateFacturation=null;////////////date
		while (tentatives < 3 && !succes) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nQuelle est la date de la facturation (yyyy-MM-dd)");
			String date = scanner.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			

			try {
				dateFacturation = dateFormat.parse(date);
			    succes = true;
			    System.out.println(dateFacturation);
			} catch (ParseException e) {
				tentatives++;
				continue;
			}
		}
		
		if (!succes) { System.out.println("\nVous avez fait trop d'erreurs!"); return;}
		
		
		tentatives = 0;
		succes = false; 
		while (tentatives < 3 && !succes) {
			System.out.println("\nVoulez-vous afficher le répertoire des fournissuers? (y/n)");
			@SuppressWarnings("resource")
			Scanner readerReponse = new Scanner(System.in);
			try {
				String reponse = readerReponse.next();
				if(reponse.equals("y")) { 
					dispRapportFournisseur();
					break;
				}else {
					break;
				}
			} catch (InputMismatchException e) {
				tentatives++;
				continue;
			}
		}
		
		
		//service
		tentatives = 0;
		succes = false; 
		int numeroService = 0;
		while (tentatives < 3 && !succes) {
			System.out.println("\nVeuillez entrer votre numéro de service (vous avez 3 tentatives):");
			@SuppressWarnings("resource")
			Scanner readerNumeroService = new Scanner(System.in);
			try {
				numeroService = readerNumeroService.nextInt();
			} catch (InputMismatchException e) {
				tentatives++;
				continue;
			}
			succes = ControleurBD.verifierNumeroService(numeroService);
			tentatives++;
		}
		
		if (!succes) { System.out.println("\nVous avez fait trop d'erreurs!"); return;}
		serviceActuel = ControleurBD.getService(numeroService);
		
		
		//commentaire
		@SuppressWarnings("resource")
		Scanner scannerCommentaire = new Scanner(System.in);
		System.out.println("\nEnter un commentaire");
		String commentaire = scannerCommentaire.next();
		System.out.println(commentaire);
		


		succes = false; 
		System.out.println("\nService offert: \n");
		System.out.println("Numero de fournisseur : " + numeroFournisseur);
		System.out.println("Numero de membre : " + numeroMembre);
		System.out.println("Code de service : " + numeroService);
		System.out.println("Date du service : " + dateP);
		System.out.println("Date de facturation : " + dateFacturation);
		System.out.println("Commentaire : " + commentaire);
		System.out.println("\nVoulez-vous ajouter ce service? (y/n)");
		@SuppressWarnings("resource")
		Scanner readerReponse = new Scanner(System.in);
		try {
			String reponse = readerReponse.next();
			if(reponse.equals("y")) { 
				
				ServiceOffert serviceOffertAAjouter = new ServiceOffert(commentaire, dateP, dateFacturation,
						fournisseurActuel, membreActuel, serviceActuel);
				
				ControleurBD.ajouterServiceOffert(serviceOffertAAjouter);
				
				membreActuel.ajouterServiceOffert(serviceOffertAAjouter);
				fournisseurActuel.ajouterServiceOffert(serviceOffertAAjouter);
				return;
			}
		} catch (InputMismatchException e) {
			return;
		}
	}
	/**
	 * Fonction qui permet au Fournisseur de consulter le repertoire des fournisseurs
	 * qui contient toute l'information pertinente de tous les services offerts qui
	 * sont couverts par ChocAn. Le repertoire est affiche a l'ecran.
	 */
	private void dispRapportFournisseur() {	
		System.out.println("\n");
		int j = 0;
		
		ArrayList<Service> listeDisplay = ControleurBD.getListService();
		
		Collections.sort(listeDisplay, new Comparator<Service>() {
		    @Override
		    public int compare(Service o1, Service o2) {
		        return o1.getNomService().compareTo(o2.getNomService());
		    }
		});
		
		for (int i = 0; i < listeDisplay.size(); i++) {
			j = i + 1;
			System.out.println("Service numéro : " + j);
			System.out.println("Nom service : " + listeDisplay.get(i).getNomService());
			System.out.println("Code service : " + listeDisplay.get(i).getCodeService());
			System.out.println("Nom service : " + listeDisplay.get(i).getMontantService());
			System.out.println("-------------------------------");
		}
	}

	public Fournisseur getFournisseurActuel() {
		return fournisseurActuel;
	}

	public void setFournisseurActuel(Fournisseur fournisseurActuel) {
		this.fournisseurActuel = fournisseurActuel;
	}

	public Membre getMembreActuel() {
		return membreActuel;
	}

	public void setMembreActuel(Membre membreActuel) {
		this.membreActuel = membreActuel;
	}
	
}
