package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.DBConnect;
import ru.glassexpress.objects_DB.Composite;
import ru.glassexpress.objects_DB.ErrorObject;
import ru.glassexpress.objects_DB.OkObject;

import java.sql.*;

abstract class DBInsertCommand extends DBCommand{

    public DBInsertCommand(String sql, String request) {
        super(sql, request);
    }

    public Composite execute( ) {

        try {
            con = DBConnect.getConnection();
            if (con!=null) {
                con.setAutoCommit(false);
                ps = con.prepareStatement(sql);
                queryExecute();

                ps.executeUpdate();
                con.commit();
                disconnect();
            }
        } catch (SQLException e) {

            e.printStackTrace();
            composite.addComponent(new ErrorObject());
            return composite;
        }
        composite.addComponent(new OkObject());
        return composite;
    }



}
