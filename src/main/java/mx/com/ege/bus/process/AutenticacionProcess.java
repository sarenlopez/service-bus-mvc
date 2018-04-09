package mx.com.ege.bus.process;

import java.nio.charset.Charset;

import mx.com.ege.bus.domain.Respuesta1;
import mx.com.ege.bus.domain.Respuesta2;
import mx.com.ege.bus.domain.Usuario;
import mx.com.ege.bus.repo.AutenticacionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class AutenticacionProcess {
	
	@Autowired
	private AutenticacionDao autenticacionDao;
	
	public String getAutenticacionProcess(String correo, String contrasena){
		System.out.println("getAutenticacionProcess...");
		try{
			System.out.println("correo:" + correo);
			System.out.println("contrasena:" + contrasena);
			Respuesta2 respuesta2 = autenticacionDao.existeUsuario(correo, contrasena);
			String json = new Gson().toJson(respuesta2);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public String doOlvidoContrasenaProcess(String correo){
		System.out.println("doOlvidoContrasenaProcess...");
		try{
			System.out.println("correo:" + correo);
			Respuesta1 respuesta1 = autenticacionDao.insertaOlvidoContrasena(correo);
			String json = new Gson().toJson(respuesta1);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getAsesorProcess(String correo){
		System.out.println("getAsesorProcess...");
		try{
			System.out.println("correo:" + correo);
			Usuario usuario = autenticacionDao.consultaUsuarioAsesor(correo);
			String json = new Gson().toJson(usuario);
			System.out.println("json:"+ json);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getUsuarioProcess(String correo){
		System.out.println("getUsuarioProcess...");
		try{
			System.out.println("correo:" + correo);
			Usuario usuario = autenticacionDao.consultaUsuario(correo);
			String json = new Gson().toJson(usuario);
			System.out.println("json:"+ json);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public String doCreaUsuario(String correo, String contrasena, int tipoUsuario, String nombre, String apPaterno, String apMaterno, 
			String telefonoMovil, String telefonoFijo, String correoAsesor, String fotoPerfil){
		System.out.println("doCreaUsuario...");
		try{
			System.out.println("correo:" + correo);
			System.out.println("tipoUsuario:" + tipoUsuario);
			System.out.println("nombre:" + nombre);
			System.out.println("apPaterno:" + apPaterno);
			System.out.println("apMaterno:" + apMaterno);
			System.out.println("telefonoMovil:" + telefonoMovil);
			System.out.println("telefonoFijo:" + telefonoFijo);
			System.out.println("correoAsesor:" + correoAsesor);
			System.out.println("fotoPerfil:" + fotoPerfil);
			
			Respuesta1 respuesta1 = autenticacionDao.insertaUsuario(correo, contrasena, tipoUsuario, nombre, apPaterno, apMaterno, 
					telefonoMovil, telefonoFijo, correoAsesor, fotoPerfil);
			String json = new Gson().toJson(respuesta1);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	

}
