package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.SQLPrefs;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectMarkCommand extends DBSelectCommand {
    public DBSelectMarkCommand() {
        super(SQLPrefs.GET_MARKS, null);
    }

    @Override
    void queryExecute() throws SQLException {
        composite.addComponent(new IdTitleObj(rs.getInt("id_auto_mark"), rs.getString("mark_title")));
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }
}
