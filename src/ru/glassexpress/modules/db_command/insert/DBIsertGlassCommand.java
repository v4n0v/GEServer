package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBInsertCommand;

import java.sql.SQLException;

public class DBIsertGlassCommand extends DBInsertCommand {
    public DBIsertGlassCommand(String request) {
        super(Res.INSERT_GLASS, request);
    }

    @Override
    protected void queryExecute() throws SQLException {

        ps.setInt(1, parser.getIntValue("id_car"));
        ps.setInt(2, parser.getIntValue("id_glass_type"));
        ps.setInt(3, parser.getIntValue("id_glass_opt"));
        ps.setString(4, parser.getStringValue("glass_description"));
        ps.setFloat(5, parser.getFloatValue("price_in"));
        ps.setFloat(6, parser.getFloatValue("price_out"));
        ps.setInt(7, parser.getIntValue("alert_remainder"));
        ps.setInt(8, parser.getIntValue("glass_factory"));
        ps.setInt(9, parser.getIntValue("insert_method"));
        ps.setFloat(10, parser.getFloatValue("insert_price"));

    }

}

//   .setRequest("id_auto", String.valueOf(glass.getCarId()))
//           .setRequest("glass_description", glass.getDescription())
//           .setRequest("price_in", String.valueOf(glass.getPriceIn()))
//           .setRequest("price_out", String.valueOf(glass.getPrice()))
//           .setRequest("id_glass_opt", String.valueOf(glass.getGlassOptionId()))
//           .setRequest("glass_factory", String.valueOf(glass.getGlassFactory()))
//           .setRequest("id_glass_type", String.valueOf(glass.getGlassTypeId()))
//           .setRequest("insert_method", String.valueOf(glass.getInsertMethod()))
//           .setRequest("alert_remainder", String.valueOf(glass.getInsertMethod()))