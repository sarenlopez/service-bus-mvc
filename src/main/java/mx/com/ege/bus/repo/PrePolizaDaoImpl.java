package mx.com.ege.bus.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import mx.com.ege.bus.domain.Respuesta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PrePolizaDaoImpl implements PrePolizaDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Respuesta1 insertaPrePoliza(String correo, int origenPoliza,String imagenPoliza) {
		final String procedureCall = "{call SP_POL_INSERTA_PRE_POLIZA(?,?,?,?,?)}";
		Connection connection = null;
		Respuesta1 respuesta1 = new Respuesta1();
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);
			callableSt.setInt(2, origenPoliza);
			callableSt.setString(3, imagenPoliza);

			callableSt.registerOutParameter(4, Types.INTEGER);
			callableSt.registerOutParameter(5, Types.VARCHAR);

			callableSt.executeUpdate();
			
			respuesta1.setStatus(callableSt.getInt(4));
			if(respuesta1.getStatus() != 0){
				respuesta1.setErrorDesc(callableSt.getString(5));
			}
				
			System.out.println("Estatus:" + respuesta1.getStatus() );
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
