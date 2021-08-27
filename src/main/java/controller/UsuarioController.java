package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    public UsuarioController() {
    }
    
    public String valida() { 
        Usuario usuario = UsuarioGestion.valida(this.getUsuario(),this.getContrasena());
        if (usuario != null) {   //Se autenticó
            this.setActivo(usuario.isActivo());
            if (usuario.isActivo()){
                this.setNombre(usuario.getNombre());
                this.setApellido(usuario.getApellido());
                this.setTipoDeUsuario(usuario.getTipoDeUsuario());
                return "principal.xhtml";
            }else{
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error","Usuario Inactivo");
                FacesContext.getCurrentInstance().addMessage(
                        "loginForm:usuario", mensaje);
                return "index.xhtml";
            }
        } else {
            return "index.xhtml";
        }
    }
    public String cambioPW(){
        if(this.getContrasena().equals(this.getContrasena()) ){
        if (UsuarioGestion.modificarPW(this)) {
            return "index.xhtml";
        } else {
            FacesMessage mensaje = 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error","Cambio no permitido");
            FacesContext.getCurrentInstance().addMessage(
                    "CambioForm:Usuario", mensaje);            
            return "cambiopasswd.xhtml";
        }
        }else{
            return "index.xhtml";
        }
    }
    public String agrega() {
        if (this.getTipoDeUsuario().equalsIgnoreCase("Administrador")){
        if (UsuarioGestion.insertar(this)) {
            return "index.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Atencion","Este campo es requerido");
            FacesContext.getCurrentInstance().addMessage(
                    "agregaUsuarioForm:usuario", mensaje);
            return "agrega.xhtml";
        }
        }else {
            return "index.xhtml";
        }
    }
}
