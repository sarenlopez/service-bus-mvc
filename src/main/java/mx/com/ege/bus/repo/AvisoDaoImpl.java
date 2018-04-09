package mx.com.ege.bus.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.com.ege.bus.domain.Aviso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AvisoDaoImpl implements AvisoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Aviso> consultaAvisos(String correo) {
		final String procedureCall = "{call SP_AVI_CONSULTA_AVISOS(?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, correo);
			
			resultSet = callableSt.executeQuery();
			List<Aviso> listaAviso = new ArrayList<Aviso>();
			
			while(resultSet.next()){				
				Aviso aviso = new Aviso();
				aviso.setnAvisoId(resultSet.getInt(1));
				aviso.setnEmpresaId(resultSet.getInt(2));
				aviso.setnTipoAvisoId(resultSet.getInt(3));
				aviso.setVcCorreo(resultSet.getString(4));
				aviso.setVcTitulo(resultSet.getString(5));
				aviso.setVcTexto(resultSet.getString(6));
				aviso.setdFechaAlta(resultSet.getDate(7));
				aviso.setdFechaVer(resultSet.getDate(8));
				aviso.setbActivo(resultSet.getString(9));
				listaAviso.add(aviso);
			}
			return listaAviso;			
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
