package controller;

import gestion.ArticuloGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Articulo;


@Named(value = "articuloController")
@SessionScoped
public class ArticuloController extends Articulo implements Serializable {


    public ArticuloController() {
    }
    
    public List<Articulo> getBrazalete() {
        return ArticuloGestion.getArticulos();
    }
        
    public String modifica(){ 
        if (ArticuloGestion.modificar(this)){
            return "articulos.xhtml";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error","Valor SKU no valido");
            FacesContext.getCurrentInstance().addMessage(
                    "editaArticuloForm:modeloSKU", mensaje);
            return "edita.xhtml";
        }
    }
    
    public String agrega() {
        if (ArticuloGestion.insertar(this)) {
            return "articulos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error","Valor SKU ya existe");
            FacesContext.getCurrentInstance().addMessage(
                    "agregaArticuloForm:modeloSKU", mensaje);
            return "agrega.xhtml";
        }
    }
    
    public String elimina() {
        if (ArticuloGestion.eliminar(this)) {
            return "articulos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error","El articulo no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaArticuloForm:modeloSKU", mensaje);            
            return "edita.xhtml";
        }
    }
    
    public String edita(String modeloSKU){
        Articulo brazalete = ArticuloGestion.getArticulo(modeloSKU);
        if (brazalete != null){ //Si lo encuentra actualizo la info
            this.setModeloSKU(brazalete.getModeloSKU());
            this.setMarca(brazalete.getMarca());
            this.setTallasDisponibles(brazalete.getTallasDisponibles());
            this.setPrecio(brazalete.getPrecio());
            this.setDetalle(brazalete.getDetalle());
            this.setCantidad(brazalete.getCantidad());
            this.setUbicacion(brazalete.getUbicacion());
            return "edita.xhtml";
        }else{ //Si no estuviera el estudiante
            return "articulos.xhtml";
        }
    }
    
    public String agregar(){
        this.setModeloSKU("");
        this.setMarca("");
        this.setTallasDisponibles("");
        this.setPrecio(0);
        this.setDetalle("");
        this.setCantidad(0);
        this.setUbicacion("");
        return "agrega.xhtml";
    }
}
