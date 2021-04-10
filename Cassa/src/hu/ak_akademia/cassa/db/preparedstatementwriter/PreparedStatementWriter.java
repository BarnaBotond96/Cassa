package hu.ak_akademia.cassa.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementWriter {

	void write(PreparedStatement preparedStatement) throws SQLException;

}