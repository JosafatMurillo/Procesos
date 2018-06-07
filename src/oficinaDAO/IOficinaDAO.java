/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficinaDAO;

import domain.Oficina;
import java.util.List;

/**
 *
 * @author beto
 */
public interface IOficinaDAO {
    
    List <domain.Oficina> buscarOficinaPorDimension(double dimension);
    boolean registrarBodega(Oficina oficina);
    
}
