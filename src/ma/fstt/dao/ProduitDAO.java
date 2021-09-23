package ma.fstt.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.services.BaseDAO;
import ma.fstt.entities.Produit;
@ApplicationScoped
public class ProduitDAO extends BaseDAO<Produit> {

	public ProduitDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Produit object)throws SQLException {
		
		String sql = "insert into Produit (libelle , prix) values (? ,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getLibelle());
		this.preparedStatement.setDouble(2, object.getPrix());
		
		this.preparedStatement.execute();
		
		
		
	}

	@Override
	public void update(Produit object)throws SQLException {
		
		String sql = "update  Produit set  libelle = ? , prix = ?  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getLibelle());
		this.preparedStatement.setDouble(2, object.getPrix());
		this.preparedStatement.setInt(3, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public void delete(Produit object)throws SQLException {
	String sql = "delete  from Produit  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public java.util.List<Produit> List() throws SQLException{
		
		java.util.List<Produit> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet =     this.statement.executeQuery("Select * from Produit ");
		
		while(this.resultSet.next()) {
			list.add(new Produit(this.resultSet.getInt(1), this.resultSet.getString(2),this.resultSet.getDouble(3) )) ;
		}
		return list;
	}

	@Override
	public Produit getById(int id)throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select *  from Produit  where id = ?";
		
		Produit et  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			et = new Produit(this.resultSet.getInt(1), this.resultSet.getString(2),this.resultSet.getDouble(3) );
			
			break ;
			
		}
		
		
		return et ;
	}

}
