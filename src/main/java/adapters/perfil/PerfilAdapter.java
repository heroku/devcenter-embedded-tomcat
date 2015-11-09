
package adapters.perfil;

import dto.UserRegistro.ClienteResponse;


public interface PerfilAdapter {
    
  public ClienteResponse mostrarPerfil(int idCliente,int idTipo);
  public void editarPerfil();   
    
    
    
    
}
