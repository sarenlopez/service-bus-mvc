package mx.com.ege.bus.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import mx.com.ege.bus.domain.Cotizacion;
import mx.com.ege.bus.domain.CotizacionCatalogo;
import mx.com.ege.bus.domain.CotizacionMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CotizacionDaoImpl implements CotizacionDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CotizacionMap> consultaMapCotizacion(int tipoPoliza) {
		final String procedureCall = "{call SP_COT_CONSULTA_COTIZACION_MAP(?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, tipoPoliza);

			resultSet = callableSt.executeQuery();
			List<CotizacionMap> listaCotizacionMap = new ArrayList<CotizacionMap>();
			while(resultSet.next()){
				CotizacionMap cotizacionMap = new CotizacionMap();
				cotizacionMap.setnTipoPolizaId(resultSet.getInt(1));
				cotizacionMap.setnMapCampoId(resultSet.getInt(2));
				cotizacionMap.setVcMapNombreCampo(resultSet.getString(3));
				cotizacionMap.setVcTipoCampo(resultSet.getString(4));
				cotizacionMap.setVcCatalogo(resultSet.getString(5));
				cotizacionMap.setVcMapTexto(resultSet.getString(6));
				cotizacionMap.setnOrden(resultSet.getInt(7));
				cotizacionMap.setbActivo(resultSet.getString(8));
				cotizacionMap.setVcTextoDefecto(resultSet.getString(9));
				
				listaCotizacionMap.add(cotizacionMap);
			}
			return listaCotizacionMap;			
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
	public List<CotizacionCatalogo> consultaCatalogo(String nombreTabla) {
		final String procedureCall = "{call SP_COT_CONSULTA_COTIZACION_CATALOGO(?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, nombreTabla);

			resultSet = callableSt.executeQuery();
			List<CotizacionCatalogo> listaCotizacionCat = new ArrayList<CotizacionCatalogo>();
			while(resultSet.next()){
				CotizacionCatalogo cotizacionCat = new CotizacionCatalogo();
				cotizacionCat.setIdentificador(resultSet.getInt(1));
				cotizacionCat.setDescripcion(resultSet.getString(2));
				cotizacionCat.setActivo(resultSet.getString(3));				
				listaCotizacionCat.add(cotizacionCat);
			}
			return listaCotizacionCat;			
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
	public boolean insertaCotizacion(Cotizacion cotizacion) {
		final String procedureCall = "{call SP_COT_INSERTA_SOLICITUD_COTIZACION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, cotizacion.getnTipoPolizaId());
			callableSt.setString(2, cotizacion.getVcCorreo());			
			callableSt.setString(3, cotizacion.getVcCampo1());
			callableSt.setString(4, cotizacion.getVcCampo2());
			callableSt.setString(5, cotizacion.getVcCampo3());
			callableSt.setString(6, cotizacion.getVcCampo4());
			callableSt.setString(7, cotizacion.getVcCampo5());
			callableSt.setString(8, cotizacion.getVcCampo6());
			callableSt.setString(9, cotizacion.getVcCampo7());
			callableSt.setString(10, cotizacion.getVcCampo8());
			callableSt.setString(11, cotizacion.getVcCampo9());
			callableSt.setString(12, cotizacion.getVcCampo10());
			callableSt.setString(13, cotizacion.getVcCampo11());
			callableSt.setString(14, cotizacion.getVcCampo12());
			callableSt.setString(15, cotizacion.getVcCampo13());
			callableSt.setString(16, cotizacion.getVcCampo14());
			callableSt.setString(17, cotizacion.getVcCampo15());
			callableSt.setString(18, cotizacion.getVcCampo16());
			callableSt.setString(19, cotizacion.getVcCampo17());
			callableSt.setString(20, cotizacion.getVcCampo18());
			callableSt.setString(21, cotizacion.getVcCampo19());
			callableSt.setString(22, cotizacion.getVcCampo20());
			
			callableSt.registerOutParameter(23, Types.INTEGER);

			callableSt.executeUpdate();
			
			System.out.println("EstatusTran:" + callableSt.getInt(23));
			boolean status = callableSt.getInt(23) == 0?true:false;
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
