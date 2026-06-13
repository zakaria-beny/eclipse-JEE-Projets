package dao;


public class Friends {
	private String nom;
	private String prenom;
	private long id ;
	private long age ;
	private long numero;
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friends(String nom, String prenom, long id, long age, long numero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.age = age;
		this.numero = numero;
	}
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	
	

}
