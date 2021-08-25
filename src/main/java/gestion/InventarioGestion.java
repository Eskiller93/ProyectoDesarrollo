
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
        Inventario inventario = null;
        String sentencia="select * from inventario where modeloSKU=?";
        PreparedStatement consulta;
        try {
            consulta = Conexion.getConexion().prepareStatement(sentencia);            
            consulta.setString(1,modeloSKU);
            ResultSet info = consulta.executeQuery();
            if (info.next()) { 
                inventario = new Inventario(
                        info.getString(1),
                        info.getInt(2),
                        info.getString(3)
                );
                String test1 = info.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return inventario;
    }
}
