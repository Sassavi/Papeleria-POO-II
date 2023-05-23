/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import Modelo.Producto;
import Servicios.Conexion;
import ModeloDAO.Papeleria;
import Vista.PapeleriaGUI;
import Vista.PapeleriaStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import controlador.Servicios;

public class Controller implements ActionListener {

    private PapeleriaGUI principal = null;
    private PapeleriaStock stock = null;
    private Papeleria papeleria = null;
    private Producto producto = null;
    private Servicios servicios=null;

    public Controller(PapeleriaGUI guiPrincipal, PapeleriaStock stockGui) {
        System.out.println("Iniciado");
        this.principal=guiPrincipal;
        this.stock=stockGui;
        this.papeleria = new Papeleria();
        this.producto = new Producto();
        this.servicios = new Servicios();
        principal.show(true);
        ActionListener(this);
    }

    public void ActionListener(ActionListener controlador) {
        principal.btnSell.addActionListener(controlador);
        principal.btnAddProduct.addActionListener(controlador);
        principal.btnStock.addActionListener(controlador);
    }

    public void actionPerformed(ActionEvent evento) {

        try {
            if (evento.getActionCommand().contentEquals("Añadir")) {
                producto.setCantidadDisponible(Integer.parseInt(principal.txtCantidad.getText()));
                producto.setValor(Double.parseDouble(principal.txtValor.getText()));
                producto.setCodigo(principal.txtCodigo.getText());
                producto.setDescripcion(principal.txtDescripcion.getText());
                papeleria.agregarProducto(producto);
                principal.txtCantidad.setText("");
                principal.txtValor.setText("");
                principal.txtDescripcion.setText("");
                principal.txtCodigo.setText("");
                addRow();
                servicios.Registrar(producto);

            } else if (evento.getActionCommand().contentEquals("Ver Stock")) {
                principal.show(false);
                stock.show(true);
            } else if (evento.getActionCommand().contentEquals("Vender")) {
                papeleria.venderProducto(principal.txtCodigo.getText(), Integer.parseInt(principal.txtCantidad.getText()));
                principal.txtCantidad.setText("");
                principal.txtValor.setText("");
                principal.txtDescripcion.setText("");
                principal.txtCodigo.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addRow(){
        DefaultTableModel model = (DefaultTableModel)stock.tblStock.getModel();
        ArrayList<Producto> list = papeleria.getProductos();
        Object rowData[] = new Object[4];
        for(int i=0;i<list.size();i++){
            rowData[0]= list.get(i).getCodigo();
            rowData[1]= list.get(i).getDescripcion();
            rowData[2]= list.get(i).getValor();
            rowData[3]= list.get(i).getCantidadDisponible();
        }
        model.addRow(rowData);
    }
      
}
