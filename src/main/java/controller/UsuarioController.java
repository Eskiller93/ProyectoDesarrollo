package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Usuario;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    public UsuarioController() {
    }
    
    public String valida() { 
        Usuario usuario = UsuarioGestion.valida(this.getUsuario(),this.getContrasena());
        if (usuario != null) {   //Se autenticó
            this.setNombre(usuario.getNombre());
            this.setApellido(usuario.getApellido());
            this.setTipoDeUsuario(usuario.getTipoDeUsuario());
            return "principal.xhtml";
        } else {
            return "index.xhtml";
        }
    }
}
        

