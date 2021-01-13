package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modele.Orange;
import Modele.Panier;

public class PanierTest {

	Panier p, p2, p3;
	Orange o1, o2, o3, o4, o5;
	
	@Before
	public void init() {
		ArrayList<Orange> listOranges = new ArrayList<Orange>();	
		ArrayList<Orange> listOranges2 = new ArrayList<Orange>();	
		p = new Panier(listOranges, 4);
		p2 = new Panier(listOranges, 4); 
		p3 = new Panier(listOranges2, 4); 
		try {
			o1 = new Orange(0.90, "France");
			o2 = new Orange(0.70, "Espagne");
			o3 = new Orange(0.50, "Espagne");
			o4 = new Orange(0.93, "France");	
			o5 = new Orange(1.02, "Algérie");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEstVide() {
		assertEquals(true, p.estVide());
	}
	
	@Test
	public void testEstPlein() {
			p.ajoute(o1);
			p.ajoute(o2);
			p.ajoute(o3);
			p.ajoute(o4);			
			assertEquals(true, p.estPlein());		
	}
	
	@Test
	public void testEquals() {
		//Si p et p2 sont vide
		assertEquals(true, p.equals(p2));
		
		//si p et p2 sont identiques			
			p.ajoute(o1);
			p.ajoute(o2);
			p.ajoute(o3);
			p.ajoute(o4);
			
			p2.ajoute(o1);
			p2.ajoute(o2);
			p2.ajoute(o3);
			p2.ajoute(o4);		
			
			assertEquals(true, p.equals(p2));	
		
		//si les oranges de p et p2 sont identiques mais rangé dans un autre ordre				
			p2.viderPanier();
			p2.ajoute(o3);
			p2.ajoute(o4);
			p2.ajoute(o1);
			p2.ajoute(o2);
						
			assertEquals(true, p.equals(p2));
		
		//si les oranges de p et p3 sont différentes			
			p3.ajoute(o1);
			p3.ajoute(o2);
			p3.ajoute(o3);
			p3.ajoute(o5);			
			assertEquals(false, p.equals(p3));		
	} 
	
	@Test
	public void testRetire() {
		p.ajoute(o1);
		p.ajoute(o2);
		//on retire la dernière orange ajoutée à p
		p.retire();
		
		p2.ajoute(o1);		
		assertEquals(p2.toString(), p.toString());
	}
	
	@Test
	public void testBoycottOrigine() {
		p.ajoute(o1);
		p.ajoute(o2);
		p.ajoute(o3);
		p.ajoute(o4);
		p.boycottOrigine("Espagne");
		
		p2.ajoute(o1);
		p2.ajoute(o4);
		
		assertEquals(p2.toString(), p.toString());
	}
	
	@Test
	public void testPrix() {
		p.ajoute(o1);
		p.ajoute(o2);
		p.ajoute(o3);
		p.ajoute(o4);
		assertEquals(3,03d , p.getPrix());
	} 

}
