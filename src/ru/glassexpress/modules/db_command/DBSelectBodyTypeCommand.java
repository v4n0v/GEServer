package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.Res;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectBodyTypeCommand extends DBSelectCommand{
    public DBSelectBodyTypeCommand(String request) {
        super(Res.SELECT_BODY_TYPE, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }

    @Override
    void queryExecute() throws SQLException {
        composite.addComponent(new IdTitleObj(rs.getInt("id_body_type"), rs.getString("type_title")));
    }
}
