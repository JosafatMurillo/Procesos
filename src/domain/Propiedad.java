/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author beto
 */
public class Propiedad {
    
    private String ubicacion;
    private double metrosTotales;
    private double metrosConstruidos;
    private double costo;

    public Propiedad() {
        
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getMetrosTotales() {
        return metrosTotales;
    }

    public double getMetrosConstruidos() {
        return metrosConstruidos;
    }

    public double getCosto() {
        return costo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setMetrosTotales(double metrosTotales) {
        this.metrosTotales = metrosTotales;
    }

    public void setMetrosConstruidos(double metrosConstruidos) {
        this.metrosConstruidos = metrosConstruidos;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
