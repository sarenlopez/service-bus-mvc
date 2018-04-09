package mx.com.ege.bus.process;

import java.util.List;

import mx.com.ege.bus.domain.Poliza;
import mx.com.ege.bus.domain.PolizaAseguradoAdic;
import mx.com.ege.bus.domain.PolizaMap;
import mx.com.ege.bus.repo.PolizaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class PolizaProcess {
	
	@Autowired
	private PolizaDao polizaDao;
	
	public String getPolizasProcess(String correo, int tipoPoliza, int origenPoliza){
		System.out.println("getPolizasProcess...");
		try{
			System.out.println("correo:" + correo);
			System.out.println("tipoPoliza:" + tipoPoliza);
			System.out.println("origenPoliza:" + origenPoliza);
			
			
			List<Poliza> listaPolizas = polizaDao.consultaPolizas(correo, tipoPoliza, origenPoliza);
			String json = new Gson().toJson(listaPolizas);
			System.out.println("json:"+ json);
			//json = json.replace("[", "").replace("]", "");
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getPolizasProcess(String correo){
		System.out.println("getPolizasProcess...");
		try{
			System.out.println("correo:" + correo);	
			
			List<Poliza> listaPolizas = polizaDao.consultaPolizas(correo);
			String json = new Gson().toJson(listaPolizas);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	

	public String getPolizasVencidasProcess(String correo){
		System.out.println("getPolizasVencidasProcess...");
		try{
			System.out.println("correo:" + correo);	
			
			List<Poliza> listaPolizas = polizaDao.consultaPolizasVencidas(correo);
			String json = new Gson().toJson(listaPolizas);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public String getPolizasAdicionalesProcess(String correo){
		System.out.println("getPolizasAdicionalesProcess...");
		try{
			System.out.println("correo:" + correo);	
			
			List<Poliza> listaPolizas = polizaDao.consultaPolizasAdicionales(correo);
			String json = new Gson().toJson(listaPolizas);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	
	public String getPolizaProcess(int empresa, int contratante, String poliza, int certificado){
		System.out.println("getPolizaProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("poliza:" + poliza);
			System.out.println("certificado:" + certificado);
			
			Poliza polizaVO = polizaDao.consultaPoliza(empresa, contratante, poliza, certificado);
			String json = new Gson().toJson(polizaVO);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}


	public String getMapPolizaProcess(int empresa, int contratante, String poliza, int certificado,  int tipo){
		System.out.println("getMapPolizaProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("poliza:" + poliza);
			System.out.println("certificado:" + certificado);
			System.out.println("tipo:" + tipo);
			
			List<PolizaMap> listaPolizaMap = polizaDao.consultaMapPoliza(empresa, contratante, poliza, certificado, tipo);
			String json = new Gson().toJson(listaPolizaMap);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}


	public String getMapPolizaPorTipoProcess(int tipo){
		System.out.println("getMapPolizaPorTipoProcess...");
		try{
			System.out.println("tipo:" + tipo);
			
			List<PolizaMap> listaPolizaMap = polizaDao.consultaMapPolizaPorTipo(tipo);
			String json = new Gson().toJson(listaPolizaMap);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}


	public String getPolizaAseguradosAdicProcess(int empresa, int contratante, String poliza, int certificado){
		System.out.println("getPolizaAseguradosAdicProcess...");
		try{
			System.out.println("empresa:" + empresa);
			System.out.println("contratante:" + contratante);
			System.out.println("poliza:" + poliza);
			System.out.println("certificado:" + certificado);
			
			List<PolizaAseguradoAdic> listaPolizaMap = polizaDao.consultaAseguradosAdicionales(empresa, contratante, poliza, certificado);
			String json = new Gson().toJson(listaPolizaMap);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

}
