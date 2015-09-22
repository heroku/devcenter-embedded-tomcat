package dto.UserRegistro;

import java.io.Serializable;

public class UsuarioResponse implements Serializable{

    private String msgStatus;
    private String msgError;
    private String urlCallback;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String msgStatus, String msgError, String urlCallback) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.urlCallback = urlCallback;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getUrlCallback() {
        return urlCallback;
    }

    public void setUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
    }
}
