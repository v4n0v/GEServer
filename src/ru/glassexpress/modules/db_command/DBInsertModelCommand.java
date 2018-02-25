package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.Res;

import java.sql.SQLException;

public class DBInsertModelCommand extends DBInsertCommand {


    public DBInsertModelCommand(String request) {
        super(Res.INSERT_MODEL, request);
       // this.request=request;
    }

    @Override
    void queryExecute() throws SQLException{
        ps.setString(1, parser.getStringValue("model"));
        ps.setString(2, parser.getStringValue("mark"));

    }


}
