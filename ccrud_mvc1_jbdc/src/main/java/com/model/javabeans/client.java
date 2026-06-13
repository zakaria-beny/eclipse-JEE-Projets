package com.model.javabeans;

public class client {
    private String nom;
    private String prenom;
    private int id;
    private int age;

    public client(String nom, String prenom, int id, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.age = age;
    }

    public client() {}

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
