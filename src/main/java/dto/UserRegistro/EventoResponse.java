/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.UserRegistro;

import java.util.Date;

public class EventoResponse {

    private int idEvento;
    private String nombre;
    private String Descripcion;
    private String url;
    private Date fechaPublicacion;

    public EventoResponse(int idEvento, String nombre, String Descripcion, String url,Date fechaPublicacion) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.url = url;
        this.fechaPublicacion=fechaPublicacion;
    }

    public EventoResponse() {
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
    

}
