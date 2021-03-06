package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.Res;
import ru.glassexpress.objects_DB.GenerationObj;

import java.sql.SQLException;

public class DBSelectGenerationCommand extends DBSelectCommand{
    public DBSelectGenerationCommand(String request) {
        super(Res.GET_GENERATION, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {
        String a = parser.getStringValue("model");
        ps.setString(1,  parser.getStringValue("model"));
        System.out.println();
    }

    @Override
    void queryExecute() throws SQLException {
        System.out.println();

        composite.addComponent(new GenerationObj(rs.getInt("year_from"), rs.getInt("year_to"), rs.getInt("id_car")));
        System.out.println();
    }
}
