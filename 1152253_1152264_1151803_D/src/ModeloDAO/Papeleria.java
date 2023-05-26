/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class Papeleria {
    
    private ArrayList<Producto> productos;

    public Papeleria() {
        productos = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public void venderProducto(String codigo, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                int stockDisponible = producto.getCantidadDisponible();
                if (stockDisponible >= (cantidad+5)){
                    producto.setCantidadDisponible(stockDisponible - cantidad);
                    System.out.println("Venta realizada. Cantidad actualizada: " + producto.getCantidadDisponible());
                } else {
                    System.out.println("No hay suficiente stock disponible para realizar la venta.");
                }
                return;
            }
        }
        System.out.println("El producto con código " + codigo + " no existe en el inventario.");
    }
    
    public void actualizarCantidadProducto(String codigo, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setCantidadDisponible(cantidad);
                System.out.println("Cantidad actualizada para el producto con código " + codigo + ": " + cantidad);
                return;
            }
        }
    }
}
