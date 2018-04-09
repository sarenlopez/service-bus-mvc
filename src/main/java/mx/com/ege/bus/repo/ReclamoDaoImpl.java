package mx.com.ege.bus.repo;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReclamoDaoImpl implements ReclamoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int insertaReclamo(String tipoReclamoDesc, String numSiniestro, int empresa, int contratante, int aseguradora, String poliza, int certificado) {
		final String procedureCall = "{call SP_REC_INSERTA_RECLAMO(?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, tipoReclamoDesc);
			callableSt.setString(2, numSiniestro);
			callableSt.setInt(3, empresa);
			callableSt.setInt(4, contratante);
			callableSt.setInt(5, aseguradora);
			callableSt.setString(6, poliza);
			callableSt.setInt(7, certificado);

			callableSt.registerOutParameter(8, Types.INTEGER);

			callableSt.executeUpdate();
			int reclamoId = callableSt.getInt(8);
			System.out.println("ReclamoId:" + callableSt.getInt(8));
			return reclamoId;			
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
		return 0;
	}
	
	@Override
	public boolean insertaReclamoDocto(int tipoReclamoId, int reclamoId, String archivoNombre, String archivo) {
		final String procedureCall = "{call SP_REC_INSERTA_RECLAMO_DOCTO(?,?,?,?,?)}";
		Connection connection = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, reclamoId);
			callableSt.setInt(2, tipoReclamoId);
			callableSt.setString(3, archivoNombre);
			callableSt.setString(4, archivo);

			callableSt.executeUpdate();
			
			boolean status = callableSt.getInt(5) == 0?true:false;
			return status;
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
		return false;
	}
	

	

}
