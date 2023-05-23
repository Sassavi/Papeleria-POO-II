/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package papeleríamislapices;
import controller.Controller;
import Vista.PapeleriaGUI;
import Vista.PapeleriaStock;

/**
 *
 * @author HP
 */
public class PapeleríaMisLapices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PapeleriaGUI papeleria= new PapeleriaGUI();   
        PapeleriaStock stock=new PapeleriaStock();
        Controller controller=new Controller(papeleria, stock);
    }
    
}
