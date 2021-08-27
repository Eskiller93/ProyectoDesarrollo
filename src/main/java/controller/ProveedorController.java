package controller;


import gestion.ProveedorGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.Proveedor;

@Named(value = "proveedorController")
@SessionScoped
public class ProveedorController extends Proveedor implements Serializable {

    public ProveedorController() {
    }
      public List<Proveedor> getProveedor() {
        return ProveedorGestion.getProveedor();
    }
    public String generarQr(String idProveedor) {
        Proveedor proveedor = ProveedorGestion.getProveedor(idProveedor);
        if (proveedor!=null) {  //Si lo encuantra actualizo la info
            this.setIdProveedor(proveedor.getIdProveedor());
            this.setNombreEmpresa(proveedor.getNombreEmpresa());
            this.setDireccion(proveedor.getDireccion());
            this.setCorreo(proveedor.getCorreo());
            this.setTelefono(proveedor.getTelefono());
            this.setTipoServicio(proveedor.getTipoServicio());
            return "confirmacion.xhtml";
        } else {  //Por alguna razón no esta el estudiante...
            return "list.xhtml";
        }
    }
}
