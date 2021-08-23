package controller;

import gestion.ArticuloGestion;
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
}
        

