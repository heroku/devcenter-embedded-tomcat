
package launch;


import gestores.ConexionAuxiliar;
import java.sql.Connection;


public class prueba {

  
    public static void main(String[] args) {
        ConexionAuxiliar con=new ConexionAuxiliar();
         Connection conexion=con.GetConnection();
        
    }
    
}
