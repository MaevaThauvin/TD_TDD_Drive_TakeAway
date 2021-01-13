package Modele;

public class Orange {
	private double prix;
	private String origine;
	
	public Orange(double prix, String origine) throws Exception {
		super();
		if (prix<0) throw new Exception("Le prix ne peut pas être négatif");
		this.prix = prix;
		this.origine = origine;
	}

	public double getPrix() {
		return prix;
	}

	public String getOrigine() {
		return origine;
	}
	
	public String toString() {
		return ("Prix : "+getPrix()+" ; Origine : "+getOrigine());
	}


	public boolean equals(Orange orange) {
		if (this == orange)
			return true;
		if (orange == null)
			return false;
		if (getClass() != orange.getClass())
			return false;
		Orange other = (Orange) orange;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
	
}
