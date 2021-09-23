package ma.fstt.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Commande;
import ma.fstt.entities.Produit;
import ma.fstt.services.BaseDAO;
@ApplicationScoped
public class CommandeDAO extends BaseDAO<Commande>  {

	public CommandeDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(Commande object) throws SQLException {
		String sql = "insert into commande (id_client) values (?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setInt(1, object.getId_client());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public void update(Commande object) throws SQLException {
		
		String sql = "update  commande set  id_client = ?  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setInt(1, object.getId_client());
		this.preparedStatement.setInt(2, object.getId());
		
		this.preparedStatement.execute();		
	}

	@Override
	public void delete(Commande object) throws SQLException {
		
		String sql = "delete  from lignedecommande  where id_cmd = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object.getId());
		
		this.preparedStatement.execute();
		
		sql = "delete  from commande  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object.getId());
		
		this.preparedStatement.execute();

		
	}
	public void deletefromcmd(Produit object1, Commande object2) throws SQLException {
		
		String sql = "delete  from lignedecommande  where (id_cmd = ? AND id_produit = ?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object2.getId());
		this.preparedStatement.setInt(2, object1.getId());
		
		this.preparedStatement.execute();

		
	}
	
	public int quantitep(Produit object1, Commande object2) throws SQLException {
		
		String sql = "select quantite from lignedecommande where (id_produit = ? AND id_cmd = ?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object1.getId());
		this.preparedStatement.setInt(2, object2.getId());
		
		ResultSet rs = this.preparedStatement.executeQuery();
		
		int quantite = 0;
		
		while(rs.next()) {
			
			quantite = rs.getInt(1);
		}		
		return quantite;

		
	}
	@Override
	public java.util.List<Commande> List() throws SQLException {
		
		java.util.List<Commande> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet = this.statement.executeQuery("SELECT * from Commande");
		
		while(this.resultSet.next()) {
			
			list.add(new Commande(this.resultSet.getInt(1), this.resultSet.getInt(2) )) ;
			
		}
		
		
		return list;

	}

	@Override
	public Commande getById(int id) throws SQLException {
		String sql = "select *  from commande  where id = ?";
		
		Commande commande  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			commande = new Commande(this.resultSet.getInt(1), this.resultSet.getInt(2) );
			
			break ;
			
		}
		
		
		return commande ;

	}
	
	public Commande getlast() throws SQLException {
		String sql = "Select * From commande Order By id desc LIMIT 1";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		ResultSet rs = this.preparedStatement.executeQuery();
		
		Commande cmd =null;
		
		while(rs.next())
		{
		 cmd = new Commande( rs.getInt(1), rs.getInt(2));
		}
		return cmd ;

	}
	
	public java.util.List<Produit> ListParcmd(Commande object) throws SQLException{
		
		java.util.List<Produit> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet = this.statement.executeQuery("SELECT * FROM produit where id IN (SELECT lignedecommande.id_produit FROM lignedecommande WHERE id_cmd ="+object.getId()+")");
		
		while(this.resultSet.next()) {
			list.add(new Produit(this.resultSet.getInt(1), this.resultSet.getString(2),this.resultSet.getDouble(3) )) ;
		}
		return list;
	}

}
