package controller;

import gestion.EmpleadosGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empleados;



@Named(value = "empleadosController")
@SessionScoped
public class EmpleadosController extends Empleados implements  Serializable {

    
    public EmpleadosController() {
    }
    
     public List<Empleados> getEmpleados() {
        return EmpleadosGestion.getEmpleados();
    }
     
     public String edita(String idEmpleados) {
        Empleados empleados = EmpleadosGestion.getEmpleados(idEmpleados);
        if (empleados!=null) {  //Si lo encuantra actualizo la info
            this.setIdEmpleado(empleados.getIdEmpleado());
            this.setNombre(empleados.getNombre());
            this.setApellido(empleados.getApellido());
            this.setCargoLaboral(empleados.getCargoLaboral());
            this.setSalario(empleados.getSalario());
            this.setGenero(empleados.getGenero());
            return "edita.xhtml";
        } else {  //Por alguna razón no esta el estudiante...
            return "listas.xhtml";
        }
    }
     
       public String agrega() {
        if (EmpleadosGestion.insertar(this)) {
            return "listas.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Atencion","Este campo es un requisito");
            FacesContext.getCurrentInstance().addMessage(
                    "agregaEmpleadosForm:idEmpleado", mensaje);
            return "agregar.xhtml";
        }
    }
       
       public String modificar(){ 
        if (EmpleadosGestion.modificar(this)){
            return "listas.xhtml";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error","La Informacion no es valida");
            FacesContext.getCurrentInstance().addMessage(
                    "editaEmpleadosForm:idEmpleado", mensaje);
            
            return "editar.xhtml";
        }
    }
       
        public String eliminar() {
        if (EmpleadosGestion.eliminar(this)) {
            return "listas.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error","El Empleado no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaEmpleadosForm:idEmpleado", mensaje);            
            return "editar.xhtml";
        }
    }
    
    public String agregar(){
        return "agregar.xhtml";
    }
    
    public void buscaEmpleado(String idEmpleado) {
        Empleados empleados = EmpleadosGestion.getConstancia(idEmpleado);
        if (empleados!=null) {
            this.setIdEmpleado(empleados.getIdEmpleado());
            this.setNombre(empleados.getNombre());
            this.setApellido(empleados.getApellido());
            this.setCargoLaboral(empleados.getCargoLaboral());
            this.setSalario(empleados.getSalario());
            this.setGenero(empleados.getGenero());
            
        } else { 
             this.setIdEmpleado("");
            this.setNombre("");
            this.setApellido("");
            this.setCargoLaboral("");
            this.setSalario("");
            this.setGenero("");
            FacesMessage mensaje=new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Error","Cedula Incorrecta...");
            FacesContext.getCurrentInstance().addMessage(
                    "empleadosForm:idEmpleado", mensaje);
            
        }        
    }
}
