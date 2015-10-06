package dto.UserRegistro;

import java.util.List;

public class FoodTruckResponse {

    private int idFoodTruck;
    private String nombre;
    private GustosResponse gustos;
    private String direccion;
    private String horarInicio;
    private String horarFin;
    private String fotoPerfil;
    private List<EventoResponse> ventos;
    private List<ProductoResponse> productos;
    private List<ComentarioRespone> comentarios;
    private String email;
    private String password;
    private int puntaje;
    private int pustoRanking;

    public FoodTruckResponse() {
    }

    public int getIdFoodTruck() {
        return idFoodTruck;
    }

    public void setIdFoodTruck(int idFoodTruck) {
        this.idFoodTruck = idFoodTruck;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GustosResponse getGustos() {
        return gustos;
    }

    public void setGustos(GustosResponse gustos) {
        this.gustos = gustos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarInicio() {
        return horarInicio;
    }

    public void setHorarInicio(String horarInicio) {
        this.horarInicio = horarInicio;
    }

    public String getHorarFin() {
        return horarFin;
    }

    public void setHorarFin(String horarFin) {
        this.horarFin = horarFin;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public List<EventoResponse> getVentos() {
        return ventos;
    }

    public void setVentos(List<EventoResponse> ventos) {
        this.ventos = ventos;
    }

    public List<ProductoResponse> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoResponse> productos) {
        this.productos = productos;
    }

    public List<ComentarioRespone> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioRespone> comentarios) {
        this.comentarios = comentarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPustoRanking() {
        return pustoRanking;
    }

    public void setPustoRanking(int pustoRanking) {
        this.pustoRanking = pustoRanking;
    }

}
