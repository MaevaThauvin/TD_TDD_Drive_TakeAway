package Tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import Modele.Orange;

public class OrangeTest {
	Orange o1, o2, o3, o4, o5;
	
	@Before
	public void init() {
		try {
			o1 = new Orange(0.90, "France");
			o2 = new Orange(0.70, "Espagne");
			o3 = new Orange(0.90, "France");
			o4 = new Orange(0.93, "France");	
			o5 = new Orange(1.02, "Algérie");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test 
	public void testToString() {
		assertEquals("Prix : "+o1.getPrix()+" ; Origine : "+o1.getOrigine(), o1.toString());
	}

	
	@Test
	public void testEquals() {
		//o1 et o2 sont différentes
		assertEquals(false, o1.equals(o2));
		
		//o1 et o3 sont égales
		assertEquals(true, o1.equals(o3));
		
		
	}
	
	
//	@Test(expected = Exception.class)
//	public void testCreationOrange() {
//		//Pas de création si le prix est negatif
//		try {
//			o1 = new Orange(-1, "France");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	
}
