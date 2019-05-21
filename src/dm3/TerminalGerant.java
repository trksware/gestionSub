package dm3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalGerant {

	private Fournisseur fournisseurActuel;
    private Membre membreActuel;
    /**
     * Fonction principale pour un gerant. Apres s'avoir correctement identifie, le Gerant
     * choisit quelle tache il veut effectuer (impression de rapports).
     */
    @SuppressWarnings("resource")
	public void demarrer(){

        int tentatives = 0;
        boolean succes = false;
        int numeroGerant = 0;
        while (tentatives < 3 && !succes) {
            System.out.println("\nVeuillez entrer votre numero de gerant\nPS: vous avez 3 tentatives et de format 9 chifres:");
            Scanner readerNumeroGerant = new Scanner(System.in);

            try {
                String numeroGerantString = readerNumeroGerant.next();
                if(!numeroGerantString.contains("[a-zA-Z]+") && numeroGerantString.length() == 9) {
                    numeroGerant = Integer.parseInt(numeroGerantString);
                }
            } catch (InputMismatchException e) {
            	tentatives++;
                continue;
            }
            succes = ControleurBD.authentifierOperateur(numeroGerant);
            tentatives++;
        }
        

        if (!succes) { System.out.println("\nAuthentification ï¿½chouï¿½!\n"); return;}
        System.out.println("\nAuthentification rï¿½ssie!\n");

        while (true) {
            System.out.println("\nChoisissez le numï¿½ro qui correspond au mode \n");
            System.out.println("1.Executer un rapport de fournisseur");
            System.out.println("2.Executer un rapport de membre");
            System.out.println("3.Executer le rapport globale des fournisseurs");
            System.out.println("4.Executer un rapport globale des membres");
            System.out.println("5.Executer un rapport de synthese");
            System.out.println("6.Retour");

            @SuppressWarnings("resource")
			Scanner readerMenuGerant = new Scanner(System.in);
            System.out.println("\nVotre choix : \n");
            int choixMenuGerant = readerMenuGerant.nextInt();

            if(choixMenuGerant== 1) {
                executerRapportFournisseur();
            }
            else if(choixMenuGerant== 2) {
            	executerRapportMembre();
            }
            else if(choixMenuGerant == 3) {
            	executerRapportGlobaleFournisseur();
            }
            else if(choixMenuGerant== 4) {
            	executerRapportGlobaleMembre();
            }
            else if(choixMenuGerant == 5) {
            	executerRapportSynthese();
            }
            else if(choixMenuGerant == 6) {
                return;
            }
            else {
                System.out.println("\nVeuillez svp faire un choix valide!\n");
            }
        }


    }
    /**
     * Execute la fonction qui cree un rapport pour un fournisseur en particulier.
     * Le Gerant est demande d'entrer un numero de fournisseur. Si le numero est valide,
     * le rapport est cree.
     */
    private void executerRapportFournisseur (){
		
		int tentatives = 0;
		boolean succes = false; 
		int numeroFournisseur = 0;
		while (tentatives < 3 && !succes) {
			System.out.println("\nVeuillez entrer le numero du fournisseur (vous avez 3 tentatives):");
			@SuppressWarnings("resource")
			Scanner readerNumeroMembre = new Scanner(System.in);
			try {				
				String numeroFournisseurString = readerNumeroMembre.next();
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
		
		CreateurRapport.rapportFournisseur(numeroFournisseur, true);
    }
    /**
     * Execute un rapport de membre pour un membre en particulier
     */
    private void executerRapportMembre (){
		
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
		
		CreateurRapport.rapportMembre(numeroMembre, true);
    }

    /**
     * Execute un rapport par fournisseur enregistre dans la base de donnees ChocAn
     */
    private void executerRapportGlobaleFournisseur(){
    	CreateurRapport.rapportToutFournisseur();
    }
/**
 * Execute un rapport de membre par membre enregistre dans la base de donnees ChocAn
 */
	private void executerRapportGlobaleMembre(){
		CreateurRapport.rapportToutMembre();
	}
    /**
     * Execute un rapport des comptes recevables de la semaine jusqu'au temps de la
     * demande
     */
    private void executerRapportSynthese(){
    	CreateurRapport.RapportSynthese();
    }
    

}
