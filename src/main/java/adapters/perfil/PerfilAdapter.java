
package adapters.perfil;

import dto.UserRegistro.ClienteResponse;


public interface PerfilAdapter {
    
  ClienteResponse mostrarPerfil(int idCliente, int idTipo);
  void editarPerfil();
    
    
    
    
}
