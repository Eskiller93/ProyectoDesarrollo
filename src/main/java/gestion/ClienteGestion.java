package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Conexion;

public class ClienteGestion {
     public static ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sentencia = "Select * from clientes";
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);
            ResultSet datos = consulta.executeQuery();
            
            while (datos.next()) {  //mientras se pueda avanzar...
                lista.add(new Cliente(
                        datos.getString(2), //idCliente
                        datos.getString(3), //nombre
                        datos.getString(4), //apellido1
                        datos.getString(5), //apellido2
                        datos.getString(6), //correo
                        datos.getString(7), //celular
                        datos.getString(8), //edad
                        datos.getString(9)));//genero
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        //agregar un cliente
      public static boolean insertar(Cliente cliente) {
        String sentencia = "insert into clientes "
                + "(idCliente,nombre,apellido1,apellido2,correo,celular,edad,genero)"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, cliente.getIdCliente());//cedula
            consulta.setString(2, cliente.getNombre());//nombre
            consulta.setString(3, cliente.getApellido1());//apellido1
            consulta.setString(4, cliente.getApellido2());//apellido2
            consulta.setString(5, cliente.getCorreo());//correo
            consulta.setString(6, cliente.getCelular());//celular
            consulta.setString(7, cliente.getEdad());//edad
            consulta.setString(8, "" + cliente.getGenero());//genero
            return consulta.executeUpdate() > 0;  //retorna true si logra inserta o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
      //modificar un cliente
      public static boolean modificar(Cliente cliente) {
        String sentencia = "update clientes set nombre=?,apellido1=?,apellido2=?,correo=?,celular=?"
                + ",edad=?,genero=? where idCliente=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getApellido1());
            consulta.setString(3, cliente.getApellido2());
            consulta.setString(4, cliente.getCorreo());
            consulta.setString(5, cliente.getCelular());
            consulta.setString(6, cliente.getEdad());
            consulta.setString(7, "" + cliente.getGenero());
            consulta.setString(8, cliente.getIdCliente());
            return consulta.executeUpdate() > 0;  //retorna true si logra modificar o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
      
      //eliminar un cliente
      public static boolean eliminar(Cliente cliente) {
        String sentencia = "delete from clientes where idCliente=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, cliente.getIdCliente());
            return consulta.executeUpdate() > 0;  //retorna true si logra eliminar o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
      //buscar un cliente
      public static Cliente getCliente(String idCliente) {
        Cliente cliente = null;
        String sentencia = "Select * from clientes where idCliente=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, idCliente);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {  //mientras se pueda avanzar...
                cliente = new Cliente(
                        datos.getString(2), //idCliente
                        datos.getString(3), //nombre
                        datos.getString(4), //apellido1
                        datos.getString(5), //apellido2
                        datos.getString(6), //correo
                        datos.getString(7), //celular
                        datos.getString(8), //edad
                        datos.getString(9));//genero
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}
