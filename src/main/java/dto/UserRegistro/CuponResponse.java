
package dto.UserRegistro;

public class CuponResponse {

    private int idCupon;
    private String descripcion;
    private String nombre;
    private int idfoodtruck;
    private int cantidad;

    public CuponResponse(int idCupon, String descripcion, String nombre, int idfoodtruck, int cantidad) {
        this.idCupon = idCupon;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.idfoodtruck = idfoodtruck;
        this.cantidad=cantidad;
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

    public int getIdfoodtruck() {
        return idfoodtruck;
    }

    public void setIdfoodtruck(int idfoodtruck) {
        this.idfoodtruck = idfoodtruck;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
