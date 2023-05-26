/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import Modelo.Producto;
import ModeloDAO.Conexion;
import ModeloDAO.Papeleria;
import Vista.PapeleriaGUI;
import Vista.PapeleriaStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller implements ActionListener {

    private PapeleriaGUI principal = null;
    private PapeleriaStock stock = null;
    private Papeleria papeleria = null;
    private Producto producto = null;

    public Controller() {
        System.out.println("Iniciado");
        this.stock = new PapeleriaStock();
        this.papeleria = new Papeleria();
        this.principal = new PapeleriaGUI();
        this.producto = new Producto();
        principal.show(true);
        ActionListener(this);
    }

    public void ActionListener(ActionListener controlador) {
        principal.btnAddProduct.addActionListener(controlador);

        principal.btnSell.addActionListener(controlador);
        principal.btnStock.addActionListener(controlador);
        principal.btnAddProduct.setActionCommand("Agregar");
        principal.btnStock.setActionCommand("Ver Stock");
        principal.btnSell.setActionCommand("Vender");
    }

    public void actionPerformed(ActionEvent evento) {

        try {
            if (evento.getActionCommand().contentEquals("Agregar")) {
                String categoria = principal.comboCategoria.getSelectedItem().toString();
                producto.setCategoria(categoria);
                producto.setCantidadDisponible(Integer.parseInt(principal.txtCantidad.getText()));
                producto.setValor(Double.parseDouble(principal.txtValor.getText()));
                producto.setCodigo(principal.txtCodigo.getText());
                producto.setDescripcion(principal.txtDescripcion.getText());
                papeleria.agregarProducto(producto);
                Object[] rowData={producto.getCategoria(), producto.getCodigo(),producto.getDescripcion(),  producto.getValor(), producto.getCantidadDisponible()};
                addRow(stock.tblStock, rowData);
                principal.txtCantidad.setText("");
                principal.txtCodigo.setText("");
                principal.txtDescripcion.setText("");
                principal.txtValor.setText("");

            } else if (evento.getActionCommand().contentEquals("Ver Stock")) {
                principal.show(false);
                stock.show(true);
            } else if (evento.getActionCommand().contentEquals("Vender")) {
                papeleria.venderProducto(principal.txtCodigo.getText(), Integer.parseInt(principal.txtCantidad.getText()));
                principal.txtCantidad.setText("");
                principal.txtCodigo.setText("");
                principal.txtDescripcion.setText("");
                principal.txtValor.setText("");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addRow(JTable table, Object[] rowData) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(rowData);
    }
}
