package dm3;

import java.util.ArrayList;

public class ControleurBD {

	private static ArrayList<Gerant> listGerant = new ArrayList<Gerant>();
	private static ArrayList<Operateur> listOperateur = new ArrayList<Operateur>();
	private static ArrayList<Fournisseur> listFournisseur = new ArrayList<Fournisseur>();
	private static ArrayList<Membre> listMembre = new ArrayList<Membre>();
	private static ArrayList<Service> listService = new ArrayList<Service>();
	private static ArrayList<ServiceOffert> listServiceOffert = new ArrayList<ServiceOffert>();

	public static ArrayList<Operateur> getListOperateur() {
		return listOperateur;
	}

	public static ArrayList<Gerant> getListGerant() {
		return listGerant;
	}

	public static ArrayList<Fournisseur> getListFournisseur() {
		return listFournisseur;
	}
	public static ArrayList<Membre> getListMembre() {
		return listMembre;
	}


	public static ArrayList<Service> getListService() {
		return listService;
	}

	public static void setListService(ArrayList<Service> plistService) {
		listService = plistService;
	}

	public static void ajouterFournisseur(Fournisseur pFournisseur) {
		listFournisseur.add(pFournisseur);
	}

	public static void supprimerFournisseur(Fournisseur pFournisseur) {
		listFournisseur.remove(pFournisseur);
	}

	public static void ajouterMembre(Membre pMembre) {
		listMembre.add(pMembre);
	}

	public static void supprimerMembre(Membre pMembre) {
		listMembre.remove(pMembre);
	}


	public static void ajouterService(Service pService) {
		listService.add(pService);
	}

	public static void supprimerService(Service pService) {
		listService.remove(pService);
	}

	public static void ajouterServiceOffert(ServiceOffert pServiceOffert) {
		listServiceOffert.add(pServiceOffert);
	}

	public static void supprimerServiceOffert(ServiceOffert pServiceOffert) {
		listServiceOffert.remove(pServiceOffert);
	}

	/**
	 * Fonction qui permet de rechercher et retourner un Operateur en particulier
	 * @param numeroOperateur Le numero de l'Operateur en question (9 chiffres)
	 * @return L'Operateur recherche
	 */
	public static Operateur getOperateur(int numeroOperateur) {
		for (int i = 0; i < listFournisseur.size(); i++) {
			if(listOperateur.get(i).getNumeroFournisseur() == numeroOperateur) {
				return listOperateur.get(i);
			}
		}
		return null;
	}


	/**
	 * Fonction qui verifie si un numero pris en parametre correspond a
	 * un operateur dans la base de donnes de ChocAn
	 * @param numeroOperateur Le numero de l'Operateur qui essaye de s'identifier
	 * @return Un boolean qui permet de savoir si le numero entre correspond a un Operateur
	 */
	public static boolean authentifierOperateur(int numeroOperateur) {
		boolean success = false;
		for (int i = 0; i < listOperateur.size(); i++) {
			if(listOperateur.get(i).getNumeroFournisseur() == numeroOperateur) {
				success = true;
			}
		}
		return success;
	}



/**
 * Fonction qui permet de rechercher et retourner un Fournisseur de la base de donnees
 * @param numeroFournisseur Le numero du fournisseur recherche
 * @return Le Fournisseur qui correspond au numero entre
 */
	public static Fournisseur getFournisseur(int numeroFournisseur) {
		for (int i = 0; i < listFournisseur.size(); i++) {
			if(listFournisseur.get(i).getNumeroFournisseur() == numeroFournisseur) {
				return listFournisseur.get(i);
			}
		}
		return null;
	}
/**
 * Permet de verifier si un numero entre en parametre correspond a un Fournisseur
 * de la base de donnees ChocAn
 * @param numeroFournisseur Le numero du fournisseur qu'on veut verifier
 * @return Vrai ou faux, dependemment de si le Fournisseur est enregistre
 */
	public static boolean authentifierFournisseur(int numeroFournisseur) {
		boolean success = false;
		for (int i = 0; i < listFournisseur.size(); i++) {
			if(listFournisseur.get(i).getNumeroFournisseur() == numeroFournisseur) {
				success = true;
			}
		}
		return success;
	}


/**
 * Fonction qui retourne un Membre correspondant a un numero entre en parametre
 * @param numeroMembre Le numero du Membre recherche
 * @return Le Membre correspondant au numero entre en parametre
 */
	public static Membre getMembre(int numeroMembre) {
		for (int i = 0; i < listMembre.size(); i++) {
			if(listMembre.get(i).getNumeroCarteMembre() == numeroMembre) {
				return listMembre.get(i);
			}
		}
		return null;
	}
/**
 * Permet de verifier si un Membre est dans la base de donnees ChocAn en verifiant son numero
 * @param numeroMembre Le numero du membre qu'on verifie
 * @return Vrai ou faux dependemment de si le membre est dans la base de donnees
 */
	public static boolean authentifierMembre(int numeroMembre) {
		boolean success = false;
		for (int i = 0; i < listMembre.size(); i++) {
			if(listMembre.get(i).getNumeroCarteMembre() == numeroMembre) {
				success = true;
			}
		}
		return success;
	}
/**
 * Permet d'acceder a un service en entrant son numero de service en parametre
 * @param numeroService Le numero du service qu'on cherche
 * @return Le Service qui correspond au numero
 */
	public static Service getService(int numeroService) {
		for (int i = 0; i < listService.size(); i++) {
			if(listService.get(i).getCodeService() == numeroService) {
				return listService.get(i);
			}
		}
		return null;
	}
/**
 * Permet de verifier si un numero entre en parametre correspond a un service 
 * enregistre dans la base de donnees ChocAn
 * @param numeroService Le numero du service qu'on veut verifier
 * @return Vrai ou faux, dependemment de si le service est dans la base de donnees
 */
	public static boolean verifierNumeroService(int numeroService) {
		boolean success = false;
		for (int i = 0; i < listService.size(); i++) {
			if(listService.get(i).getCodeService() == numeroService) {
				success = true;
			}
		}
		return success;
	}

	public static ArrayList<ServiceOffert> getListServiceOffert() {
		return listServiceOffert;
	}

	public static void setListServiceOffert(ArrayList<ServiceOffert> listServiceOffert) {
		ControleurBD.listServiceOffert = listServiceOffert;
	}
}
