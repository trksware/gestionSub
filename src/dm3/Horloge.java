package dm3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Horloge extends TimerTask {
	
	static String timeTask;

    public void run() {

        System.out.println("Task is starting");
        
        CreateurRapport.RapportSynthese();
        CreateurRapport.rapportToutMembre();
        CreateurRapport.rapportToutFournisseur();
        
        int numeroMembre = 0;
        String rapportToutMembre = "";
        for(int membre=0;membre<ControleurBD.getListMembre().size();membre++) {
        	numeroMembre=ControleurBD.getListMembre().get(membre).getNumeroCarteMembre();
        	CreateurRapport.rapportMembre(numeroMembre, true);
        }
        
        int numeroFournisseur = 0;
        String rapportToutFournisseur = "";
        for(int fournisseur=0;fournisseur<ControleurBD.getListFournisseur().size();fournisseur++) {
        	numeroFournisseur=ControleurBD.getListFournisseur().get(fournisseur).getNumeroFournisseur();
        	CreateurRapport.rapportFournisseur(numeroFournisseur, true);
        }
        

    }

    public static void setTimeTask() throws ParseException {

    	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter .parse("2020-07-28 23:09:50");
        Timer timer = new Timer();
        timer.schedule(new Horloge(), date);
    }

    	
}
