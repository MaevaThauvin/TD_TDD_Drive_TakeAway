package Modele;
 

import java.util.ArrayList;


public class Panier {
	private ArrayList<Orange> ListOrange;
	private int size; // capacité maximum
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Orange> listOranges = new ArrayList<Orange>();
		
		Panier p = new Panier(listOranges, 4);

		System.out.println("le panier de taille : "+p.size+" a été crée");
		
		System.out.println("Le panier est il vide ?");
		System.out.println(p.estVide());

		try {
			Orange o1 = new Orange(0.90, "France");
			Orange o2 = new Orange(0.70, "Espagne");
			Orange o3 = new Orange(0.50, "Espagne");
			Orange o4 = new Orange(0.93, "France");		
			
			System.out.println("Les 4 orange ont été crée"); 
			System.out.println(o1.toString());
			System.out.println(o2.toString());
			System.out.println(o3.toString());
			System.out.println(o4.toString());			
			
			System.out.println("On ajoute 2 oranges");
			p.ajoute(o1);
			p.ajoute(o2);
			System.out.println("Le panier contient : ");
			System.out.println(p.toString());
			
			System.out.println("On retire la dernière orange ajoutée qui est : "+o2.toString());
			p.retire();
			System.out.println("Le panier contient : ");
			System.out.println(p.toString());
			
			System.out.println("On rajouter une orange ");
			p.ajoute(o2);
			System.out.println("Le panier contient : ");
			System.out.println(p.toString());

			
			System.out.println("On ajoute 2 autres oranges, le panier doit être plein ");
			p.ajoute(o3);
			p.ajoute(o4);
			System.out.println("Le panier contient : ");
			System.out.println(p.toString());
			
			System.out.println("test panier vide ou non ?");
			System.out.println(p.estVide());

			System.out.println("test panier plein ou non ?");
			System.out.println(p.estPlein());
			
			Panier p2 = new Panier(listOranges, 4);
			System.out.println("Test de la methode equals, 2 panier identiques, resultat attendu true : ");
			System.out.println(p.equals(p2));
			
			System.out.println("Les oranges en provenance d'Espagne sont boycottée ");
			p.boycottOrigine("Espagne");
			System.out.println("Le panier contient : ");
			System.out.println(p.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	
	}
	
	public Panier(ArrayList<Orange> oranges,int size) {
		super();
		this.size = size;
		ListOrange=oranges;
	}
	//this.size ==> nombre do'range actuellement dans le panier
	//ta variable size ==> nombre max d'orange qu'on pourrait mettre dans le panier
	
	public boolean estPlein() {
		if (size == ListOrange.size()) {
			return true;
		}
		return false;
	}
	
	public boolean estVide() {
		if (this.ListOrange.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String s="";
		for (int i=0; i<ListOrange.size();i++) {
			s+="Element "+i+" : "+ListOrange.get(i)+" \n";
		}
		return s;
	}
	
	public boolean equals(Panier p1) {
		Boolean s=false;
		//------------- Vérifier taille des panier identiques -------// 
		if (this.ListOrange.size()==p1.ListOrange.size()) {
			//------------- Lecture des elements du panier -------// 
			for (int i =0 ; i<ListOrange.size() ; i++) {
			s=false;
				//------------- Lecture des elements du 2eme panier -------// 
				for (int j =0 ; j < p1.ListOrange.size() ; j++) {
					//------------- Test de l'égalité des elements de nos 2 paniers -------// 
					if (this.ListOrange.get(i).equals(p1.ListOrange.get(j))) {
						s=true;
						System.out.println(this.ListOrange.get(i)+";"+p1.ListOrange.get(j));
						break;
					}
						
				}
				if (!s) {
					return s;
				}
			}
		}
		if(this.estVide() && p1.estVide()) {
			s=true;
		}
		return s;
	}
	
	public void ajoute(Orange o) {
		if(!estPlein()) {
			ListOrange.add(o);
		}			
	}
	
	public void retire() {
		ListOrange.remove(ListOrange.get(ListOrange.size()-1));
	}
	
	public double getPrix() {
		double prixPanier = 0;
		if (!estVide()) {
			for (int i = 0 ; i < ListOrange.size() ; i++) {
				prixPanier += ListOrange.get(i).getPrix();
			}
		}

		return prixPanier;
	}
	
	public void boycottOrigine(String paysOrigine) {
		for (int i = 0 ; i<ListOrange.size() ; i++) {
			if(ListOrange.get(i).getOrigine()==paysOrigine) {
				ListOrange.remove(i);
				i=0;
			}
		}
		
	}
	
	public void viderPanier() {
		ListOrange.clear();
	} 

}
