
package ModeloDAO;


import java.sql.*;

/**
 *
 * @author argue
 */
public class Conexion {
    
    private static Connection cnx = null;
    
    public static Connection obtener() throws ClassNotFoundException, SQLException{
        
        if(cnx == null){
         // Le pasamos el nombre de la conexion | Verificando el conector...
          Class.forName("com.mysql.jdbc.Driver");
          // El usuario es root, porque aun no hay un usuario configurado, root vendria siendo un usuario global
          cnx = DriverManager.getConnection("jdbc:mysql://localhost/hotel","root", " ");
        }
        
    
        return cnx;
    }
    
    
    
    
}
