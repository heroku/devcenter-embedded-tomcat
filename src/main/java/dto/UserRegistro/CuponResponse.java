
package dto.UserRegistro;

public class CuponResponse {

    private int idCupon;
    private String descripcion;
    private String nombre;
    private int idFoodtruck;

    public CuponResponse(int idCupon,int idFoodtruck,String descripcion ,String nombre) {
        this.idCupon = idCupon;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.idFoodtruck=idFoodtruck;
    }

    public CuponResponse() {
    }

    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFoodtruck() {
        return idFoodtruck;
    }

    public void setIdFoodtruck(int idFoodtruck) {
        this.idFoodtruck = idFoodtruck;
    }
    
    
    

}
