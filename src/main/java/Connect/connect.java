package Connect;

import java.sql.*;
import java.util.Scanner;
//import java.sql.Connection;
//import java.sql.DriverManager;

/**
 * Created by Morkva on 09.07.2015.
 */
public class connect extends consts{


    Connection conn = null;
    private ResultSet rs = null;

    private static PreparedStatement getName;
    private static PreparedStatement createName;

    public void conn (){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, pass);
           // System.out.println ("Database connection established");
            loadPreparedStatements();

        } catch (Exception e) {
            System.out.println("!!!Отвалилось!!!");
            e.printStackTrace();
        }
    }

    private void loadPreparedStatements() {
        try {
            getName = conn.prepareStatement("SELECT * FROM test.www");
            createName = conn.prepareStatement("INSERT INTO test.www (name) VALUES (?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatements(){
        try {
            getName.close();
            createName.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void names(){
        try {
            ResultSet rs = getName.executeQuery("SELECT * FROM test.www");

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("id : " + name);
            }
            closePreparedStatements();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createNam(){
        try {
            String qweeeeq;
            Scanner sc = new Scanner(System.in);
            qweeeeq = sc.nextLine();
            ResultSet rs = createName.executeQuery("INSERT INTO test.www (name) VALUES (qweeeeq)");

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("id : " + name);
            }
            closePreparedStatements();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
