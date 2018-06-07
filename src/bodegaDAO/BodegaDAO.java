/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodegaDAO;

import datasource.DataBase;
import domain.Bodega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beto
 */
public class BodegaDAO implements IBodegaDAO{
    
    private ArrayList<Bodega> bodegas;
    private String query;

    public BodegaDAO() {
    }

    @Override
    public List<Bodega> buscarBodegaPorDimension(double dimension) {
        
        bodegas = new ArrayList<>();
        DataBase bd = new DataBase();
        try{
            bd.MySQLConnect();
            String query = "select * from bodega where mConstruido = "+dimension;
            
            bd.comando = bd.conexion.createStatement();
            bd.registro = bd.comando.executeQuery(query);
            
            while (bd.registro.next()){
                Bodega b = new Bodega();
                b.setUbicacion(bd.registro.getString(2));
                b.setMetrosTotales(bd.registro.getDouble(3));
                b.setMetrosConstruidos(bd.registro.getDouble(4));
                b.setCosto(bd.registro.getDouble(5));
                bodegas.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            bd.closeConnection();
        }
        return bodegas;
    }

    @Override
    public boolean registrarBodega(Bodega bodega) {
       boolean guardadoRealizado = false;
       DataBase bd = new DataBase();
       
       try{
            bd.MySQLConnect();
            query = "INSERT INTO bodega(ubicacion, mTotal, mConstruido, costo) values (?,?,?,?)"; 
            PreparedStatement sentencia = bd.conexion.prepareStatement(query);
            
            sentencia.setString(1, bodega.getUbicacion());
            sentencia.setDouble(2, bodega.getMetrosTotales());
            sentencia.setDouble(3, bodega.getMetrosConstruidos());
            sentencia.setDouble(4, bodega.getCosto());
            
            sentencia.execute();
            
            return guardadoRealizado = true;

        }
        catch(SQLException ex){
            
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        finally{
            
            bd.closeConnection();
            
        }
        
        return guardadoRealizado;
        
    }
    }
    

