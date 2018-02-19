package ru.glassexpress.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.glassexpress.objects_DB.BaseObject;
import ru.glassexpress.objects_DB.CarMark;
import ru.glassexpress.objects_DB.Composite;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBDataMapper {

    Map<String, BaseObject> cache = new HashMap<>();
    private static Statement stmt;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Connection con;

    public static boolean insertMark(String mark) {
        try {
            Connection connection = DatabaseConnection.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO auto_mark  (`mark_title`) VALUES (?) ");
            statement.setString(1, mark);
            statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean insertModel(String mark, String model) {
        try {
            Connection connection = DatabaseConnection.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO `glass_express_db`.`auto_model` (`title_model`, `id_auto_mark`) VALUES (?, (SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?));");
            statement.setString(1, model);
            statement.setString(2, mark);
            statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static Composite getCarModelList(String mark) {
        String sql = "SELECT * FROM auto_model WHERE id_auto_mark = (SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?) ORDER BY title_model";
        List<Integer> ids = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        //       Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        try {
            con = DatabaseConnection.getDataSource().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mark);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_auto_mark");
                String title = rs.getString("title_model");
                ids.add(id);
                titles.add(title);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ids.size()>0) {
            Composite composite = new Composite();

            for (int i = 0; i < ids.size(); i++) {
                composite.addComponent(new CarMark(ids.get(i), titles.get(i)));
            }


            return composite;
        }
        return null;
    }

    public static Composite getCarMarksList() {
        String sql = "SELECT * FROM auto_mark ORDER BY mark_title";
        List<Integer> ids = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        try (Connection connection = DatabaseConnection.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_auto_mark");
                String title = resultSet.getString("mark_title");
                ids.add(id);
                titles.add(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Composite composite = new Composite();

        for (int i = 0; i < ids.size(); i++) {
            composite.addComponent(new CarMark(ids.get(i), titles.get(i)));
        }


        return composite;
    }
}
