/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author rahul
 */
public class Db {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:@localhost:8080:rahul"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "rahul");
        props.setProperty("password", "rahul");
      
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);

        String sql ="select sysdate as current_day from dual";

        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
    
        ResultSet result = preStatement.executeQuery();
      
        while(result.next()){
            System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
        }
        System.out.println("done");
      
    }

   
    
}
