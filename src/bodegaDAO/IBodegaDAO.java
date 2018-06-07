/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodegaDAO;

import domain.Bodega;
import java.util.List;

/**
 *
 * @author beto
 */
public interface IBodegaDAO {
    
    List <domain.Bodega> buscarBodegaPorDimension(double dimension);
    boolean registrarBodega(Bodega bodega);
}
