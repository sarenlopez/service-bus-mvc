package mx.com.ege.bus.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import mx.com.ege.bus.domain.Respuesta1;
import mx.com.ege.bus.domain.Respuesta2;
import mx.com.ege.bus.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AutenticacionDaoImpl implements AutenticacionDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Respuesta2 existeUsuario(String correo, String contrasena) {
		
		final String procedureCall = "{call SP_AUT_EXISTE_USUARIO(?, ?, ?, ?, ?, ?)}";
		Connection connection = null;
		Respuesta2 respuesta2 = new Respuesta2();
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);
			callableSt.setString(2, contrasena);
			callableSt.registerOutParameter(3, Types.INTEGER);
			callableSt.registerOutParameter(4, Types.VARCHAR);
			callableSt.registerOutParameter(5, Types.VARCHAR);
			callableSt.registerOutParameter(6, Types.VARCHAR);

			callableSt.executeUpdate();
			
			System.out.println("Estatus GetExistUser:" + callableSt.getInt(3));
			respuesta2.setStatus(callableSt.getInt(3));
			//Si existe usuario/contrasena se asigna valor de nombre y apellido paterno
			if(callableSt.getInt(3) == 0){
				Usuario usuario = new Usuario();
				usuario.setVcNombre(callableSt.getString(5));
				usuario.setVcApellidoPaterno(callableSt.getString(6));
				respuesta2.setUsuario(usuario);
			}else{
				respuesta2.setErrorDesc(callableSt.getString(4));
			}
			
			return respuesta2;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@Override
	public Respuesta1 insertaOlvidoContrasena(String correo) {
		final String procedureCall = "{call SP_AUT_OLVIDO_CONTRASENA(?, ?, ?)}";
		Connection connection = null;
		try{
			Respuesta1 respuesta1 = new Respuesta1();
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);
			callableSt.registerOutParameter(2, Types.INTEGER);
			callableSt.registerOutParameter(3, Types.VARCHAR);

			callableSt.executeUpdate();
			
			System.out.println("EstatusTran:" + callableSt.getInt(2));
			System.out.println("DescripcionTran:" + callableSt.getString(3));
			respuesta1.setStatus(callableSt.getInt(2));
			respuesta1.setErrorDesc(callableSt.getString(3));
			return respuesta1;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	@Override
	public Usuario consultaUsuarioAsesor(String correo) {
		final String procedureCall = "{call SP_AUT_CONSULTA_USUARIO_ASESOR(?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);

			resultSet = callableSt.executeQuery();
			Usuario usuario = new Usuario();
			while(resultSet.next()){
				usuario.setVcCorreo(resultSet.getString(1));
				usuario.setnTipoUsuarioId(resultSet.getInt(2));
				usuario.setVcNombre(resultSet.getString(3));
				usuario.setVcApellidoPaterno(resultSet.getString(4));
				usuario.setVcApellidoMaterno(resultSet.getString(5));
				usuario.setVcTelefonoMovil(resultSet.getString(6));
				usuario.setVcTelefonoFijo(resultSet.getString(7));
				usuario.setdFechaAlta(resultSet.getDate(8));
				usuario.setbActivo(resultSet.getString(9));
			}
			
			return usuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@Override
	public Usuario consultaUsuario(String correo) {
		final String procedureCall = "{call SP_AUT_CONSULTA_USUARIO(?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);

			resultSet = callableSt.executeQuery();
			Usuario usuario = new Usuario();
			while(resultSet.next()){
				usuario.setVcCorreo(resultSet.getString(1));
				usuario.setnTipoUsuarioId(resultSet.getInt(2));
				usuario.setVcTipoUsuarioNombre(resultSet.getString(3));
				usuario.setVcNombre(resultSet.getString(4));
				usuario.setVcApellidoPaterno(resultSet.getString(5));
				usuario.setVcApellidoMaterno(resultSet.getString(6));
				usuario.setVcTelefonoMovil(resultSet.getString(7));
				usuario.setVcTelefonoFijo(resultSet.getString(8));
				usuario.setVcFechaAlta(resultSet.getString(9));
				usuario.setbActivo(resultSet.getString(10));
				usuario.setVcCorreoAsesor(resultSet.getString(11));
				usuario.setBlFotoPerfil(resultSet.getString(12));
			}
			return usuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;	
	}
	
	@Override
	public Respuesta1 insertaUsuario(String correo, String contrasena, int tipoUsuario, String nombre, String apPaterno, String apMaterno,
			String telefonoMovil, String telefonoFijo, String correoAsesor,String fotoPerfil) {

		final String procedureCall = "{call SP_AUT_INSERTA_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try{
			Respuesta1 respuesta1 = new Respuesta1();
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);
			callableSt.setString(2, contrasena);
			callableSt.setInt(3, tipoUsuario);
			callableSt.setString(4, nombre);
			callableSt.setString(5, apPaterno);
			callableSt.setString(6, apMaterno);
			callableSt.setString(7, telefonoMovil);
			callableSt.setString(8, telefonoFijo);
			callableSt.setString(9, correoAsesor);
			callableSt.setString(10, fotoPerfil);
			
			callableSt.registerOutParameter(11, Types.INTEGER);
			callableSt.registerOutParameter(12, Types.VARCHAR);

			callableSt.executeUpdate();
			
			System.out.println("EstatusTran:" + callableSt.getInt(11));
			System.out.println("DescripcionTran:" + callableSt.getString(12));
			respuesta1.setStatus(callableSt.getInt(11));
			respuesta1.setErrorDesc(callableSt.getString(12));
			return respuesta1;			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
