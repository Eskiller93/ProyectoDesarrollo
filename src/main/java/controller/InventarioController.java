package controller;

import gestion.InventarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Inventario;

@Named(value = "inventarioController")
@SessionScoped
public class InventarioController extends Inventario implements Serializable {

    public InventarioController() {
    }
        private boolean noImprimir=true;
    public boolean isNoImprimir() {
        return noImprimir;
    }
    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }    
    public void buscaUbicacion(String modeloSKU) {
        Inventario inventario = InventarioGestion.getInventario(modeloSKU);
        if (inventario!=null) {
            this.setModeloSKU(inventario.getModeloSKU());
            this.setCantidad(inventario.getCantidad());
            this.setUbicacion(inventario.getUbicacion());
            noImprimir=false;
        } else {            
            this.setModeloSKU("");
            this.setCantidad(0);
            this.setUbicacion("");
            FacesMessage mensaje=new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Error","SKU no encontrado...");
            FacesContext.getCurrentInstance().addMessage(
                    "inventarioForm:modeloSKU", mensaje);
            noImprimir=true;
        }        
    }
}
