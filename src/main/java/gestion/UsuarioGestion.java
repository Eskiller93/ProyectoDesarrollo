package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario;

public class UsuarioGestion {
    private static final String SQL_VALIDA=
            "select nombre,apellido,tipodeusuario,activo from usuarios where usuario=? and contrasena=md5(?)";
    
    public static Usuario valida(String idUsuario,String pwUsuario) {
        Usuario usuario=null;
        try {
            PreparedStatement sentencia=Conexion.getConexion()
                    .prepareStatement(SQL_VALIDA);
            sentencia.setString(1, idUsuario);
            sentencia.setString(2, pwUsuario);
            ResultSet info = sentencia.executeQuery();
            if (info.next()) {  //Si puedo ubicarme en el siguiente.. entonces hay datos... osea si se validó
                usuario = new Usuario(
                        idUsuario,
                        info.getString(1),
                        info.getString(2),
                        info.getString(3),
                        info.getBoolean(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return usuario;
    }
    
    public static Usuario validaCambio(String idUsuario, String clave){
     String sentencia="select nombre, activo from usuarios where usuario=? and contrseña=md5(?)";
        Usuario usuario=null;        
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, idUsuario);
            consulta.setString(2, clave);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()) {  //Si se autenticó...
                usuario = new Usuario(
                        idUsuario,
                        datos.getString(1),  //
                        datos.getBoolean(2)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    public static boolean modificarPW(Usuario usuario){
        String sentencia = "update usuarios set contrasena=? where usuario=?";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, usuario.getContrasena());
            return consulta.executeUpdate() > 0;  //retorna true si logra modificar o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean insertar(Usuario usuario) {
        String sentencia = "insert into usuarios "
                + "(usuario,contraseña,tipodeusuario,correoUsuario,nombre,apellido,activo)"
                + "values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(sentencia);
            consulta.setString(1, usuario.getUsuario());//usuario
            consulta.setString(2, usuario.getContrasena());//contrasena
            consulta.setString(3, "" + usuario.getTipoDeUsuario());//tipodeusuario
            consulta.setString(4, usuario.getCorreoUsuario());//correodeUsuario
            consulta.setString(5, usuario.getNombre());//nombre
            consulta.setString(6, usuario.getApellido());//apellido
            consulta.setBoolean(7, usuario.isActivo());//activo
            return consulta.executeUpdate() > 0;  //retorna true si logra inserta o falso si no...
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}