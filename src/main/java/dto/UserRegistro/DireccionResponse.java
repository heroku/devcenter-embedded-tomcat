
package dto.UserRegistro;


public class DireccionResponse {

    private float latitud;
    private float longitud;

    public DireccionResponse(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public DireccionResponse() {
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
