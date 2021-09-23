package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Client {
private int id;
private String Nom;
private String Prenom;
private int age;
private String Adresse;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Client(int id, String nom, String prenom, int age, String adresse) {
	super();
	this.id = id;
	Nom = nom;
	Prenom = prenom;
	this.age = age;
	Adresse = adresse;
}
public Client() {
	// TODO Auto-generated constructor stub
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}
public String toString()
{
String desc="";
desc+="id: "+this.id+"nom : "+this.Nom+"prenom : "+this.Prenom+" age : "+this.age+" adresse : "+this.Adresse;
return desc;
}
public Client(String nom, String prenom, int age, String adresse) {
	super();
	Nom = nom;
	Prenom = prenom;
	this.age = age;
	Adresse = adresse;
}
}
