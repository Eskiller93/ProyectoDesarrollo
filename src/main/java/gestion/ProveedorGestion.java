package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Proveedor;

public class ProveedorGestion {
    public static ArrayList<Proveedor> getProveedor() {
        ArrayList<Proveedor> lista = new ArrayList<>();
        
        String sentencia = "Select * from proveedores";
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);
            ResultSet datos = consulta.executeQuery();
            
            while (datos.next()) {  //mientras se pueda avanzar...
                lista.add(new Proveedor(
                        datos.getString(1), //idProveedor
                        datos.getString(2), //Nombre Empresa
                        datos.getString(3), //direccion
                        datos.getString(4), //correo
                        datos.getString(5), //telefono
                        datos.getString(6))); //tipo de servicio
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public static Proveedor getProveedor(String idProveedor) {
        Proveedor proveedor = null;
        String sentencia = "Select * from proveedores where idProveedor=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, idProveedor);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {  //mientras se pueda avanzar...
                proveedor = new Proveedor(
                        datos.getString(1), //idProveedor
                        datos.getString(2), //nombre de empresa
                        datos.getString(3), //direccion
                        datos.getString(4), //correo
                        datos.getString(5), //telefono
                        datos.getString(6)); //tiposervicio
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
    }
    
}
