/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficinaDAO;

import datasource.DataBase;
import domain.Oficina;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author beto
 */
public class OficinaDAO implements IOficinaDAO{
    
    private ArrayList<Oficina> oficinas;
    private String query;
    DataBase bd = new DataBase();

    public OficinaDAO() {
    }

    @Override
    public List<Oficina> buscarOficinaPorDimension(double dimension) {
        oficinas = new ArrayList<>();
        Oficina o = new Oficina();
        try{
            bd.MySQLConnect();
            String query = "select * from oficina where mConstruido = "+dimension;
            
            bd.comando = bd.conexion.createStatement();
            bd.registro = bd.comando.executeQuery(query);
            
            while (bd.registro.next()){
                o.setUbicacion(bd.registro.getString(2));
                o.setMetrosTotales(bd.registro.getDouble(3));
                o.setMetrosConstruidos(bd.registro.getDouble(4));
                o.setCosto(bd.registro.getDouble(5));
                
                oficinas.add(o);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ingreso algo raro");
            Logger.getLogger(OficinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            bd.closeConnection();
        }
        return oficinas;
    }

    @Override
    public boolean registrarBodega(Oficina oficina) {
       boolean guardadoRealizado = false;
       DataBase bd = new DataBase();
       
       try{
            bd.MySQLConnect();
            query = "INSERT INTO oficina(ubicacion, mTotal, mConstruido, costo) values (?,?,?,?)"; 
            PreparedStatement sentencia = bd.conexion.prepareStatement(query);
            
            sentencia.setString(1, oficina.getUbicacion());
            sentencia.setDouble(2, oficina.getMetrosTotales());
            sentencia.setDouble(3, oficina.getMetrosConstruidos());
            sentencia.setDouble(4, oficina.getCosto());
            
            sentencia.execute();
            
            return guardadoRealizado = true;

        }
        catch(SQLException ex){
            
            Logger.getLogger(OficinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        finally{
            
            bd.closeConnection();
            
        }
        
        return guardadoRealizado;
        
    }
    
    
}
