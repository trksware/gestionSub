package dm3;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TerminalOperateur {

    private Fournisseur fournisseurActuel;
    private Membre membreActuel;
    private Service serviceActuel;
    /**
     * Fonction principale qui permet a un Operateur d'utiliser les fonctionnalites
     * de ChocAn. Il peut ajouter/supprimer/modifier des Membres/Fournisseurs/Service apres
     * s'avoir identifie.
     */
    @SuppressWarnings("resource")
	public void demarrer(){

        int tentatives = 0;
        boolean succes = false;
        int numeroOperateur = 0;
        while (tentatives < 3 && !succes) {
            System.out.println("\nVeuillez entrer votre numero d'operateur\nPS: vous avez 3 tentatives et de format 9 chifres:");
            @SuppressWarnings("resource")
			Scanner readerNumeroOperateur = new Scanner(System.in);

            try {
                String numeroOperateurString = readerNumeroOperateur.next();
                if(!numeroOperateurString.contains("[a-zA-Z]+") && numeroOperateurString.length() == 9) {
                    numeroOperateur = Integer.parseInt(numeroOperateurString);
                }
            } catch (InputMismatchException e) {
            	tentatives++;
                continue;
            }
            succes = ControleurBD.authentifierOperateur(numeroOperateur);
            tentatives++;
        }
        

        if (!succes) { System.out.println("\nAuthentification echoue!\n"); return;}
        System.out.println("\nAuthentification ressie!\n");

        while (true) {
            System.out.println("\nChoisissez une option \n");
            System.out.println("1.Ajouter ");
            System.out.println("2.Suprimer ");
            System.out.println("3.Mettre a jour");
            System.out.println("4.Retour");

            @SuppressWarnings("resource")
			Scanner readerMenuOperateur = new Scanner(System.in);
            System.out.println("\nVotre choix : \n");
            int choixMenuOperateur = readerMenuOperateur.nextInt();

            if(choixMenuOperateur== 1) {
                ajouter();
            }
            else if(choixMenuOperateur== 2) {
                supprimer();
            }
            else if(choixMenuOperateur == 3) {
                modifier();
            }
            else if(choixMenuOperateur == 4) {
                return;
            }
            else {
                System.out.println("\nVeuillez svp faire un choix valide!\n");
            }
        }
    }
/**
 * Fonction permettant a un Operateur d'ajouter un Membre/Fournisseur/Service.
 * Les champs appropries a remplir seront presente a l'ecran, l'Operateur n'a qu'a
 * suivre les directives. Les ajouts sont enregistres dans la base de donnees.
 */
    public void ajouter() {
        while (true) {
            System.out.println("\nQuel profil d'utilisateur desirer vous ajouter\n");
            System.out.println("1.Fournisseur");
            System.out.println("2.Membre");
            System.out.println("3.Service");
            System.out.println("4.Retour");

            @SuppressWarnings("resource")
			Scanner readerMenuOperateur = new Scanner(System.in);
            System.out.println("\nVotre choix : \n");
            int choixMenuOperateur = readerMenuOperateur.nextInt();

            if (choixMenuOperateur == 1) {
                String fournisseurAttribute[] = {"l'adresse", "la ville", "le nom", " la province", "le codePostal"};

                for (int attribute = 0; attribute < fournisseurAttribute.length; attribute++) {
                    System.out.println("Veuillez entrez" + fournisseurAttribute[attribute] + " du fournisseur");
                    @SuppressWarnings("resource")
					Scanner readFournisseurAttribute = new Scanner(System.in);
                    fournisseurAttribute[attribute] = readFournisseurAttribute.nextLine();
                }

                int position = ControleurBD.getListFournisseur().size();
                ControleurBD.getListFournisseur().add(new Fournisseur(fournisseurAttribute[0],fournisseurAttribute[1], fournisseurAttribute[2], fournisseurAttribute[3], fournisseurAttribute[4], 100000+position));
                System.out.println("le fournisseur a ete ajoute");
            }

            else if (choixMenuOperateur == 2) {

                String membreAttribute[] = {"le nom","prenom", "l'adresse", "la ville", " la province", "le codePostal","le actif ou inactif"};

                for (int attribute = 0; attribute < membreAttribute.length; attribute++) {
                    System.out.println("Veuillez entrez" + membreAttribute[attribute] + " du membre");
                    @SuppressWarnings("resource")
					Scanner readMembreAttribute = new Scanner(System.in);
                    membreAttribute[attribute] = readMembreAttribute.nextLine();
                    ControleurBD.getListMembre();
                }

                int position = ControleurBD.getListMembre().size();
                ControleurBD.getListMembre().add(new Membre(membreAttribute[0],membreAttribute[1],membreAttribute[2],membreAttribute[3],membreAttribute[4],membreAttribute[5],membreAttribute[6],200000+position));
                System.out.println("le membre a ajouter ");
            }

            else if (choixMenuOperateur == 3) {
                String serviceAttribute[] = {"le nom","le code", "le montant"};

                for (int attribute = 0; attribute < serviceAttribute.length; attribute++) {
                    System.out.println("Veuillez entrez " + serviceAttribute[attribute] + " du service");
                    @SuppressWarnings("resource")
					Scanner readMembreAttribute = new Scanner(System.in);
                    serviceAttribute[attribute] = readMembreAttribute.nextLine();
                    ControleurBD.getListService();
                }

                
                System.out.println("Veuillez entrez numero du fournisseur");
                @SuppressWarnings("resource")
				Scanner readNumeroFournisseur = new Scanner(System.in);
                int numeroFournisseur = readNumeroFournisseur.nextInt();


                if (ControleurBD.authentifierFournisseur(numeroFournisseur)==true){
                    fournisseurActuel= ControleurBD.getFournisseur(numeroFournisseur);
                    System.out.println("Veuillez entrez le prix du service");
                    Scanner readMontantService = new Scanner(System.in);
                    int montantService = readNumeroFournisseur.nextInt();

                    int position = ControleurBD.getListService().size();
                    ControleurBD.getListService().add(new Service(serviceAttribute[0],300000+position,montantService,fournisseurActuel));
                    System.out.println("le service a ete ajouter ");
                } else {
                	System.out.println("Ce fournisseur n'existe pas!");
                }


            }

            else if (choixMenuOperateur == 4) {
                return;
            }

            else {
                System.out.println("\nVeuillez svp faire un choix valide!\n");
            }

        }

    }

/**
 * Fonction permettant a un Operateur de supprimer un Membre/Fournisseur/Service de la
 * base de donnees ChocAn. L'existence de l'enregistrement est confirmee par le logiciel
 * avant de passer a la suppression.
 */
    public void supprimer(){


        while(true){
            System.out.println("\nQuel profil d'utilisateur desirez-vous supprimer\n");
            System.out.println("1.Fournisseur");
            System.out.println("2.Membre");
            System.out.println("3.Service");
            System.out.println("4.Retour");

            Scanner readerMenuOperateur = new Scanner(System.in);
            System.out.println("\nVotre choix : \n");
            int choixMenuOperateur = readerMenuOperateur.nextInt();

            if (choixMenuOperateur == 1) {
                System.out.println("Veuillez entrer le numero de fournisseur que vous desirez supprimer");
                @SuppressWarnings("resource")
				Scanner scanNumero =new Scanner(System.in);
                int numeroFournisseur = scanNumero.nextInt();

                if (ControleurBD.authentifierFournisseur(numeroFournisseur)== true){
                    ControleurBD.supprimerFournisseur(ControleurBD.getFournisseur(numeroFournisseur));
                    System.out.println("le fournisseur à ete supprimer ");
                }

                else{
                    System.out.println("le fournisseur que vous tenter de supprimer n'existe pas");
                    return;
                }

            }

            else if (choixMenuOperateur == 2) {
                System.out.println("Veuillez entrer le numero de membre que vous desirez supprimer");
                Scanner scanNumero =new Scanner(System.in);
                int numeroMembre = scanNumero.nextInt();
                if (ControleurBD.authentifierMembre(numeroMembre)== true){

                    ControleurBD.supprimerMembre(ControleurBD.getMembre(numeroMembre));
                    System.out.println("le membre e ete supprimer ");

                }

                else{
                    System.out.println("le membre que vous tenter de supprimer n'existe pas");
                    return;
                }


            }


            else if (choixMenuOperateur == 3) {
                System.out.println("Veuillez entrer le numero de service que vous desirez supprimer");
                Scanner scanNumero =new Scanner(System.in);
                int numeroService = scanNumero.nextInt();
                if (ControleurBD.verifierNumeroService(numeroService)== true){

                    ControleurBD.supprimerService(ControleurBD.getService(numeroService));
                    System.out.println("le service a ete supprimer ");

                }

                else{
                    System.out.println("le membre que vous tenter de supprimer n'existe pas");
                    return;
                }

            }

            else if (choixMenuOperateur == 4) {
                return;
            }


            else {
                System.out.println("\nVeuillez svp faire un choix valide!\n");
            }

        }
    }
/**
 * Permet a un Operateur de modifier un Membre/Fournisseur/Service. L'existence de 
 * l'enregistrement que l'Operateur desire modifier est confirmee avant de proceder.
 * Dependemment de ce que l'Operateur veut modifier, le logiciel affiche les champs
 * que l"Operateur doit ajuster en ordre.
 */
    public void modifier(){

        while(true) {
            System.out.println("\nQue desirez-vous modifier\n");
            System.out.println("1.Fournisseur");
            System.out.println("2.Membre");
            System.out.println("3.Service");
            System.out.println("4.Retour");


            Scanner readerMenuOperateur = new Scanner(System.in);
            System.out.println("\nVotre choix : \n");
            int choixMenuOperateur = readerMenuOperateur.nextInt();

            if (choixMenuOperateur == 1) {
                System.out.println("Veuillez entrer le numero de fournisseur que vous desirez modifier");
                Scanner scanNumeroFournisseur = new Scanner(System.in);
                int numeroFournisseur = scanNumeroFournisseur.nextInt();

                if (ControleurBD.authentifierFournisseur(numeroFournisseur) == true) {
                    System.out.println("\nQue desirez-vous modifier chez le fournisseur\n");
                    System.out.println("1.l'adresse");
                    System.out.println("2.La ville");
                    System.out.println("3.la province");
                    System.out.println("4.le code postal");
                    System.out.println("5.Retour");
                    Scanner scanNumeroChoix = new Scanner(System.in);
                    int numeroChoix = scanNumeroChoix.nextInt();
                    if (numeroChoix == 1) {
                        System.out.println("\nVeuillez entrer l'adresse du fournisseur\n");
                        Scanner scanAdress = new Scanner(System.in);
                        String adresse = scanAdress.nextLine();
                        fournisseurActuel = ControleurBD.getFournisseur(numeroFournisseur);
                        fournisseurActuel.setAdresse(adresse);
                    }
                    else if (numeroChoix == 2) {
                        System.out.println("\nVeuillez entrer la ville du fournisseur\n");
                        Scanner scanVille = new Scanner(System.in);
                        String ville = scanVille.nextLine();
                        fournisseurActuel = ControleurBD.getFournisseur(numeroFournisseur);
                        fournisseurActuel.setAdresse(ville);
                    }
                    else if (numeroChoix == 3) {
                        System.out.println("\nVeuillez entrer la province du fournisseur\n");
                        Scanner scanProvince = new Scanner(System.in);
                        String province = scanProvince.nextLine();
                        fournisseurActuel = ControleurBD.getFournisseur(numeroFournisseur);
                        fournisseurActuel.setAdresse(province);
                    }
                    else if (numeroChoix == 5) {
                        return;

                    }
                    else if (numeroChoix == 4) {
                        System.out.println("\nVeuillez entrer le code postal du fournisseur\n");
                        Scanner scanCodePostal = new Scanner(System.in);
                        String codePostal = scanCodePostal.nextLine();
                        fournisseurActuel = ControleurBD.getFournisseur(numeroFournisseur);
                        fournisseurActuel.setAdresse(codePostal);
                    }
                    else if (numeroChoix == 5) {
                        return;

                    }
                }
                else{
                    System.out.println("le fournisseur que vous tentez de modifier n'existe pas");
                }

//String adresse, String ville, String province, String codePost, String nomFournisseur,int numeroFournisseur)

            }

            else if (choixMenuOperateur == 2){

                System.out.println("Veuillez entrer le numero de membre que vous desirez modifier");
                Scanner scanNumeroMembre = new Scanner(System.in);
                int numeroMembre = scanNumeroMembre.nextInt();

                if (ControleurBD.authentifierFournisseur(numeroMembre) == true) {
                    System.out.println("\nQue desirez-vous modifier chez le membre\n");
                    System.out.println("1.'adresse");
                    System.out.println("2.La ville");
                    System.out.println("3.la province");
                    System.out.println("4.le code postal");
                    System.out.println("5.le statut");
                    System.out.println("6.Retour");
                    Scanner scanNumeroChoix = new Scanner(System.in);
                    int numeroChoix = scanNumeroChoix.nextInt();
                    if (numeroChoix == 1) {
                        System.out.println("\nVeuillez entrer l'adresse du membre\n");
                        Scanner scanAdress = new Scanner(System.in);
                        String adresse = scanAdress.nextLine();
                        membreActuel= ControleurBD.getMembre(numeroMembre);
                        membreActuel.setAdresse(adresse);
                    }
                    else if (numeroChoix == 2) {
                        System.out.println("\nVeuillez entrer la ville du membre\n");
                        Scanner scanVille = new Scanner(System.in);
                        String ville = scanVille.nextLine();
                        membreActuel= ControleurBD.getMembre(numeroMembre);
                        membreActuel.setAdresse(ville);

                    }
                    else if (numeroChoix == 3) {
                        System.out.println("\nVeuillez entrer la province du membre\n");
                        Scanner scanProvince = new Scanner(System.in);
                        String province = scanProvince.nextLine();
                        membreActuel= ControleurBD.getMembre(numeroMembre);
                        membreActuel.setAdresse(province);;
                    }
                    else if (numeroChoix == 4) {
                        System.out.println("\nVeuillez entrer le code postal du membre\n");
                        Scanner scanCodePostal = new Scanner(System.in);
                        String codePostal = scanCodePostal.nextLine();
                        membreActuel= ControleurBD.getMembre(numeroMembre);
                        membreActuel.setAdresse(codePostal);

                    }
                    else if (numeroChoix == 5) {
                        System.out.println("\nVeuillez entrer le statut du membre\n");
                        Scanner scanCodePostal = new Scanner(System.in);
                        String statut = scanCodePostal.nextLine();
                        membreActuel= ControleurBD.getMembre(numeroMembre);
                        membreActuel.setStatutMembre(statut);
                    }

                    else if(numeroChoix == 6){
                        return;
                    }
                }
            }
            else if (choixMenuOperateur == 3){

                System.out.println("Veuillez entrer le code du service que vous desirez modifier");
                Scanner scanNumeroService = new Scanner(System.in);
                int numeroService = scanNumeroService.nextInt();

                if (ControleurBD.verifierNumeroService(numeroService)== true) {
                    System.out.println("\nQue desirez-vous modifier du Service\n");
                    System.out.println("1.'le nom");
                    System.out.println("2.le code du Service");
                    System.out.println("3.le montant du Service");
                    System.out.println("4.le fournisseur");
                    System.out.println("5.Retour");
                    Scanner scanNumeroChoix = new Scanner(System.in);
                    int numeroChoix = scanNumeroChoix.nextInt();
                    if (numeroChoix == 1) {
                        System.out.println("\nVeuillez entrer le nom du Service\n");
                        Scanner scanNomService = new Scanner(System.in);
                        String nomService= scanNomService.nextLine();
                        serviceActuel= ControleurBD.getService(numeroService);
                        serviceActuel.setNomService(nomService);
                    }
                    else if (numeroChoix == 2) {
                        System.out.println("\nVeuillez entrer le code du Service\n");
                        Scanner scanCodeService = new Scanner(System.in);
                        int codeService = scanCodeService.nextInt();
                        serviceActuel = ControleurBD.getService(numeroService);
                        serviceActuel.setCodeService(codeService);

                    }
                    else if (numeroChoix == 3) {
                        System.out.println("\nVeuillez entrer le montant du Service\n");
                        Scanner scanMontantService = new Scanner(System.in);
                        int  montantService = scanMontantService.nextInt();
                        serviceActuel = ControleurBD.getService(numeroService);
                        serviceActuel.setMontantService(montantService);
                    }
                    else if (numeroChoix == 4) {
                        System.out.println("\nVeuillez entrer le numero du fournisseur\n");
                        Scanner scanNumeroFournisseur = new Scanner(System.in);
                        int numeroFournisseur = scanNumeroFournisseur.nextInt();
                        serviceActuel = ControleurBD.getService(numeroService);
                        serviceActuel.setServiceFournisseur(ControleurBD.getFournisseur(numeroFournisseur));

                    }
                    else if (numeroChoix == 4) {
                        return;
                    }

                }


            }

            else if (choixMenuOperateur == 4){
                return;
            }

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

	public Service getServiceActuel() {
		return serviceActuel;
	}

	public void setServiceActuel(Service serviceActuel) {
		this.serviceActuel = serviceActuel;
	}

}

