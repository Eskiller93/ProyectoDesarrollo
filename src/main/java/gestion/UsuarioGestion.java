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
            "select nombre,apellido,tipodeusuario from usuarios where usuario=? and contrasena=md5(?)";
    
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
                        info.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return usuario;
    }
}
