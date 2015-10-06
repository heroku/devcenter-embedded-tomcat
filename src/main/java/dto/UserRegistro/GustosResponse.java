
package dto.UserRegistro;


public class GustosResponse {
        
    private int idCategoria;
    private String nombre;
    private String url;

    public GustosResponse(int idCategoria, String nombre, String url) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.url = url;
    }

    public GustosResponse() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    

    
}
