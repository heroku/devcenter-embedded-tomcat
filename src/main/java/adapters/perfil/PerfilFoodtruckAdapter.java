
package adapters.perfil;

import dto.UserRegistro.ClienteResponse;
import dto.UserRegistro.FoodTruckResponse;
import gestores.GestorBD;


public class PerfilFoodtruckAdapter implements PerfilAdapter {

    public ClienteResponse mostrarPerfil(int idCliente, int idTipo) {

        GestorBD gestor = GestorBD.getInstance();

        /*
        ClienteResponse clienteFoodTruck=gestor.mostrarPerfilCliente(idCliente,idTipo);
    
    FoodTruckResponse foodtruck=new FoodTruckResponse();
    foodtruck.setIdFoodTruck(clienteFoodTruck.getId_Cliente());
    
    gestor.obtenerFoodTruck(foodtruck);

    return  clienteFoodTruck;
    */
        return null;
    }


    public void editarPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
