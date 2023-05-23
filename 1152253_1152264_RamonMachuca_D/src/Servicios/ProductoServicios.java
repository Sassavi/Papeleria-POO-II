/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Producto;
/**
 *
 * @author Hp
 */
public class ProductoServicios {
    public void guardar(Connection conexion, Producto producto) throws SQLException{
      try{
          
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("INSERT INTO registro (codigo, descripcion, valor, cantdisponble) "
                 + "VALUES(?, ?, ?, ?)");        
         consulta.setString(1, producto.getCodigo());
         consulta.setString(2, producto.getDescripcion());
         consulta.setDouble(3, producto.getValor());    
         consulta.setInt(4, producto.getCantidadDisponible());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
}
