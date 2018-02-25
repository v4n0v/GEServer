package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.DBConnect;
import ru.glassexpress.objects_DB.Composite;

import java.sql.SQLException;

public abstract class DBSelectCommand extends DBCommand{
    public DBSelectCommand(String sql, String request) {
        super(sql, request);
    }




    public Composite execute(){


        try{ con= DBConnect.getConnection();
            if (con!=null) {
                ps = con.prepareStatement(sql);
                prepareStatement();
                rs = ps.executeQuery();

                while (rs.next()) {
                    queryExecute();
                }
                disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return composite;
    }

    protected abstract void prepareStatement() throws SQLException;

}
