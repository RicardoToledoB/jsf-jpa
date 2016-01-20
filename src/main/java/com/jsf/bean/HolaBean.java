package com.jsf.bean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
@Named(value = "hola")
@SessionScoped
public class HolaBean implements Serializable {
    private String mensaje="SALUDO";
    public HolaBean() {
        
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
