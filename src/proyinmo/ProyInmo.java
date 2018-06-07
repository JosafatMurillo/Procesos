/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyinmo;

import bodegaDAO.BodegaDAO;
import domain.Bodega;
import domain.Oficina;
import oficinaDAO.OficinaDAO;

/**
 *
 * @author beto
 */
public class ProyInmo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        BodegaDAO b = new BodegaDAO();
        OficinaDAO o = new OficinaDAO();
        Bodega a = new Bodega();
        Oficina of = new Oficina();
        
        a.setUbicacion("Rebsamen");
        a.setMetrosTotales(30.0);
        a.setMetrosConstruidos(12.21);
        a.setCosto(10000.00);
        
        b.registrarBodega(a);
        
        of.setUbicacion("Av.Xalapa");
        of.setMetrosTotales(5000);
        of.setMetrosConstruidos(1000);
        of.setCosto(20000);
        
        o.registrarBodega(of);
    }
}
