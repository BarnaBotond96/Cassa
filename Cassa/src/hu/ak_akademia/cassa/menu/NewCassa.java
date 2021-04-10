package hu.ak_akademia.cassa.menu;

import hu.ak_akademia.cassa.db.dao.CassaDao;
import hu.ak_akademia.cassa.db.dto.CassaDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.cassa.InsertNewCassaPreparedStatementWriter;
import hu.ak_akademia.cassa.db.sqlbuilder.cassa.InsertNewCassaSqlBuilder;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NewCassa implements MenuOption {

	private final UserInputManager in;

	@Override
	public int getSequenceNumber() {
		return 1;
	}

	@Override
	public String getDescription() {
		return "Új pénztár felvétele";
	}

	@Override
	public boolean execute() {
		String name = in.readString("Kérem, adja meg a pénztár nevét: ");
		long limit = in.readLong("Kérem, adja meg a pénztár limitet: ");
		CassaDto cassaDto = new CassaDto();
		cassaDto.setName(name);
		cassaDto.setLimit(limit);
		CassaDao dao = new CassaDao();
		dao.create(new InsertNewCassaSqlBuilder(), new InsertNewCassaPreparedStatementWriter(cassaDto));
		System.out.println("Az új pénztár rögzítve.");
		return false;
	}

}