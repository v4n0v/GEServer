package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.Res;

import java.sql.SQLException;

public class DBInsertMarkCommand extends DBInsertCommand{
    public DBInsertMarkCommand(String request) {
        super(Res.INSERT_MARK, request);
    }

    @Override
    void queryExecute() throws SQLException {
        ps.setString(1, parser.getStringValue("mark"));
    }
}
