package ma.fstt.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ma.fstt.entities.Commande;
import ma.fstt.tools.ConnectionManager;

//import ma.fstt.tools.ConnectionManager;

public abstract class BaseDAO <T> {
	
	
	protected Connection connection;
	protected Statement statement ;
	protected PreparedStatement preparedStatement ;
	protected  ResultSet resultSet ;
	
	
	
	public BaseDAO() throws SQLException, ClassNotFoundException {
		
		
		connection = ConnectionManager.getConnection() ;
		
	}
	
	
	public abstract void  save(T object)  throws SQLException;
	
	public abstract void  update(T object) throws SQLException ;
	public abstract void  delete(T object) throws SQLException;
	
	public abstract java.util.List<T>  List() throws SQLException;
	
	public abstract T  getById(int id) throws SQLException;
	
	

}
