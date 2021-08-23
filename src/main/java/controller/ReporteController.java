package controller;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Named(value = "reporteController")
@SessionScoped
public class ReporteController implements Serializable {

    public ReporteController() {
    }

    public void reporteClientes() {
        try {
            //Busco la definición del reporte... queda en "jasper"
            File jasper = new File(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRealPath("/cliente/reporteCLiente.jasper"));
            
            
            //Genero un reporte a partir de la definición "jasper" y de la conexión a la BD
            JasperPrint reporteJasper = JasperFillManager.fillReport(
                    jasper.getPath(),
                    null,
                    Conexion.getConexion());
            
            //Se genera una página de respuesta del servidor web
            HttpServletResponse respuesta =
                    (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();
            
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type","application/pdf");
            
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            
            FacesContext.getCurrentInstance().responseComplete();            
            
        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
}
