/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexampleFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bilt
 */
public class JdbcExample {

    private static boolean addEmpWithPreParedStat(Emp emp) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DBConnection.getConnection();
            stmt = con.prepareStatement("insert into emp values (?,?,?)");
            stmt.setString(1, emp.id);
            stmt.setString(2, emp.name);
            stmt.setString(3, emp.add);
            int noOfefectedRows = stmt.executeUpdate();
            System.out.println("noOfefectedRows : " + noOfefectedRows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(con, stmt, null);
        }

        return false;
    }

    private static boolean addEmp(Emp emp) {
        Connection con = null;
        Statement stmt = null;

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "insert into emp values (" + emp.id + ",'" + emp.name + "','" + emp.add + "')";
            System.out.println(sql);
            int noOfefectedRows = stmt.executeUpdate(sql);
            System.out.println("noOfefectedRows : " + noOfefectedRows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(con, stmt, null);
        }

        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.id="123";
        emp.name="Faysal";
        emp.add="Bogra";
        
        addEmpWithPreParedStat(emp);
    }
}
