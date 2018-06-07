/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author beto
 */
public class DataBase {
    
    public Connection conexion = null;
    public Statement comando = null;
    public ResultSet registro;
 
    public Connection MySQLConnect() {
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/proyecto";
            String usuario = "beto";
            String pass = "123";
            conexion = DriverManager.getConnection(servidor, usuario, pass);
 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return conexion;
        }
    }
    
    public void  closeConnection(){
        if(conexion != null){
            try{
                if(!conexion.isClosed()){
                    conexion.close();
                }
            } catch (SQLException ex){
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
