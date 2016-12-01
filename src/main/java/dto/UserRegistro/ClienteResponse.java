

package dto.UserRegistro;

import java.util.List;

public class ClienteResponse {

    private int id_Cliente;
    private String nombres;
    private String usuario;
    private String password;
    private String email;
    private List<GustosResponse> gustos;

    public ClienteResponse() {
    }

    public ClienteResponse(int id_Cliente, String nombres, String usuario, String password, String email) {
        this.id_Cliente = id_Cliente;
        this.nombres = nombres;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GustosResponse> getGustos() {
        return gustos;
    }

    public void setGustos(List<GustosResponse> gustos) {
        this.gustos = gustos;
    }
    
    
    

}