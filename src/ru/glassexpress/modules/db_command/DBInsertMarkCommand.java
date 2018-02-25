package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.SQLPrefs;

import java.sql.SQLException;

public class DBInsertMarkCommand extends DBInsertCommand{
    public DBInsertMarkCommand(String request) {
        super(SQLPrefs.INSERT_MARK, request);
    }

    @Override
    void queryExecute() throws SQLException {
        ps.setString(1, parser.getStringValue("mark"));
    }
}
