package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.Res;

import java.sql.SQLException;

public class DBIsertGlassCommand extends DBInsertCommand {
    public DBIsertGlassCommand(String request) {
        super(Res.INSERT_GLASS, request);
    }

    @Override
    void queryExecute() throws SQLException {
        ps.setInt(1, parser.getIntValue("id_auto"));
        ps.setInt(2, parser.getIntValue("id_glass_type"));
        ps.setInt(3, parser.getIntValue("id_glass_opt"));
        ps.setString(4, parser.getStringValue("glasss_description"));
        ps.setInt(5, parser.getIntValue("alert_remainder"));
        ps.setFloat(6, parser.getFloatValue("price_in"));
        ps.setFloat(7, parser.getFloatValue("price_out"));
        ps.executeUpdate();
    }
}

