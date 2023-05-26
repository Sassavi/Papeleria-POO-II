/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Producto;
import ModeloDAO.Conexion;
import ModeloDAO.Papeleria;
import Servicios.ProductoServicios;

/**
 *
 * @author Hp
 */
public class Servicios {
    public void Papeleria(Producto producto){
        try{
            ProductoServicios ps = new ProductoServicios();
            ps.guardar(Conexion.obtener(), producto);
        }catch(Exception e){}        
    } 
}
