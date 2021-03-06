package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.RequestParser;
import ru.glassexpress.objects_DB.Composite;

import java.sql.*;

public abstract class DBCommand {
    protected Statement stmt;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected Connection con;

    String sql;
    String request;

    protected Composite composite;


    RequestParser parser;
    public DBCommand(String sql, String request) {
        this.sql = sql;
        if (request!=null) {
            parser = new RequestParser();
            parser.parseRequest(request);
        }
        composite=new Composite();
    }

    public abstract Composite execute();

    protected void disconnect(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    abstract void queryExecute( ) throws SQLException;
}
