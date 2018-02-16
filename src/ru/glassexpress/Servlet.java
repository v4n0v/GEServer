package ru.glassexpress;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.glassexpress.modules.DBUtil;
import ru.glassexpress.modules.DatabaseConnection;
import ru.glassexpress.objects_DB.CarMarks;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    DatabaseConnection ddbConn;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        String answerJson = null;
        System.out.println(action);
        switch (action) {
            case "/MyServlet/list":
                answerJson = getCars(request, response);
                System.out.println("List request");
                break;
            case "/MyServlet/delete":
                System.out.println("Delete request");
                break;
            case "/MyServlet/insert":
                System.out.println("Insert request");

                break;
            default:
                answerJson="FUCK OFF";
                break;
        }

        boolean rowInserted = false;


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        if(answerJson!=null) {

            PrintWriter out = response.getWriter();

            out.println(answerJson);

            out.close();
         }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    private String getCars(HttpServletRequest request, HttpServletResponse response) {

        String sql = "SELECT * FROM auto_mark";

        List<Integer> ids = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        try (Connection connection = DBUtil.getDataSource().getConnection();
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
        String[] markTitles=null;
        markTitles = titles.toArray(new String[titles.size()]);

        Integer[] markIDs=null;
        markIDs = ids.toArray(new Integer[ids.size()]);

        if (ids.size() != 0 && titles.size() != 0) {
            CarMarks marks = new CarMarks(markIDs, markTitles);
            System.out.println(GSON.toJson(marks));
            return GSON.toJson(marks);
        }


        return null;
    }
}
