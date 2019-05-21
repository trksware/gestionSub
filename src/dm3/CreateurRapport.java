package dm3;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CreateurRapport {
    private static Membre membreActuelle;
    private static Fournisseur fournisseurActuelle;
    private static ServiceOffert serviceRecusActuelle;
    private static ServiceOffert serviceOffertActuelle;

/**
 * Fonction qui cree un rapport de membre pour un Membre en particulier
 * On entre le numero de Membre en parametre, et le logiciel cherche toutes les donnees
 * necessaires afin de creer un rapport, qui est affiche a l'ecran
 * On accede aux services recus du membre afin de completer le rapport
 * @param numeroMembre Le numero du Membre pour lequel on veut faire un rapport
 * @param print Un boolean qui indique si on veut enregistrer le rapport ou non
 * @return Un String correspondant au rapport
 */
    public static String rapportMembre(int numeroMembre, boolean print){

        membreActuelle = ControleurBD.getMembre(numeroMembre);
        String nomMembre = membreActuelle.getNomMembre();
        String prenomMembre = membreActuelle.getPrenomMembre();
        int numeroCarteMembre = membreActuelle.getNumeroCarteMembre();
        String adresseMembre = membreActuelle.getAdresse();
        String villeMembre = membreActuelle.getVille();
        String codePostalMembre = membreActuelle.getCodePost();
        String provinceMembre =membreActuelle.getProvince();
        ArrayList<ServiceOffert> listServiceRecus = membreActuelle.getListServiceRecus();

        String rapportMembre = "  RAPPORT DU MEMBRE   "+" |"+ "\n"

                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"Nom    " +"|"+nomMembre +"|"+prenomMembre+" |"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+" Numero  " +"|"+ numeroCarteMembre+"|"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"  Adresse   " +"|"+ adresseMembre+"|"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"   Ville   " +"|"+ villeMembre+"|"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"   Province     " +"|"+ provinceMembre+"|"+"\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+" Code Postal    " +"|"+ codePostalMembre+"|"+"\n"
                +"| "+"------------------------------------"+" |"+ "\n";
        for (int serviceRecus = 0; serviceRecus < listServiceRecus.size() - 1; serviceRecus++) {
           serviceRecusActuelle = (ServiceOffert) listServiceRecus.get(serviceRecus);
           String nomService=serviceRecusActuelle.getService().getNomService();
           String nomFournisseur=serviceRecusActuelle.getFournisseur().getNomFournisseur();
           Date dateService=serviceRecusActuelle.getDateServiceOffert();
           String reste="| "+"|"+" Nom du service  " +"|"+nomService+ "|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Nom du fournisseur " +"|"+ nomFournisseur+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Date du service  " +"|"+ dateService+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n";
            rapportMembre+=reste;
        }

        if(print) {
	        BufferedWriter writer = null;
	        try {
	            //create a temporary file
	            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	            timeLog = timeLog + "_Membre_" + numeroMembre;
	            File logFile = new File(timeLog);
	
	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());
	
	            writer = new BufferedWriter(new FileWriter(logFile));
	            writer.write(rapportMembre);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
        }
        
        return rapportMembre;
    }
/**
 * Fonction qui cree un rapport de fournisseur. On entre le numero du fournisseur en particulier
 * et le logiciel cherche toutes les donnees necessaires pour la creation d'un rapport.
 * Le logiciel accede aux service offerts par le fournisseur pour rediger le rapport
 * @param numeroFournisseur Le numero du fournisseur en question
 * @param print Boolean qui indique si on veut sauvegarder le rapport
 * @return Un String correspondant au rapport
 */
    public static String rapportFournisseur(int numeroFournisseur, boolean print){

        fournisseurActuelle = ControleurBD.getFournisseur(numeroFournisseur);
        String nomFournisseur= fournisseurActuelle.getNomFournisseur();
        int numeroDuFournisseur = numeroFournisseur;
        String adresseFournisseur = fournisseurActuelle.getAdresse();
        String villeFournisseur = fournisseurActuelle.getVille();
        String codePostalFournisseur = fournisseurActuelle.getCodePost();
        String provinceFournisseur =fournisseurActuelle.getProvince();
        ArrayList<ServiceOffert> listServiceRecus =fournisseurActuelle.getListServiceOffert();

        String rapportFournisseur = "  RAPPORT DU FOURNISSEUR   "+" |"+ "\n"

                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"Nom    " +"|"+nomFournisseur+" |"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+" Numero  " +"|"+ numeroDuFournisseur+"|"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"  Adresse   " +"|"+ adresseFournisseur+"|"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"   Ville   " +"|"+ villeFournisseur +"|"+ "\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+"   Province     " +"|"+ provinceFournisseur+"|"+"\n"
                +"| "+"------------------------------------"+" |"+ "\n"
                +"| "+"|"+" Code Postal    " +"|"+ codePostalFournisseur+"|"+"\n"
                +"| "+"------------------------------------"+" |"+ "\n";
        for (int serviceOffert = 0; serviceOffert< listServiceRecus.size() - 1; serviceOffert++) {
            serviceOffertActuelle = (ServiceOffert) listServiceRecus.get(serviceOffert);
            String nomService=serviceOffertActuelle.getService().getNomService();
            String nomMembre=serviceOffertActuelle.getMembre().getNomMembre();
            int numeroMembre=serviceOffertActuelle.getMembre().getNumeroCarteMembre();
            Date dateService=serviceOffertActuelle.getDateServiceOffert();
            int codeService =serviceOffertActuelle.getService().getCodeService();
            Double montantService=serviceOffertActuelle.getService().getMontantService();
            String reste="| "+"|"+" Nom du service  " +"|"+nomService+ "|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Nom du membre " +"|"+ nomMembre+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Numero du membre" +"|"+ numeroMembre+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Date du service  " +"|"+ dateService+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Code du service  " +"|"+ codeService+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n"
                    +"| "+"|"+" Code du service  " +"|"+ montantService+"|"+"\n"
                    +"| "+"------------------------------------"+" |"+ "\n";

            rapportFournisseur+=reste;
        }

        if(print) {
	        BufferedWriter writer = null;
	        try {
	            //create a temporary file
	            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	            timeLog = timeLog + "_Fournisseur_" + numeroFournisseur;
	            File logFile = new File(timeLog);
	
	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());
	
	            writer = new BufferedWriter(new FileWriter(logFile));
	            writer.write(rapportFournisseur);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
        }
        
        return rapportFournisseur;
    }
/**
 * Une fonction qui cree tous les rapports de tous les fournisseurs qui ont offert un service
 */
    public static void rapportToutFournisseur(){
        int numeroFournisseur = 0;
        String rapportToutFournisseur = "";
        for(int fournisseur=0;fournisseur<ControleurBD.getListFournisseur().size();fournisseur++) {
        	numeroFournisseur=ControleurBD.getListFournisseur().get(fournisseur).getNumeroFournisseur();
        	rapportToutFournisseur = rapportToutFournisseur + rapportFournisseur(numeroFournisseur, false);
        	rapportToutFournisseur += "\n\n";
        }
         
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            timeLog = timeLog + "_Fournisseurs";
            File logFile = new File(timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(rapportToutFournisseur);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
        
    }
/**
 * Une fonction qui cree tous les rapports de membre pour tous les Membres qui ont
 * recu un service couvert par ChocAn
 */
    public static void rapportToutMembre(){
        int numeroMembre = 0;
        String rapportToutMembre = "";
        for(int membre=0;membre<ControleurBD.getListMembre().size();membre++) {
        	numeroMembre=ControleurBD.getListMembre().get(membre).getNumeroCarteMembre();
        	rapportToutMembre = rapportToutMembre + rapportMembre(numeroMembre, false);
        	rapportToutMembre += "\n\n";
        	System.out.println(rapportToutMembre);
        }
        
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            timeLog = timeLog + "_Membres";
            File logFile = new File(timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(rapportToutMembre);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
    /**
     * Une fonction qui redige le rapport des comptes recevables pour le gerant. Ce rapport
     * contient toute l'information concernant le montant a payer aux fournisseurs pour une 
     * semaine quelconque.
     */
    public static void RapportSynthese(){
        ArrayList<Fournisseur> listeFournisseur = ControleurBD.getListFournisseur();

        String rapportSynthese="  RAPPORT DE SYNTHESE  "+" |"+ "\n";
        if (listeFournisseur!=null){
            for(int fournisseur=0;fournisseur<listeFournisseur.size()-1;fournisseur++){
                Double total=0.0;
                fournisseurActuelle=listeFournisseur.get(fournisseur);
                ArrayList listeServiceOffert=fournisseurActuelle.getListServiceOffert();
                if(listeServiceOffert!=null){
                    for(int serviceOffert=0;serviceOffert<listeServiceOffert.size()-1;serviceOffert++){
                    total+=fournisseurActuelle.getListServiceOffert().get(serviceOffert).getService().getMontantService();
                    }
                }
                String nomFournisseur=fournisseurActuelle.getNomFournisseur();
                String payeParFournisseur= "| "+"------------------------------------"+" |"+ "\n"
                                        +"| "+"|"+"Nom    " +"|"+nomFournisseur+" |"+ "\n"
                                        +"| "+"------------------------------------"+" |"+ "\n"
                                        +"| "+"|"+"montant:" +"|"+nomFournisseur+" |"+ "\n"
                                        +"| "+"------------------------------------"+" |"+ "\n";
                rapportSynthese+=payeParFournisseur;



            }

            BufferedWriter writer = null;
            try {
                //create a temporary file
                String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                timeLog = timeLog + "_RapportSynthese";
                File logFile = new File(timeLog);

                // This will output the full path where the file will be written to...
                System.out.println(logFile.getCanonicalPath());

                writer = new BufferedWriter(new FileWriter(logFile));
                writer.write(rapportSynthese);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close the writer regardless of what happens...
                    writer.close();
                } catch (Exception e) {
                }
            }

        }
        else{
            System.out.println("Aucun Compte n'est payable");
        }
    }
}


