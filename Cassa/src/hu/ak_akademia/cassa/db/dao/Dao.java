package hu.ak_akademia.cassa.db.dao;

import java.util.List;

import hu.ak_akademia.cassa.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.cassa.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public interface Dao<E> {

	void create(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter);

	List<E> retrieve(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter, ResultSetReader<E> resultSetReader);

	void update(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter);

	void delete(SqlBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter);

}