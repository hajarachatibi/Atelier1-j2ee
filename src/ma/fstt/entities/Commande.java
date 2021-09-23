package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Commande {
	private int id;
	
	private int id_client;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int id, int id_client) {
		super();
		this.id = id;
		this.id_client = id_client;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	
}
