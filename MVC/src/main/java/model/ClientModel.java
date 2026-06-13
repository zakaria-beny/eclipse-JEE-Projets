package model;

public class ClientModel {
	private String nom;
	private String prenom;
	private double prime;
	
	public ClientModel(String nom, String prenom, double prime) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.prime = prime;
	}
	
	public ClientModel() {}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getPrime() {
		return prime;
	}

	public void setPrime(double prime) {
		this.prime = prime;
	}
	
	
}
