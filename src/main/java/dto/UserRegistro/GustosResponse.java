
package dto.UserRegistro;

public class GustosResponse {

    private int id_Categoria;
    private String nombre;
    private String foto;

    public GustosResponse(int id_Categoria, String nombre, String foto) {
        this.id_Categoria = id_Categoria;
        this.nombre = nombre;
        this.foto = foto;
    }

    public GustosResponse() {
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
