
package dto.UserRegistro;

public class CuponResponse {

    private int idCupon;
    private String descripcion;
    private String qr;
    private String nombre;

    public CuponResponse(int idCupon, String descripcion, String qr, String nombre) {
        this.idCupon = idCupon;
        this.descripcion = descripcion;
        this.qr = qr;
        this.nombre = nombre;
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

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
