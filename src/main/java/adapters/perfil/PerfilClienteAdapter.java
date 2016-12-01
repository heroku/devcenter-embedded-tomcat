
package adapters.perfil;

import dto.UserRegistro.ClienteResponse;
import gestores.GestorBD;


public class PerfilClienteAdapter implements  PerfilAdapter{

    public ClienteResponse mostrarPerfil(int idCliente,int idTipo) {
        
      GestorBD gestor=GestorBD.getInstance();
     // ClienteResponse clienteNormal=gestor.mostrarPerfilCliente(idCliente,idTipo);
      //return clienteNormal;
        return null;
    }

    public void editarPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
