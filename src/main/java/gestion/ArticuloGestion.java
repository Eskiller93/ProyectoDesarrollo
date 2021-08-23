package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Articulo;
import model.Conexion;

public class ArticuloGestion {
    public static ArrayList<Articulo> getArticulos() {
        ArrayList<Articulo> lista = new ArrayList<>();

        String sentencia = "Select * from articulos";

        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);

            ResultSet datos = consulta.executeQuery();
            while (datos.next()) { //mientras se pueda avanzar...
                    lista.add(new Articulo(
                    datos.getString(2), //modeloSKU
                    datos.getString(3), //marca
                    datos.getString(4), //tallasDisponibles
                    datos.getInt(5), //precio
                    datos.getString(6), //detalle 
                    datos.getInt(7), //cantidad 
                    datos.getString(8) //ubicacion 
                    ));    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
    public static Articulo getArticulo(String modeloSKU) {
        Articulo articulo = null;
        String sentencia = "Select * from articulos where modeloSKU  = ?";

        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);
            consulta.setString(1, modeloSKU);
            ResultSet datos = consulta.executeQuery();
            while (datos.next()) { //mientras se pueda avanzar...
                    articulo =new Articulo(
                    datos.getString(2), //modeloSku
                    datos.getString(3), //marca
                    datos.getString(4), //tallasDisponibles
                    datos.getInt(5), //precio
                    datos.getString(6), //detalle 
                    datos.getInt(7), //cantidad 
                    datos.getString(8) //ubicacion      
                    ); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulo;
    }
        
    public static boolean modificar(Articulo articulo){
        //Sentencia para modificar un articulo
        String sentencia ="update articulos set marca=?,tallasDisponibles=?,precio=?, detalle=?, cantidad=?, ubicacion=? where modeloSKU =?";
        
        try {  
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);
            
            consulta.setString(1, articulo.getMarca());
            consulta.setString(2, articulo.getTallasDisponibles());
            consulta.setInt(3, articulo.getPrecio());
            consulta.setString(4, articulo.getDetalle());
            consulta.setInt(5, articulo.getCantidad());
            consulta.setString(6, articulo.getUbicacion());
            consulta.setString(7, articulo.getModeloSKU());

            return consulta.executeUpdate()>0;// retorna true si logra modificar los datos
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean insertar(Articulo articulo) {
        //Sentencia para insertar un articulo
        String sentencia = "insert into articulos (modeloSKU, marca, tallasDisponibles, precio, detalle, cantidad, ubicacion) "
                + "values (?           ,?        ,?        ,?        ,?        ,?        ,?)";
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);
            
            consulta.setString(1, articulo.getModeloSKU());
            consulta.setString(2, articulo.getMarca());
            consulta.setString(3, articulo.getTallasDisponibles());
            consulta.setInt(4, articulo.getPrecio());
            consulta.setString(5, articulo.getDetalle());
            consulta.setInt(6, articulo.getCantidad());
            consulta.setString(7,articulo.getUbicacion());
            
            return consulta.executeUpdate() > 0;  //retorna true si logra inserta o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean eliminar(Articulo articulo) {
        //Sentencia para eliminar un articulo
        String sentencia = "delete from articulos where modeloSKU  = ?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, articulo.getModeloSKU());
            return consulta.executeUpdate() > 0;  //retorna true si logra eliminar o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
