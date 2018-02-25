package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.SQLPrefs;

import java.sql.SQLException;

public class DBInsertGenerationCommand extends DBInsertCommand{
    public DBInsertGenerationCommand(String request) {
        super(SQLPrefs.INSERT_GENERATION, request);
    }

    @Override
    void queryExecute() throws SQLException {
        System.out.println("insert generation");
        int yearFrom = parser.getIntValue("yearFrom");
        ps.setInt(1, parser.getIntValue("yearFrom"));
        ps.setInt(2, parser.getIntValue("yearTo"));
        ps.setString(3, parser.getStringValue("model"));
    }
}
