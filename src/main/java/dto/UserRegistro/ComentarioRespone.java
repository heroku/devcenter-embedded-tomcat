
package dto.UserRegistro;

import java.util.Date;

public class ComentarioRespone {

    private int idfoodtruck;
    private String comentario;
    private int idCliente;
    private Date fecha;

    public ComentarioRespone() {
    }

    public ComentarioRespone(int idfoodtruck, String comentario, int idCliente, Date fecha) {
        this.idfoodtruck = idfoodtruck;
        this.comentario = comentario;
        this.idCliente = idCliente;
        this.fecha = fecha;
    }

    public int getIdfoodtruck() {
        return idfoodtruck;
    }

    public void setIdfoodtruck(int idfoodtruck) {
        this.idfoodtruck = idfoodtruck;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
