package mx.com.ege.bus.process;

import mx.com.ege.bus.domain.Respuesta1;
import mx.com.ege.bus.repo.PrePolizaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class PrePolizaProcess {
	
	@Autowired
	private PrePolizaDao prePolizaDao;
	
	public String doInsertaPrePolizaProcess(String correo, int origenPoliza, String imagenPoliza){
		System.out.println("getPolizasProcess...");
		try{
			System.out.println("correo:" + correo);
			System.out.println("origenPoliza:" + origenPoliza);
			System.out.println("imagenPoliza:" + imagenPoliza);
						
			Respuesta1 respuesta1 = prePolizaDao.insertaPrePoliza(correo, origenPoliza, imagenPoliza);
			String json = new Gson().toJson(respuesta1);
			System.out.println("json:"+ json);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
