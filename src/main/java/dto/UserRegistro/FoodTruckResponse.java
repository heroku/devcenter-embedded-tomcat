package dto.UserRegistro;

import java.util.List;

public class FoodTruckResponse {

    private int idFoodTruck;
    private String nombre;
    private GustosResponse gustos;
    private String horarInicio;
    private String horarFin;
    private String fotoPerfil;
    private List<EventoResponse> eventos;
    private List<ProductoResponse> productos;
    private List<ComentarioResponse> comentarios;
    private List<CuponResponse> cupones;
    private String email;
    private String password;
    private int puntaje;
    private int pustoRanking;
    private String condicion;
    private float latitud;
    private float longitud;

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

    public List<EventoResponse> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoResponse> eventos) {
        this.eventos = eventos;
    }

    public List<ProductoResponse> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoResponse> productos) {
        this.productos = productos;
    }

    public List<ComentarioResponse> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioResponse> comentarios) {
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

    public List<CuponResponse> getCupones() {
        return cupones;
    }

    public void setCupones(List<CuponResponse> cupones) {
        this.cupones = cupones;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
    
    

}
