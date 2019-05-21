package dm3;

import java.text.ParseException;
import java.util.Scanner;

public class InterfaceUI {

	private TerminalFournisseur TerminalFournisseur = new TerminalFournisseur();
	private TerminalOperateur TerminalOperateur =new TerminalOperateur();
	private TerminalGerant TerminalGerant =new TerminalGerant();

	public InterfaceUI() {
		super();

		Horloge horloge = new Horloge();
		try {
			horloge.setTimeTask();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Fournisseur testFournisseur = new Fournisseur("test", "test", "test", "test", "test", 123456789, ControleurBD.getListServiceOffert());
		ControleurBD.ajouterFournisseur(testFournisseur);

		Membre testMembre = new Membre("test", "test", "test", "test", "test", "test", "test", 456789123, ControleurBD.getListServiceOffert());
		ControleurBD.ajouterMembre(testMembre);
		
		Membre testMembre2 = new Membre("test", "test", "test", "test", "test", "test", "test", 456789123, ControleurBD.getListServiceOffert());
		ControleurBD.ajouterMembre(testMembre2);
		
		Operateur op = new Operateur("test", 123456789);
		ControleurBD.getListOperateur().add(op);
		
		Gerant gerant = new Gerant("test", 123456789);
		ControleurBD.getListGerant().add(gerant);

		Service testService = new Service("test2", 55, 0.00, testFournisseur);
		ControleurBD.ajouterService(testService);
		Service testService2 = new Service("test1", 55, 0.00, testFournisseur);
		ControleurBD.ajouterService(testService2);
		Service testService3 = new Service("test3", 55, 0.00, testFournisseur);
		ControleurBD.ajouterService(testService3);
		
		
	}
/**
 * L'execution de la fonction principale du logiciel en ce qui concerne l'utilisateur
 * La fonction nous permet d'identifier quel type d'utilisateur utilise le logiciel,
 * quelles taches il veut effectuer, et cetera. Le terminal approprie est simule selon 
 * la reponse de l'utilisateur (voir manuel utilisateur)
 * @throws ParseException
 */
	public void demarrer() throws ParseException {

		//Horloge.setTimeTask();
		while (true) {
			System.out.println("\nChoisissez le numéro qui vous correspond:");
			System.out.println("1.Gérant");
			System.out.println("2.Opérateur");
			System.out.println("3.Fournisseur");
			System.out.println("4.Quitter");

			@SuppressWarnings("resource")
			Scanner readerMainMenu = new Scanner(System.in);
			System.out.println("\nVotre choix : ");
			String choixMainMenu = readerMainMenu.next();

			if(choixMainMenu.equals("1")) { TerminalGerant.demarrer(); }
			else if(choixMainMenu.equals("2")) { TerminalOperateur.demarrer();}
			else if(choixMainMenu.equals("3")) { TerminalFournisseur.demarrer(); }
			else if(choixMainMenu.equals("4")) { System.out.println("\nAu revoir!"); break; }
			else { System.out.println("\nVeuillez svp faire un choix valide!"); }
		}
	}

}
