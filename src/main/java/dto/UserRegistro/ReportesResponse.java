
package dto.UserRegistro;

public class ReportesResponse {

    private String Mesid;
    private String producto;
    private int cantidad;

    public ReportesResponse() {
    }

    public ReportesResponse(String Mesid, String producto, int cantidad) {
        this.Mesid = Mesid;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getMesid() {
        return Mesid;
    }

    public void setMesid(String Mesid) {
        this.Mesid = Mesid;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }


    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
