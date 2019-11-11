/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexampleFactory;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author bitl
 */
public class PropertyExample {
     public static void main(String[] args){
         try {
             Properties prop = new Properties();
             FileInputStream fis = new FileInputStream("my.properties");
             prop.load(fis);
             String name = prop.getProperty("name");
             String pass = prop.getProperty("pass");
             System.out.println(name);
             System.out.println(pass);
         } catch (Exception e) {
         }
     }
}
