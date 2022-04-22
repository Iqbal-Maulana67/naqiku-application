package naqiku.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Susa
 */
public class Config {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String host = "jdbc:mysql://localhost/db_naqiku";
    private static String username = "root";
    private static String password = "";
    public static Connection con;
    public static void koneksi () {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(host, username, password);
            System.out.println("Database Connection: SUCCESFULL");
        } catch (Exception e) {
            System.err.println("Koneksi Gagal : " + e.getMessage());
        }
    }
    
    public static ResultSet ambilData(String sql){
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Ambil data gagal : " + e.getMessage());
            
        }
        return rs;
    }
    public static void eksekusi(String sql){
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Ambil gagal : " + e.getMessage());
        }
    }
}
