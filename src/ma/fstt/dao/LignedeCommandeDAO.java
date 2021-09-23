package ma.fstt.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Commande;
import ma.fstt.entities.LignedeCommande;
import ma.fstt.services.BaseDAO;
@ApplicationScoped
public class LignedeCommandeDAO extends BaseDAO<LignedeCommande> {
	
	public LignedeCommandeDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(LignedeCommande object) throws SQLException {
		
		String sql = "insert into lignedecommande (id_cmd, id_produit, quantite) values (?, ?, ?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setInt(1, object.getId_cmd());
		this.preparedStatement.setInt(2, object.getId_produit());
		this.preparedStatement.setInt(3, object.getQuantite());
		
		this.preparedStatement.execute();
		
		
	}

	@Override
	public void update(LignedeCommande object) throws SQLException {
		
		String sql = "update  lignedecommande set  id_cmd = ?, id_produit =?, quantite=?  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setInt(1, object.getId_cmd());
		this.preparedStatement.setInt(2, object.getId_produit());
		this.preparedStatement.setInt(3, object.getQuantite());
		
		this.preparedStatement.execute();	
		
	}

	@Override
	public void delete(LignedeCommande object) throws SQLException {
		
		String sql = "delete  from lignedecommande  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object.getId());
		
		this.preparedStatement.execute();		
	}

	@Override
	public java.util.List<LignedeCommande> List() throws SQLException {
		
		java.util.List<LignedeCommande> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet = this.statement.executeQuery("SELECT * from lignedecommande");
		
		while(this.resultSet.next()) {
			
			list.add(new LignedeCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3),this.resultSet.getInt(4)));
			
		}
		
		
		return list;
	}

	@Override
	public LignedeCommande getById(int id) throws SQLException {

		String sql = "select *  from LignedeCommande  where id = ?";
		
		LignedeCommande lignedecommande  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			lignedecommande = new LignedeCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3),this.resultSet.getInt(4));
			
			break ;
			
		}
		
		
		return lignedecommande ;
	}

}
