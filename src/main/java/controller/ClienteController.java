package controller;

import gestion.ClienteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Cliente;
@Named(value = "clienteController")
@SessionScoped
public class ClienteController extends Cliente implements Serializable {

    public ClienteController() {
    }
    
    public List<Cliente> getClientes() {
        return ClienteGestion.getClientes();
    }
    
      public String edita(String idCliente) {
        Cliente cliente = ClienteGestion.getCliente(idCliente);
        if (cliente!=null) {  //Si lo encuantra actualizo la info
            this.setIdCliente(cliente.getIdCliente());
            this.setNombre(cliente.getNombre());
            this.setApellido1(cliente.getApellido1());
            this.setApellido2(cliente.getApellido2());
            this.setCorreo(cliente.getCorreo());
            this.setCelular(cliente.getCelular());
            this.setEdad(cliente.getEdad());
            this.setGenero(cliente.getGenero());
            return "edita.xhtml";
        } else {  //Por alguna razón no esta el estudiante...
            return "lista.xhtml";
        }
    }
       public String agrega() {
        if (ClienteGestion.insertar(this)) {
            return "lista.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Atencion","Este campo es requerido");
            FacesContext.getCurrentInstance().addMessage(
                    "agregaClienteForm:idCliente", mensaje);
            return "agrega.xhtml";
        }
    }
      
       public String modificar(){ 
        if (ClienteGestion.modificar(this)){
            return "lista.xhtml";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error","Informacion no valida");
            FacesContext.getCurrentInstance().addMessage(
                    "editaClienteForm:idCliente", mensaje);
            
            return "edita.xhtml";
        }
    }
       
    public String eliminar() {
        if (ClienteGestion.eliminar(this)) {
            return "lista.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error","El Cliente no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaClienteForm:idCliente", mensaje);            
            return "edita.xhtml";
        }
    }
    
    public String agregar(){
        this.setIdCliente("");
        this.setNombre("");
        this.setApellido1("");
        this.setApellido2("");
        this.setCorreo("");
        this.setCelular("");
        this.setEdad("");
        this.setGenero("");
        return "agrega.xhtml";
    }
}
//publica
//6LcDbxgcAAAAANHMnKfG0FtVaON_YoIgVtFdYjoT


//privada
//6LcDbxgcAAAAAKZ3zBq5KL6DTVDlTuAG9zXtDPwU