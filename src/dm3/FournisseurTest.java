package dm3;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class FournisseurTest {

	private int longueurListServiceOffert;
	@Before
	public void setUp() throws ParseException {
		
		longueurListServiceOffert = ControleurBD.getListServiceOffert().size();
		
		Fournisseur testFournisseur = new Fournisseur("test", "test", "test", "test", "test", 123456789, ControleurBD.getListServiceOffert());
		ControleurBD.ajouterFournisseur(testFournisseur);

		Membre testMembre = new Membre("test", "test", "test", "test", "test", "test", "test", 456789123, ControleurBD.getListServiceOffert());
		ControleurBD.ajouterMembre(testMembre);
		
		Service testService = new Service("test2", 55, 0.00, testFournisseur);
		ControleurBD.ajouterService(testService);
		
		Date dateP=null;
		String date = "1988-02-02";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateP = dateFormat.parse(date);
		
		ServiceOffert serviceOffertTest = new ServiceOffert("testServiceOffFournisseur", dateP, dateP, testFournisseur, testMembre, testService);
		
		testFournisseur.ajouterServiceOffert(serviceOffertTest);
		
		
	}
	
	@Test
	public void ajouterServiceOfferFournisseurTest() {
		assertEquals(longueurListServiceOffert+1, ControleurBD.getListServiceOffert().size());
		
		
	}

}
