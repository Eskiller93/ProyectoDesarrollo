
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Inventario;

public class InventarioGestion {
    
    public static Inventario getInventario(String modeloSKU) {
        Inventario inventario=null;
        String sentencia="select * from inventario where modeloSKU=?";
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);            
            consulta.setString(1,modeloSKU);
            ResultSet info = consulta.executeQuery();
            if (info.next()) { 
                inventario= new Inventario(
                        info.getString(2),
                        info.getInt(3),
                        info.getString(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return inventario;
    }
}
