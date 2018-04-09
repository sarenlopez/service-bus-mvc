package mx.com.ege.bus.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.com.ege.bus.domain.Aseguradora;
import mx.com.ege.bus.domain.AseguradoraTelefonos;
import mx.com.ege.bus.domain.AsesorTelefonos;
import mx.com.ege.bus.domain.AutoDescripcion;
import mx.com.ege.bus.domain.AutoMarca;
import mx.com.ege.bus.domain.AutoModelo;
import mx.com.ege.bus.domain.AutoSubMarca;
import mx.com.ege.bus.domain.AutoTipo;
import mx.com.ege.bus.domain.TipoReclamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogoDaoImpl implements CatalogoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<TipoReclamo> getTipoReclamo(int empresa, int contratante,int aseguradora, int tipoPoliza) {
		final String procedureCall = "{call SP_CAT_CONSULTA_TIPO_RECLAMO(?,?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresa);
			callableSt.setInt(2, contratante);
			callableSt.setInt(3, aseguradora);
			callableSt.setInt(4, tipoPoliza);			
			
			resultSet = callableSt.executeQuery();
			List<TipoReclamo> listaTipoReclamo = new ArrayList<TipoReclamo>();
			
			while(resultSet.next()){				
				TipoReclamo tipoReclamo = new TipoReclamo();
				tipoReclamo.setnTipoReclamoId(resultSet.getInt(1));
				tipoReclamo.setnEmpresaId(resultSet.getInt(2));
				tipoReclamo.setnContratanteId(resultSet.getInt(3));
				tipoReclamo.setnAseguradoraId(resultSet.getInt(4));
				tipoReclamo.setnTipoPolizaId(resultSet.getInt(5));
				tipoReclamo.setnProductoId(resultSet.getInt(6));
				tipoReclamo.setVcUrlDocumentacion(resultSet.getString(7));
				tipoReclamo.setVcUrlInstructivo(resultSet.getString(8));
				tipoReclamo.setVcNombreDocumento(resultSet.getString(9));
				tipoReclamo.setbActivo(resultSet.getString(10));
				listaTipoReclamo.add(tipoReclamo);
			}
			return listaTipoReclamo;			
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
	public Aseguradora getAseguradora(int empresa, int contratante, int aseguradora) {
		final String procedureCall = "{call SP_CAT_CONSULTA_ASEGURADORA(?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresa);
			callableSt.setInt(2, contratante);
			callableSt.setInt(3, aseguradora);
			
			resultSet = callableSt.executeQuery();
			Aseguradora aseguradoraVO = new Aseguradora();
			
			while(resultSet.next()){	
				aseguradoraVO.setnEmpresaId(resultSet.getInt(1));
				aseguradoraVO.setnContratanteId(resultSet.getInt(2));
				aseguradoraVO.setnAseguradoraId(resultSet.getInt(3));
				aseguradoraVO.setVcNombreAseguradora(resultSet.getString(4));
				aseguradoraVO.setVcTelefonoCabinaSiniestro(resultSet.getString(5));
				aseguradoraVO.setVcCorreo(resultSet.getString(6));
				aseguradoraVO.setbActivo(resultSet.getString(7));
			}
			return aseguradoraVO;			
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
	public List<AseguradoraTelefonos> getAseguradoraTelefonos(int empresa, int contratante,
			int aseguradora, int tipoPoliza) {
		final String procedureCall = "{call SP_CAT_CONSULTA_ASEGURADORA_TELEFONOS(?,?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresa);
			callableSt.setInt(2, contratante);
			callableSt.setInt(3, aseguradora);
			callableSt.setInt(4, tipoPoliza);
			
			resultSet = callableSt.executeQuery();
			List<AseguradoraTelefonos> listaAseguradoraTelefonos = new ArrayList<AseguradoraTelefonos>();
			
			
			while(resultSet.next()){
				AseguradoraTelefonos aseguradoraVO = new AseguradoraTelefonos();
				aseguradoraVO.setnEmpresaId(resultSet.getInt(1));
				aseguradoraVO.setnContratanteId(resultSet.getInt(2));
				aseguradoraVO.setnAseguradoraId(resultSet.getInt(3));				
				aseguradoraVO.setnTipoPolizaId(resultSet.getInt(4));
				aseguradoraVO.setnOrden(resultSet.getInt(5));
				aseguradoraVO.setVcDescripcion(resultSet.getString(6));
				aseguradoraVO.setVcTelefono(resultSet.getString(7));
				aseguradoraVO.setbActivo(resultSet.getString(8));
				listaAseguradoraTelefonos.add(aseguradoraVO);
			}
			return listaAseguradoraTelefonos;			
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
	public List<AsesorTelefonos> getAsesorTelefonos(int empresa,
			int contratante, int aseguradora, int tipoPoliza) {
		final String procedureCall = "{call SP_CAT_CONSULTA_ASESOR_TELEFONOS(?,?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, empresa);
			callableSt.setInt(2, contratante);
			callableSt.setInt(3, aseguradora);
			callableSt.setInt(4, tipoPoliza);
			
			resultSet = callableSt.executeQuery();
			List<AsesorTelefonos> listaAsesorTelefonos = new ArrayList<AsesorTelefonos>();
			
			
			while(resultSet.next()){
				AsesorTelefonos asesorTelefonos = new AsesorTelefonos();
				asesorTelefonos.setnEmpresaId(resultSet.getInt(1));
				asesorTelefonos.setnContratanteId(resultSet.getInt(2));
				asesorTelefonos.setnAseguradoraId(resultSet.getInt(3));				
				asesorTelefonos.setnTipoPolizaId(resultSet.getInt(4));
				asesorTelefonos.setnAsesorId(resultSet.getInt(5));
				asesorTelefonos.setVcAsesor(resultSet.getString(6));
				asesorTelefonos.setVcEtiqueta(resultSet.getString(7));
				asesorTelefonos.setVcContenido(resultSet.getString(8));
				asesorTelefonos.setnOrden(resultSet.getInt(9));
								
				listaAsesorTelefonos.add(asesorTelefonos);
			}
			return listaAsesorTelefonos;			
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
	public List<AutoTipo> getAutoTipo() {
		final String procedureCall = "{call SP_CAT_CONSULTA_AUTO_TIPO()}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			
			resultSet = callableSt.executeQuery();
			List<AutoTipo> listaAutoTipo = new ArrayList<AutoTipo>();
			
			
			while(resultSet.next()){
				AutoTipo autoTipo = new AutoTipo();
				autoTipo.setIdTipo(resultSet.getInt(1));
				autoTipo.setTipo(resultSet.getString(2));
				listaAutoTipo.add(autoTipo);
			}
			return listaAutoTipo;			
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
	public List<AutoModelo> getAutoModelo() {
		final String procedureCall = "{call SP_CAT_CONSULTA_AUTO_MODELO()}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			
			resultSet = callableSt.executeQuery();
			List<AutoModelo> listaAutoModelo = new ArrayList<AutoModelo>();
						
			while(resultSet.next()){
				AutoModelo autoModelo = new AutoModelo();
				autoModelo.setModelo(resultSet.getInt(1));
				listaAutoModelo.add(autoModelo);
			}
			return listaAutoModelo;			
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
	public List<AutoMarca> getAutoMarca(int tipo, int modelo) {
		final String procedureCall = "{call SP_CAT_CONSULTA_AUTO_MARCA(?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, tipo);
			callableSt.setInt(2, modelo);
			
			resultSet = callableSt.executeQuery();
			List<AutoMarca> listaAutoMarca = new ArrayList<AutoMarca>();
						
			while(resultSet.next()){
				AutoMarca autoMarca = new AutoMarca();
				autoMarca.setIdMarca(resultSet.getInt(1));
				autoMarca.setMarca(resultSet.getString(2));
				listaAutoMarca.add(autoMarca);
			}
			return listaAutoMarca;			
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
	public List<AutoSubMarca> getAutoSubMarca(int tipo, int modelo, int marca) {
		final String procedureCall = "{call SP_CAT_CONSULTA_AUTO_SUBMARCA(?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, tipo);
			callableSt.setInt(2, modelo);
			callableSt.setInt(3, marca);
			
			resultSet = callableSt.executeQuery();
			List<AutoSubMarca> listaAutoSubMarca = new ArrayList<AutoSubMarca>();
						
			while(resultSet.next()){
				AutoSubMarca autoSubMarca = new AutoSubMarca();
				autoSubMarca.setIdSubmarca(resultSet.getInt(1));
				autoSubMarca.setSubmarca(resultSet.getString(2));
				listaAutoSubMarca.add(autoSubMarca);
			}
			return listaAutoSubMarca;			
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
	public List<AutoDescripcion> getAutoDescripcion(int tipo, int modelo,
			int marca, int submarca) {
		final String procedureCall = "{call SP_CAT_CONSULTA_AUTO_DESCRIPCION(?,?,?,?)}";
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setInt(1, tipo);
			callableSt.setInt(2, modelo);
			callableSt.setInt(3, marca);
			callableSt.setInt(4, submarca);
			
			resultSet = callableSt.executeQuery();
			List<AutoDescripcion> listaAutoDescripcion = new ArrayList<AutoDescripcion>();
						
			while(resultSet.next()){
				AutoDescripcion autoDescripcion = new AutoDescripcion();
				
				autoDescripcion.setIdDescripcion(resultSet.getInt(1));
				autoDescripcion.setDescripcion(resultSet.getString(2));
				listaAutoDescripcion.add(autoDescripcion);
			}
			return listaAutoDescripcion;			
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

