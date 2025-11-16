/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentalMobil;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Fardan
 */
public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/parking_lot_db"; 
    private static final String dbuser = "root";
    private static final String dbpass = "";
    private Statement st = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public static Connection getKoneksi() {
        try {
            Connection newConnection = DriverManager.getConnection(URL, dbuser, dbpass);
            System.out.println("Database Connected"); // buat testing ntar remove aja
            return newConnection;
        } catch (SQLException e) {
            // popup buat user klo connection fail
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage());
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    
    public ResultSet getData(String SQLString){
        try{ 
            rs = st.executeQuery(SQLString);
        } catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public void query(String SQLString){
        try{ 
            st.executeUpdate(SQLString);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE); 
        }
    }
}



