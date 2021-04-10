package hu.ak_akademia.cassa.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import hu.ak_akademia.cassa.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.cassa.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public abstract class AbstractDao<E> implements Dao<E> {

	private static final String PASSWORD = "admin";
	private static final String USER = "postgres";
	private static final String HOST = "jdbc:postgresql://localhost:5432/Cassa";

	@Override
	public void create(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		try (Connection connection = DriverManager.getConnection(HOST, USER, PASSWORD)) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatementWriter.write(preparedStatement);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println("Hiba az adatbázisba történő rekord beszúrása közben.");
		}
	}

	@Override
	public List<E> retrieve(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter, ResultSetReader<E> resultSetReader) {
		try (Connection connection = DriverManager.getConnection(HOST, USER, PASSWORD)) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatementWriter.write(preparedStatement);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					return resultSetReader.read(resultSet);
				}
			}
		} catch (SQLException e) {
			System.err.println("Hiba az adatbázisból történő lekérdezés közben.");
		}
		return Collections.emptyList();
	}

	@Override
	public void update(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		try (Connection connection = DriverManager.getConnection(HOST, USER, PASSWORD)) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatementWriter.write(preparedStatement);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println("Hiba az adatbázisban lévő rekord frissítése közben.");
		}
	}

	@Override
	public void delete(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		try (Connection connection = DriverManager.getConnection(HOST, USER, PASSWORD)) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatementWriter.write(preparedStatement);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println("Hiba az adatbázisból történő rekord törlése közben.");
		}
	}

}