

package dto.UserRegistro;

public class ClienteResponse {

    private int idCliente;
    private String nombre;
    private String usuario;
    private String password;
    private String email;

    public ClienteResponse() {
    }

    public ClienteResponse(int idCliente, String nombre, String usuario, String password, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


}