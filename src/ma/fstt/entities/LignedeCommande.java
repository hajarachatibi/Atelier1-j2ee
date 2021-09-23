package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LignedeCommande {
	
	private int id;
	
	private int id_cmd;
	
	private int id_produit;
	
	private int quantite;

	public LignedeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LignedeCommande(int id, int id_cmd, int id_produit, int quantite) {
		super();
		this.id = id;
		this.id_cmd = id_cmd;
		this.id_produit = id_produit;
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_cmd() {
		return id_cmd;
	}

	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
