/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_ex;

import java.sql.*;

/**
 *
 * @author rahul
 */
public class Jdbc_ex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

try {
                Class.forName("org.sqlite.JDBC");
                //Step 3: define the connection URL
                
                String url = "jdbc:sqlite:D:/database/personinfo.db";
                //Step 4: establish the connection
                
                Connection con = DriverManager.getConnection(url);
                //Step 5: create Statement
                System.out.println("Opened database successfully");
                Statement st = con.createStatement();
                //Step 6: preapare & execute the query
                
                String sql = "SELECT * FROM Persons;";
                ResultSet rs = st.executeQuery(sql);
                //Step 7: process the results
                
                while(rs.next())
                {
                        // The row name is “name” in database “PersonInfo,// hence specified in the getString()method.
                        int ID =rs.getInt("id");
                        String name = rs.getString("name");
                        String add = rs.getString("add");
                        String pnum = rs.getString("phonenum");
              
                        System.out.println(ID + "" + name + "" + add + "" + pnum +"");
                }
                        //Step 8: close the connection
                        con.close();
            }        
        catch (Exception sqlEx)
        {
                
                System.out.println(sqlEx);
        }

    }
}