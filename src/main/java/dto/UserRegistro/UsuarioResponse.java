package dto.UserRegistro;

import java.io.Serializable;

public class UsuarioResponse implements Serializable{

    private String msgStatus;
    private String msgError;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String msgStatus, String msgError) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
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


}
