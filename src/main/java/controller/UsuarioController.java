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
            this.setTipoDeUsuario(usuario.getTipoDeUsuario());
                switch (usuario.getTipoDeUsuario()){
                    case "Admin":
                        return "admin.xhtml";
                    case "Cliente":
                        return "cliente.xhtml";
                    case "Respaldo":
                        return "respaldo.xhtml";
                 }
        } else {   
        }
        return "index.xhtml";
        }
}
        

