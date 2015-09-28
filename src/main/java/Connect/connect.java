package Connect;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

/**
 * Created by Morkva on 09.07.2015.
 */
public class connect {

    String url = "jdbc:mysql://localhost:3306/test";
    String login = "root";
    String pass = "6228483";
    Connection conn = null;
    private ResultSet rs = null;

    private static PreparedStatement getName;

    public void conn (){
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, pass);
            System.out.println ("Database connection established");
            loadPreparedStatements();

        } catch (Exception e) {
            System.out.println("!!!Отвалилось!!!");
            e.printStackTrace();
        }
    }

    private void loadPreparedStatements() {
        try {
            getName = conn.prepareStatement("SELECT * FROM test.www");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatements(){
        try {
            getName.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void names(){


        try {
            ResultSet rs = getName.executeQuery("SELECT * FROM test.www");

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("name : " + name);
            }
            closePreparedStatements();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
