/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexampleFactory;

/**
 *
 * @author bilt
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSourceFactory {

    public static DataSource getMySQLDataSource() {
        Properties prop = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
       

        try {
            fis = new FileInputStream("my.properties");
            prop.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(prop.getProperty("db_Url"));
            mysqlDS.setUser(prop.getProperty("user"));
            mysqlDS.setPassword(prop.getProperty("pass"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDS;
    }

//	public static DataSource getOracleDataSource(){
//		Properties props = new Properties();
//		FileInputStream fis = null;
//		OracleDataSource oracleDS = null;
//		try {
//			fis = new FileInputStream("db.properties");
//			props.load(fis);
//			oracleDS = new OracleDataSource();
//			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
//			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
//			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return oracleDS;
//	}
}
