package com.example.ILSIweb.Providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/ilsidb", "root", "root");
            System.out.println("INFO : Connected to DB 'ilsidb' successfully");
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR : Can't Connect to DB");
        }
        return null;
    }

    public static ResultSet Select_request(String req){
        ResultSet rs;
        try{
            Connection c = getConnection();
            Statement st= c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs= st.executeQuery(req);

            return rs;
        }catch(Exception e){
            System.err.println("ERROR : Can't Reach DB");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean AMS_request(String req){
        try{
            Connection c = getConnection();
            Statement st = c.createStatement();
            int rowaffected = st.executeUpdate(req);
            System.out.println("ajout sycccesssss");
            return true;
        }catch(Exception e){
            System.err.println("ERROR : Can't Update DB");
            e.printStackTrace();
            return false;
        }
    }

}
