package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.Res;
import ru.glassexpress.objects_DB.TableGoodsInStockRow;
import ru.glassexpress.objects_DB.builders.TableGoodsBuilder;

import java.sql.SQLException;

public class DBSelectGlassCommand extends DBSelectCommand {
    public DBSelectGlassCommand(String request) {
        super(Res.SELECT_GLASS, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {


    }

    @Override
    void queryExecute() throws SQLException {
        TableGoodsInStockRow table = new TableGoodsBuilder().
                setId(rs.getInt("id_glass")).
                setGlassType(rs.getInt("id_glass_type")).
                setGlassOption(rs.getInt("id_glass_options")).
                setDescription(rs.getString("description")).
                setPriceIn(rs.getFloat("price_in")).
                setPrice(rs.getFloat("price_out")).
                setCountRemainder(rs.getInt("alert_remainder"))
                .build();

        composite.addComponent(table);
    }
}
