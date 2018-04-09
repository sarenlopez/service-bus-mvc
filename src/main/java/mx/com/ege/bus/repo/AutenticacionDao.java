package mx.com.ege.bus.repo;

import mx.com.ege.bus.domain.Respuesta1;
import mx.com.ege.bus.domain.Respuesta2;
import mx.com.ege.bus.domain.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacionDao {
	
	public Respuesta2 existeUsuario(String correo, String contrasena);
	
	public Respuesta1 insertaOlvidoContrasena(String correo);
	
	public Usuario consultaUsuarioAsesor(String correo);
	
	public Usuario consultaUsuario(String correo);
	
	public Respuesta1 insertaUsuario(String correo, String contrasena, int tipoUsuario, String nombre, String apPaterno, String apMaterno, String telefonoMovil, String telefonoFijo, String correoAsesor, String fotoPerfil );

}
