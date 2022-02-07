package net.zaimoon.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import net.zaimoon.usermanagement.model.Destino;

public class DestinoDAO {

	private String url = "jdbc:mysql://localhost:3306/agencia2?useSSL=false";
	private String user = "root";
	private String password = "root";
	
	
	
	private static final String insertDestinos = "INSERT INTO destinos" + " (nome, uf, country) VALUES "
	+ " (?, ?, ?);";
	
	private static final String selectByID = "select id,nome,uf,country from destinos where id =?";
	private static final String selectAllDestinos = "select * from destinos";
	private static final String deleteDestinos = "delete from destinos where id = ?;";
	private static final String updateDestinos = "update destinos set nome = ?,uf=?, country =? where id = ?;";
	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		} catch(SQLException e) {
			e.printStackTrace();			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}	
		return connection;
	}
	
	//insert
	public void insert (Destino destino) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertDestinos)) {
			preparedStatement.setString(1, destino.getNome());
			preparedStatement.setString(2, destino.getUf());
			preparedStatement.setString(3, destino.getCountry());
			preparedStatement.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//update
	public boolean update (Destino destino) throws SQLException {
		boolean rowUpdated;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(updateDestinos)) {
			statement.setString(1, destino.getNome());
			statement.setString(2, destino.getUf());
			statement.setString(3, destino.getCountry());
			statement.setInt(4, destino.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}	
	
	//SelectById
	public Destino select(int id) {
		Destino destino = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectByID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String uf = rs.getString("uf");
				String country = rs.getString("country");
				destino = new Destino(id, nome, uf, country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destino;
	}
	
	
	//SelectAllDestinos
	public List<Destino> selectALLDestinos() {

		List<Destino> destinos = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(selectAllDestinos);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String uf = rs.getString("uf");
				String country = rs.getString("country");
				destinos.add(new Destino(id, nome, uf, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destinos;
	}
	
	
	//DeleteDestino
	public boolean deleteDesTinos(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteDestinos);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	
}
