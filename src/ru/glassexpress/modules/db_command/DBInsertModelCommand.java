package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.SQLPrefs;

import java.sql.SQLException;

public class DBInsertModelCommand extends DBInsertCommand {


    public DBInsertModelCommand(String request) {
        super(SQLPrefs.INSERT_MODEL, request);
       // this.request=request;
    }

    @Override
    void queryExecute() throws SQLException{
        ps.setString(1, parser.getStringValue("model"));
        ps.setString(2, parser.getStringValue("mark"));

    }


}
