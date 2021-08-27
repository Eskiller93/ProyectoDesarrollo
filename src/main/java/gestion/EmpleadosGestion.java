
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Empleados;


public class EmpleadosGestion {
    public static ArrayList<Empleados> getEmpleados() {
        ArrayList<Empleados> listas = new ArrayList<>();
        
        String sentencia = "Select * from empleados";
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sentencia);
            ResultSet datos = consulta.executeQuery();
            
            while (datos.next()) {  //mientras se pueda avanzar...
                listas.add(new Empleados(
                        datos.getString(2), //idEmpleado
                        datos.getString(3), //nombre
                        datos.getString(4), //apellido
                        datos.getString(5), //cargo laboral
                        datos.getString(6), //salario
                        datos.getString(7)));//genero
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listas;
    }
    
     //agregar un nuevo empleado
      public static boolean insertar(Empleados empleados) {
        String sentencia = "insert into empleados "
                + "(idEmpleado,nombre,apellido,cargoLaboral,salario,genero)"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, empleados.getIdEmpleado());//cedula
            consulta.setString(2, empleados.getNombre());//nombre
            consulta.setString(3, empleados.getApellido());//apellido
            consulta.setString(4, empleados.getCargoLaboral());//cargolaboral
            consulta.setString(5, empleados.getSalario());//salario
            consulta.setString(6, "" + empleados.getGenero());//genero
            return consulta.executeUpdate() > 0;  //retorna true si logra inserta o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
      //modificar un empleado
      public static boolean modificar(Empleados empleados) {
        String sentencia = "update empleados set nombre=?,apellido=?,cargoLAboral=?,salario=?"
                + ",genero=? where idEmpleado=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, empleados.getNombre());
            consulta.setString(2, empleados.getApellido());
            consulta.setString(3, empleados.getCargoLaboral());
            consulta.setString(4, empleados.getSalario());
            consulta.setString(5, "" + empleados.getGenero());
            consulta.setString(6, empleados.getIdEmpleado());
            return consulta.executeUpdate() > 0;  //retorna true si logra modificar o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
      
      //eliminar un empleado
      public static boolean eliminar(Empleados empleados) {
        String sentencia = "delete from clientes where idEmpleado=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, empleados.getIdEmpleado());
            return consulta.executeUpdate() > 0;  //retorna true si logra eliminar o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
      //buscar un empleado
      public static Empleados getEmpleados(String idEmpleado) {
        Empleados empleados = null;
        String sentencia = "Select * from empleados where idEmpleado=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, idEmpleado);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {  //mientras se pueda avanzar...
                empleados = new Empleados(
                        datos.getString(2), //idCliente
                        datos.getString(3), //nombre
                        datos.getString(4), //apellido
                        datos.getString(5), //cargolaboral
                        datos.getString(6), //salario
                        datos.getString(7));//genero
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
      
      public static Empleados getConstancia(String idEmpleado) {
        Empleados empleados = null;
        String sentencia="select * from empleados where idEmpleado=?";
        PreparedStatement consulta;
        try {
            consulta = Conexion.getConexion().prepareStatement(sentencia);            
            consulta.setString(1,idEmpleado);
            ResultSet info = consulta.executeQuery();
            if (info.next()) { 
                empleados = new Empleados(
                        info.getString(2),//id empleado
                        info.getString(3),//nombre
                        info.getString(4),//apellido
                        info.getString(5),//cargo laboral
                        info.getString(6),//salario
                        info.getString(7)//genero
                        
                );
                String test1 = info.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return empleados;
    }
}