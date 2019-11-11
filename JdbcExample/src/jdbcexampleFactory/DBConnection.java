/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexampleFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

/**
 *
 * @author User
 */
public class DBConnection {



    
        public static Connection getConnection() {
            
        DataSource datasource = null;
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            datasource = MyDataSourceFactory.getMySQLDataSource();
            System.out.println("datasource ;"+datasource);
            conn=datasource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception se2) {
            se2.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try
    }//end try



}
