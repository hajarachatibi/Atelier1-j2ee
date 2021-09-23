package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Produit {
private int id;
private String Libelle;
private double prix;
public int getId() {
	return id;
}
public Produit(int id, String libelle, double prix) {
	super();
	this.id = id;
	Libelle = libelle;
	this.prix = prix;
}
public void setId(int id) {
	this.id = id;
}
public Produit() {
	super();
}
public Produit(String libelle, double prix) {
	super();
	Libelle = libelle;
	this.prix = prix;
}
public String getLibelle() {
	return Libelle;
}
public void setLibelle(String libelle) {
	Libelle = libelle;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
}
