package mx.com.ege.bus.process;

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
import mx.com.ege.bus.repo.CatalogoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoProcess {
	
	@Autowired
	private CatalogoDao catalogoDao;
	
	public List<TipoReclamo> getTipoReclamoProcess(int empresa, int contratante, int aseguradora, int tipoPoliza){
		System.out.println("getTipoReclamoProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("aseguradora:" + aseguradora);
			System.out.println("tipoPoliza:" + tipoPoliza);
						
			List<TipoReclamo> listaTipoReclamo = catalogoDao.getTipoReclamo(empresa, contratante, aseguradora, tipoPoliza);
			return listaTipoReclamo;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Aseguradora getAseguradoraProcess(int empresa, int contratante, int aseguradora){
		System.out.println("getAseguradoraProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("aseguradora:" + aseguradora);
						
			Aseguradora aseguradoraVO = catalogoDao.getAseguradora(empresa, contratante, aseguradora);
			return aseguradoraVO;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public List<AseguradoraTelefonos> getAseguradoraTelefonosProcess(int empresa, int contratante, int aseguradora, int tipoPoliza){
		System.out.println("getAseguradoraTelefonosProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("aseguradora:" + aseguradora);
			System.out.println("tipoPoliza:" + tipoPoliza);
						
			List<AseguradoraTelefonos> listaAseguradoraVO = catalogoDao.getAseguradoraTelefonos(empresa, contratante, aseguradora, tipoPoliza);
			return listaAseguradoraVO;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
		
		
	}	

	public List<AsesorTelefonos> getAsesorTelefonosProcess(int empresa, int contratante, int aseguradora, int tipoPoliza){
		System.out.println("getAsesorTelefonosProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("aseguradora:" + aseguradora);
			System.out.println("tipoPoliza:" + tipoPoliza);
						
			List<AsesorTelefonos> listaAsesorTelefonos = catalogoDao.getAsesorTelefonos(empresa, contratante, aseguradora, tipoPoliza);
			return listaAsesorTelefonos;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<AutoTipo> getAutoTipoProcess(){
		System.out.println("getAutoTipoProcess...");
		try{
			List<AutoTipo> listaAutoTipo = catalogoDao.getAutoTipo();
			return listaAutoTipo;
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}
	
	public List<AutoModelo> getAutoModeloProcess(){
		System.out.println("getAutoModeloProcess...");
		try{
			List<AutoModelo> listaAutoModelo = catalogoDao.getAutoModelo();
			return listaAutoModelo;			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}
	
	public List<AutoMarca> getAutoMarcaProcess(int tipo, int modelo){
		System.out.println("getAutoMarcaProcess...");
		try{
			List<AutoMarca> listaAutoModelo = catalogoDao.getAutoMarca(tipo, modelo);
			return listaAutoModelo;			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}		

	public List<AutoSubMarca> getAutoSubMarcaProcess(int tipo, int modelo, int marca){
		System.out.println("getAutoSubMarcaProcess...");
		try{
			List<AutoSubMarca> listaAutoSubMarca = catalogoDao.getAutoSubMarca(tipo, modelo, marca);
			return listaAutoSubMarca;			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}
	
	public List<AutoDescripcion> getAutoDescripcionProcess(int tipo, int modelo, int marca, int submarca){
		System.out.println("getAutoDescripcionProcess...");
		try{
			List<AutoDescripcion> listaAutoDescripcion = catalogoDao.getAutoDescripcion(tipo, modelo, marca, submarca);
			return listaAutoDescripcion;			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}			

}
