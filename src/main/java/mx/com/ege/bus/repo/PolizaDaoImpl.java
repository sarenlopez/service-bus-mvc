package mx.com.ege.bus.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.ege.bus.domain.Poliza;
import mx.com.ege.bus.domain.PolizaAseguradoAdic;
import mx.com.ege.bus.domain.PolizaMap;
import mx.com.ege.bus.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PolizaDaoImpl implements PolizaDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 @Override
	public List<Poliza> consultaPolizas(String correo, int tipoPoliza, int origenPoliza) {
			final String procedureCall = "{call SP_POL_CONSULTA_POLIZAS(?,?,?)}";
			Connection connection = null;
			ResultSet resultSet = null;
			try{
				connection = jdbcTemplate.getDataSource().getConnection();
				CallableStatement callableSt = connection.prepareCall(procedureCall);
				callableSt.setString(1, correo);
				callableSt.setInt(2, tipoPoliza);
				callableSt.setInt(3, origenPoliza);

				resultSet = callableSt.executeQuery();
				List<Poliza> listaPoliza = new ArrayList<Poliza>();
				while(resultSet.next()){
					Poliza poliza = new Poliza();
					poliza.setnEmpresaId(resultSet.getInt(1));
					poliza.setnContratanteId(resultSet.getInt(2));
					poliza.setVcPolizaId(resultSet.getString(3));
					poliza.setnCertificado(resultSet.getInt(4));
					poliza.setnProductoId(resultSet.getInt(5));
					poliza.setVcTitularNombre(resultSet.getString(6));
					poliza.setVcTitularApellidoPatern(resultSet.getString(7));
					poliza.setVcTitularApellidoMatern(resultSet.getString(8));
					poliza.setnPrima(resultSet.getBigDecimal(9));
					poliza.setdVigenciaDesde(resultSet.getDate(10));
					poliza.setdVigenciaHasta(resultSet.getDate(11));
					poliza.setnTipoPolizaId(resultSet.getInt(12));
					poliza.setVcTipoPoliza(resultSet.getString(13));
					poliza.setVcCampo1(resultSet.getString(14));
					poliza.setVcCampo2(resultSet.getString(15));
					poliza.setVcCampo3(resultSet.getString(16));
					poliza.setVcCampo4(resultSet.getString(17));
					poliza.setVcCampo5(resultSet.getString(18));
					poliza.setVcCampo6(resultSet.getString(19));
					poliza.setVcCampo7(resultSet.getString(20));
					poliza.setVcCampo8(resultSet.getString(21));
					poliza.setVcCampo9(resultSet.getString(22));
					poliza.setVcCampo10(resultSet.getString(23));
					poliza.setVcCampo11(resultSet.getString(24));
					poliza.setVcCampo12(resultSet.getString(25));
					poliza.setVcCampo13(resultSet.getString(26));
					poliza.setVcCampo14(resultSet.getString(27));
					poliza.setVcCampo15(resultSet.getString(28));
					poliza.setVcCampo16(resultSet.getString(29));
					poliza.setVcCampo17(resultSet.getString(30));
					poliza.setVcCampo18(resultSet.getString(31));
					poliza.setVcCampo19(resultSet.getString(32));
					poliza.setVcCampo20(resultSet.getString(33));
					poliza.setnStatusPolizaId(resultSet.getInt(34));
					poliza.setdFechaAlta(resultSet.getDate(35));
					poliza.setnAseguradoraId(resultSet.getInt(36));
					poliza.setBlArchivo(resultSet.getBlob(37));
					poliza.setnClasificacionPolizaId(resultSet.getInt(38));
					poliza.setVcEmpresaContratante(resultSet.getString(39));
					poliza.setnEndoso(resultSet.getInt(40));
					poliza.setdFechaAntiguedad(resultSet.getDate(41));
					poliza.setnMonedaId(resultSet.getInt(42));
					poliza.setbActivo(resultSet.getString(43));
					poliza.setnOrigenPoliza(resultSet.getInt(44));
					
					listaPoliza.add(poliza);
				}
				
				return listaPoliza;
				
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
	public List<Poliza> consultaPolizas(String correo) {
			final String procedureCall = "{call SP_POL_CONSULTA_POLIZAS_TODAS(?)}";
			Connection connection = null;
			ResultSet resultSet = null;
			try{
				Date fechaActual = DateUtil.getFechaActual();
				connection = jdbcTemplate.getDataSource().getConnection();
				CallableStatement callableSt = connection.prepareCall(procedureCall);
				callableSt.setString(1, correo);

				resultSet = callableSt.executeQuery();
				List<Poliza> listaPoliza = new ArrayList<Poliza>();
				while(resultSet.next()){
					Poliza poliza = new Poliza();
					poliza.setnEmpresaId(resultSet.getInt(1));
					poliza.setnContratanteId(resultSet.getInt(2));
					poliza.setVcPolizaId(resultSet.getString(3));
					poliza.setnCertificado(resultSet.getInt(4));
					poliza.setnProductoId(resultSet.getInt(5));
					poliza.setVcTitularNombre(resultSet.getString(6));
					poliza.setVcTitularApellidoPatern(resultSet.getString(7));
					poliza.setVcTitularApellidoMatern(resultSet.getString(8));
					poliza.setnPrima(resultSet.getBigDecimal(9));
					poliza.setdVigenciaDesde(resultSet.getDate(10));
					poliza.setdVigenciaHasta(resultSet.getDate(11));
					poliza.setnTipoPolizaId(resultSet.getInt(12));
					poliza.setVcTipoPoliza(resultSet.getString(13));
					poliza.setVcCampo1(resultSet.getString(14));
					poliza.setVcCampo2(resultSet.getString(15));
					poliza.setVcCampo3(resultSet.getString(16));
					poliza.setVcCampo4(resultSet.getString(17));
					poliza.setVcCampo5(resultSet.getString(18));
					poliza.setVcCampo6(resultSet.getString(19));
					poliza.setVcCampo7(resultSet.getString(20));
					poliza.setVcCampo8(resultSet.getString(21));
					poliza.setVcCampo9(resultSet.getString(22));
					poliza.setVcCampo10(resultSet.getString(23));
					poliza.setVcCampo11(resultSet.getString(24));
					poliza.setVcCampo12(resultSet.getString(25));
					poliza.setVcCampo13(resultSet.getString(26));
					poliza.setVcCampo14(resultSet.getString(27));
					poliza.setVcCampo15(resultSet.getString(28));
					poliza.setVcCampo16(resultSet.getString(29));
					poliza.setVcCampo17(resultSet.getString(30));
					poliza.setVcCampo18(resultSet.getString(31));
					poliza.setVcCampo19(resultSet.getString(32));
					poliza.setVcCampo20(resultSet.getString(33));
					poliza.setnStatusPolizaId(resultSet.getInt(34));
					poliza.setdFechaAlta(resultSet.getDate(35));
					poliza.setnAseguradoraId(resultSet.getInt(36));
					poliza.setBlArchivo(resultSet.getBlob(37));
					poliza.setnClasificacionPolizaId(resultSet.getInt(38));
					poliza.setVcEmpresaContratante(resultSet.getString(39));
					poliza.setnEndoso(resultSet.getInt(40));
					poliza.setdFechaAntiguedad(resultSet.getDate(41));
					poliza.setnMonedaId(resultSet.getInt(42));
					poliza.setbActivo(resultSet.getString(43));
					poliza.setnOrigenPoliza(resultSet.getInt(44));
					poliza.setFechaNotifPoliza(resultSet.getDate(45));	
					
					poliza.setVcVigenciaDesde(resultSet.getString(46));
					poliza.setVcVigenciaHasta(resultSet.getString(47));
					poliza.setVcFechaAlta(resultSet.getString(48));
					poliza.setVcFechaAntiguedad(resultSet.getString(49));					
					
					boolean esMenor = DateUtil.isInSameDayOrBefore(poliza.getFechaNotifPoliza(), poliza.getdVigenciaHasta());
					poliza.setTipoVencimiento((esMenor)?0:DateUtil.isInSameDayOrBefore(poliza.getdVigenciaHasta(), fechaActual)?1:2); 
					
					listaPoliza.add(poliza);
				}
				
				return listaPoliza;
				
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
	public List<Poliza> consultaPolizasVencidas(String correo) {
			final String procedureCall = "{call SP_POL_CONSULTA_POLIZAS_VENCIDAS(?)}";
			Connection connection = null;
			ResultSet resultSet = null;
			try{
				Date fechaActual = DateUtil.getFechaActual();
				connection = jdbcTemplate.getDataSource().getConnection();
				CallableStatement callableSt = connection.prepareCall(procedureCall);
				callableSt.setString(1, correo);

				resultSet = callableSt.executeQuery();
				List<Poliza> listaPoliza = new ArrayList<Poliza>();
				while(resultSet.next()){
					Poliza poliza = new Poliza();
					poliza.setnEmpresaId(resultSet.getInt(1));
					poliza.setnContratanteId(resultSet.getInt(2));
					poliza.setVcPolizaId(resultSet.getString(3));
					poliza.setnCertificado(resultSet.getInt(4));
					poliza.setnProductoId(resultSet.getInt(5));
					poliza.setVcTitularNombre(resultSet.getString(6));
					poliza.setVcTitularApellidoPatern(resultSet.getString(7));
					poliza.setVcTitularApellidoMatern(resultSet.getString(8));
					poliza.setnPrima(resultSet.getBigDecimal(9));
					poliza.setdVigenciaDesde(resultSet.getDate(10));
					poliza.setdVigenciaHasta(resultSet.getDate(11));
					poliza.setnTipoPolizaId(resultSet.getInt(12));
					poliza.setVcTipoPoliza(resultSet.getString(13));
					poliza.setVcCampo1(resultSet.getString(14));
					poliza.setVcCampo2(resultSet.getString(15));
					poliza.setVcCampo3(resultSet.getString(16));
					poliza.setVcCampo4(resultSet.getString(17));
					poliza.setVcCampo5(resultSet.getString(18));
					poliza.setVcCampo6(resultSet.getString(19));
					poliza.setVcCampo7(resultSet.getString(20));
					poliza.setVcCampo8(resultSet.getString(21));
					poliza.setVcCampo9(resultSet.getString(22));
					poliza.setVcCampo10(resultSet.getString(23));
					poliza.setVcCampo11(resultSet.getString(24));
					poliza.setVcCampo12(resultSet.getString(25));
					poliza.setVcCampo13(resultSet.getString(26));
					poliza.setVcCampo14(resultSet.getString(27));
					poliza.setVcCampo15(resultSet.getString(28));
					poliza.setVcCampo16(resultSet.getString(29));
					poliza.setVcCampo17(resultSet.getString(30));
					poliza.setVcCampo18(resultSet.getString(31));
					poliza.setVcCampo19(resultSet.getString(32));
					poliza.setVcCampo20(resultSet.getString(33));
					poliza.setnStatusPolizaId(resultSet.getInt(34));
					poliza.setdFechaAlta(resultSet.getDate(35));
					poliza.setnAseguradoraId(resultSet.getInt(36));
					poliza.setBlArchivo(resultSet.getBlob(37));
					poliza.setnClasificacionPolizaId(resultSet.getInt(38));
					poliza.setVcEmpresaContratante(resultSet.getString(39));
					poliza.setnEndoso(resultSet.getInt(40));
					poliza.setdFechaAntiguedad(resultSet.getDate(41));
					poliza.setnMonedaId(resultSet.getInt(42));
					poliza.setbActivo(resultSet.getString(43));
					poliza.setnOrigenPoliza(resultSet.getInt(44));
					poliza.setFechaNotifPoliza(resultSet.getDate(45));
					
					poliza.setVcVigenciaDesde(resultSet.getString(46));
					poliza.setVcVigenciaHasta(resultSet.getString(47));
					poliza.setVcFechaAlta(resultSet.getString(48));
					poliza.setVcFechaAntiguedad(resultSet.getString(49));					
					
					boolean esMenor = DateUtil.isInSameDayOrBefore(poliza.getFechaNotifPoliza(), poliza.getdVigenciaHasta());
					poliza.setTipoVencimiento((esMenor)?0:DateUtil.isInSameDayOrBefore(poliza.getdVigenciaHasta(), fechaActual)?1:2); 
					
					listaPoliza.add(poliza);
				}
				
				return listaPoliza;
				
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
	public List<Poliza> consultaPolizasAdicionales(String correo) {
			final String procedureCall = "{call SP_POL_CONSULTA_POLIZAS_ADICIONALES(?)}";
			Connection connection = null;
			ResultSet resultSet = null;
			try{
				Date fechaActual = DateUtil.getFechaActual();
				connection = jdbcTemplate.getDataSource().getConnection();
				CallableStatement callableSt = connection.prepareCall(procedureCall);
				callableSt.setString(1, correo);

				resultSet = callableSt.executeQuery();
				List<Poliza> listaPoliza = new ArrayList<Poliza>();
				while(resultSet.next()){
					Poliza poliza = new Poliza();
					poliza.setnEmpresaId(resultSet.getInt(1));
					poliza.setnContratanteId(resultSet.getInt(2));
					poliza.setVcPolizaId(resultSet.getString(3));
					poliza.setnCertificado(resultSet.getInt(4));
					poliza.setnProductoId(resultSet.getInt(5));
					poliza.setVcTitularNombre(resultSet.getString(6));
					poliza.setVcTitularApellidoPatern(resultSet.getString(7));
					poliza.setVcTitularApellidoMatern(resultSet.getString(8));
					poliza.setnPrima(resultSet.getBigDecimal(9));
					poliza.setdVigenciaDesde(resultSet.getDate(10));
					poliza.setdVigenciaHasta(resultSet.getDate(11));
					poliza.setnTipoPolizaId(resultSet.getInt(12));
					poliza.setVcTipoPoliza(resultSet.getString(13));
					poliza.setVcCampo1(resultSet.getString(14));
					poliza.setVcCampo2(resultSet.getString(15));
					poliza.setVcCampo3(resultSet.getString(16));
					poliza.setVcCampo4(resultSet.getString(17));
					poliza.setVcCampo5(resultSet.getString(18));
					poliza.setVcCampo6(resultSet.getString(19));
					poliza.setVcCampo7(resultSet.getString(20));
					poliza.setVcCampo8(resultSet.getString(21));
					poliza.setVcCampo9(resultSet.getString(22));
					poliza.setVcCampo10(resultSet.getString(23));
					poliza.setVcCampo11(resultSet.getString(24));
					poliza.setVcCampo12(resultSet.getString(25));
					poliza.setVcCampo13(resultSet.getString(26));
					poliza.setVcCampo14(resultSet.getString(27));
					poliza.setVcCampo15(resultSet.getString(28));
					poliza.setVcCampo16(resultSet.getString(29));
					poliza.setVcCampo17(resultSet.getString(30));
					poliza.setVcCampo18(resultSet.getString(31));
					poliza.setVcCampo19(resultSet.getString(32));
					poliza.setVcCampo20(resultSet.getString(33));
					poliza.setnStatusPolizaId(resultSet.getInt(34));
					poliza.setdFechaAlta(resultSet.getDate(35));
					poliza.setnAseguradoraId(resultSet.getInt(36));
					poliza.setBlArchivo(resultSet.getBlob(37));
					poliza.setnClasificacionPolizaId(resultSet.getInt(38));
					poliza.setVcEmpresaContratante(resultSet.getString(39));
					poliza.setnEndoso(resultSet.getInt(40));
					poliza.setdFechaAntiguedad(resultSet.getDate(41));
					poliza.setnMonedaId(resultSet.getInt(42));
					poliza.setbActivo(resultSet.getString(43));
					poliza.setnOrigenPoliza(resultSet.getInt(44));
					poliza.setFechaNotifPoliza(resultSet.getDate(45));	
					
					poliza.setVcVigenciaDesde(resultSet.getString(46));
					poliza.setVcVigenciaHasta(resultSet.getString(47));
					poliza.setVcFechaAlta(resultSet.getString(48));
					poliza.setVcFechaAntiguedad(resultSet.getString(49));					
					
					boolean esMenor = DateUtil.isInSameDayOrBefore(poliza.getFechaNotifPoliza(), poliza.getdVigenciaHasta());
					poliza.setTipoVencimiento((esMenor)?0:DateUtil.isInSameDayOrBefore(poliza.getdVigenciaHasta(), fechaActual)?1:2); 
					
					listaPoliza.add(poliza);
				}
				
				return listaPoliza;
				
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
	public Poliza consultaPoliza(int empresaId, int contratante, String polizaId, int certificado) {
		final String procedureCall = "{call SP_POL_CONSULTA_POLIZA_ID(?, ?, ?, ?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresaId);
			callableSt.setInt(2, contratante);
			callableSt.setString(3, polizaId);
			callableSt.setInt(4, certificado);

			resultSet = callableSt.executeQuery();
			Poliza poliza = new Poliza();
			while(resultSet.next()){
				poliza.setnEmpresaId(resultSet.getInt(1));
				poliza.setnContratanteId(resultSet.getInt(2));
				poliza.setVcPolizaId(resultSet.getString(3));
				poliza.setnCertificado(resultSet.getInt(4));
				poliza.setnProductoId(resultSet.getInt(5));
				poliza.setVcTitularNombre(resultSet.getString(6));
				poliza.setVcTitularApellidoPatern(resultSet.getString(7));
				poliza.setVcTitularApellidoMatern(resultSet.getString(8));
				poliza.setnPrima(resultSet.getBigDecimal(9));
				poliza.setdVigenciaDesde(resultSet.getDate(10));
				poliza.setdVigenciaHasta(resultSet.getDate(11));
				poliza.setnTipoPolizaId(resultSet.getInt(12));
				poliza.setVcCampo1(resultSet.getString(13));
				poliza.setVcCampo2(resultSet.getString(14));
				poliza.setVcCampo3(resultSet.getString(15));
				poliza.setVcCampo4(resultSet.getString(16));
				poliza.setVcCampo5(resultSet.getString(17));
				poliza.setVcCampo6(resultSet.getString(18));
				poliza.setVcCampo7(resultSet.getString(19));
				poliza.setVcCampo8(resultSet.getString(20));
				poliza.setVcCampo9(resultSet.getString(21));
				poliza.setVcCampo10(resultSet.getString(22));
				poliza.setVcCampo11(resultSet.getString(23));
				poliza.setVcCampo12(resultSet.getString(24));
				poliza.setVcCampo13(resultSet.getString(25));
				poliza.setVcCampo14(resultSet.getString(26));
				poliza.setVcCampo15(resultSet.getString(27));
				poliza.setVcCampo16(resultSet.getString(28));
				poliza.setVcCampo17(resultSet.getString(29));
				poliza.setVcCampo18(resultSet.getString(30));
				poliza.setVcCampo19(resultSet.getString(31));
				poliza.setVcCampo20(resultSet.getString(32));
				poliza.setnStatusPolizaId(resultSet.getInt(33));
				poliza.setdFechaAlta(resultSet.getDate(34));
				poliza.setnAseguradoraId(resultSet.getInt(35));
				poliza.setBlArchivo(resultSet.getBlob(36));
				poliza.setnClasificacionPolizaId(resultSet.getInt(37));
				poliza.setVcEmpresaContratante(resultSet.getString(38));
				poliza.setnEndoso(resultSet.getInt(39));
				poliza.setdFechaAntiguedad(resultSet.getDate(40));
				poliza.setnMonedaId(resultSet.getInt(41));
				poliza.setbActivo(resultSet.getString(42));
			}
			
			return poliza;
			
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
	public List<PolizaMap> consultaMapPoliza(int empresaId, int contratante, String polizaId, int certificado, int tipo) {
		final String procedureCall = "{call SP_POL_CONSULTA_POLIZA_MAP(?,?,?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresaId);
			callableSt.setInt(2, contratante);
			callableSt.setString(3, polizaId);
			callableSt.setInt(4, certificado);
			callableSt.setInt(5, tipo);

			resultSet = callableSt.executeQuery();
			List<PolizaMap> listaPolizaMap = new ArrayList<PolizaMap>();
			while(resultSet.next()){
				PolizaMap polizaMap = new PolizaMap();
				polizaMap.setnTipoPolizaId(resultSet.getInt(1));
				polizaMap.setnMapCampoId(resultSet.getInt(2));
				polizaMap.setVcMapTexto(resultSet.getString(3));
				polizaMap.setbActivo(resultSet.getString(4));
				polizaMap.setVcMapNombre(resultSet.getString(5));
				polizaMap.setVcMapValor(resultSet.getString(6));
				listaPolizaMap.add(polizaMap);
			}
			return listaPolizaMap;			
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
	public List<PolizaMap> consultaMapPolizaPorTipo(int tipo) {
		final String procedureCall = "{call SP_POL_CONSULTA_POLIZA_MAP_POR_TIPO(?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, tipo);

			resultSet = callableSt.executeQuery();
			List<PolizaMap> listaPolizaMap = new ArrayList<PolizaMap>();
			while(resultSet.next()){
				PolizaMap polizaMap = new PolizaMap();
				polizaMap.setnTipoPolizaId(resultSet.getInt(1));
				polizaMap.setnMapCampoId(resultSet.getInt(2));
				polizaMap.setVcMapTexto(resultSet.getString(3));
				polizaMap.setbActivo(resultSet.getString(4));
				polizaMap.setVcMapNombre(resultSet.getString(5));
				polizaMap.setnOrden(resultSet.getInt(6));
				listaPolizaMap.add(polizaMap);
			}
			return listaPolizaMap;			
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
	public List<PolizaAseguradoAdic> consultaAseguradosAdicionales(
			int empresaId, int contratante, String polizaId, int certificado) {
		// TODO Auto-generated method stub
		final String procedureCall = "{call SP_POL_CONSULTA_ASEGURADOS_ADIC(?,?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresaId);
			callableSt.setInt(2, contratante);
			callableSt.setString(3, polizaId);
			callableSt.setInt(4, certificado);

			resultSet = callableSt.executeQuery();
			List<PolizaAseguradoAdic> listaPolizaAseguradoAdic = new ArrayList<PolizaAseguradoAdic>();
			while(resultSet.next()){
				PolizaAseguradoAdic polizaAseguradoAdic = new PolizaAseguradoAdic();
				polizaAseguradoAdic.setnEmpresaId(resultSet.getInt(1));
				polizaAseguradoAdic.setnContratanteId(resultSet.getInt(2));
				polizaAseguradoAdic.setnAseguradoraId(resultSet.getInt(3));
				polizaAseguradoAdic.setVcPolizaId(resultSet.getString(4));
				polizaAseguradoAdic.setnCertificado(resultSet.getInt(5));
				polizaAseguradoAdic.setnDependiente(resultSet.getInt(6));
				polizaAseguradoAdic.setVcAseguradoNombre(resultSet.getString(7));
				polizaAseguradoAdic.setVcAseguradoApellidoPaterno(resultSet.getString(8));
				polizaAseguradoAdic.setVcAseguradoApellidoMaterno(resultSet.getString(9));
				polizaAseguradoAdic.setbActivo(resultSet.getString(10));
				listaPolizaAseguradoAdic.add(polizaAseguradoAdic);
			}
			return listaPolizaAseguradoAdic;			
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
