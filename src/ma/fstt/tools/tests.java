package ma.fstt.tools;

import java.util.List;
import java.sql.SQLException;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;

public class tests {
public static void main(String[] args) {
	/*Client et = new Client(1, "Salmi", "Lamiae",25,"Hay al saada");
	
	ClientDAO cdao;
	try {
		cdao = new ClientDAO();
		cdao.save(et);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	ProduitDAO cdao;
	try {
		cdao = new ProduitDAO();
		Produit a=new Produit(1,"jeux",150);
		//cdao.delete(a);
		cdao.update(a);
	}catch(Exception e)
	{
		System.out.println("hello");
		System.out.println(e.getMessage());
	}
}
}
