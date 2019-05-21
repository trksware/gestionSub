package dm3;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ControleurBDTest {
	
	private int longueurListFournisseur;

	@Before
	public void setUp() throws ParseException {
		
		longueurListFournisseur = ControleurBD.getListFournisseur().size();
		
		Fournisseur testFournisseur = new Fournisseur("test", "test", "test", "test", "test", 123456789);
		ControleurBD.ajouterFournisseur(testFournisseur);

		Membre testMembre = new Membre("test", "test", "test", "test", "test", "test", "test", 456789123);
		ControleurBD.ajouterMembre(testMembre);
		
		
		
		Fournisseur JUnitTestAjoutFournisseur = new Fournisseur("JUnitTestAjoutFournisseur", "JUnitTestAjoutFournisseur", "JUnitTestAjoutFournisseur", "JUnitTestAjoutFournisseur", "JUnitTestAjoutFournisseur", 159753456);
		ControleurBD.ajouterFournisseur(JUnitTestAjoutFournisseur);
		
		
	}
	
	@Test
	public void authentifierMembreTest() {
		
		assertTrue(ControleurBD.authentifierMembre(456789123));
	}
	
	@Test
	public void authentifierFournsisseurTest() {
		
		assertTrue(ControleurBD.authentifierFournisseur(123456789));
		
	}
	
	@Test
	public void ajouterFournisseurTest() {
		assertEquals(longueurListFournisseur+2, ControleurBD.getListFournisseur().size());
	}

}
