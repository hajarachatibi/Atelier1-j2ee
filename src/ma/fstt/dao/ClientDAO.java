package ma.fstt.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.services.BaseDAO;
import ma.fstt.entities.Client;
@ApplicationScoped
public class ClientDAO extends BaseDAO<Client>{

	public ClientDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Client object)throws SQLException {
		
		String sql = "insert into Client (nom ,prenom, age,adresse) values (? ,?,?,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getNom());
		this.preparedStatement.setString(2, object.getPrenom());
		this.preparedStatement.setInt(3, object.getAge());
		this.preparedStatement.setString(4, object.getAdresse());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public void update(Client object)throws SQLException {
		
		String sql = "update  Client set  prenom= ? ,nom = ? , age = ? , adresse= ?  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		this.preparedStatement.setString(1, object.getPrenom());
		this.preparedStatement.setString(2, object.getNom());
		this.preparedStatement.setInt(3, object.getAge());
		this.preparedStatement.setString(4, object.getAdresse());
		this.preparedStatement.setInt(5, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public void delete(Client object)throws SQLException {
	String sql = "delete  from Client  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public java.util.List<Client> List() throws SQLException{
		
		java.util.List<Client> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet =this.statement.executeQuery("Select * from Client ");
		
		while(this.resultSet.next()) {
			
			
			list.add(new Client(this.resultSet.getInt(1), this.resultSet.getString(2),this.resultSet.getString(3),this.resultSet.getInt(4) ,this.resultSet.getString(5))) ;
			
		}
		return list;
	}

	@Override
	public Client getById(int id)throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select *  from Client  where id = ?";
		
		Client et  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			et = new Client(this.resultSet.getInt(1), this.resultSet.getString(2),this.resultSet.getString(3),this.resultSet.getInt(4),this.resultSet.getString(5) );
			
			break ;
			
		}
		
		
		return et ;
	}
}
