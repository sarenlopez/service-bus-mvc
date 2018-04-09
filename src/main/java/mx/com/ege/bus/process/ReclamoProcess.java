package mx.com.ege.bus.process;

import java.sql.Blob;

import mx.com.ege.bus.repo.ReclamoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamoProcess {
	
	@Autowired
	private ReclamoDao reclamoDao;
	
	public String doInsertaReclamoProcess(String tipoReclamoDesc, String numSiniestro, int empresa, int contratante, int aseguradora, String poliza, int certificado){
		System.out.println("doInsertaReclamoProcess...");
		try{
			System.out.println("tipoReclamo:" + tipoReclamoDesc);
			System.out.println("numSiniestro:" + numSiniestro);
			System.out.println("empresa:" + contratante);			
			System.out.println("contratante:" + contratante);
			System.out.println("aseguradora:" + aseguradora);
			System.out.println("poliza:" + poliza);
			System.out.println("certificado:" + certificado);
						
			int reclamoId = reclamoDao.insertaReclamo(tipoReclamoDesc, numSiniestro, empresa, contratante, aseguradora, poliza, certificado);
			String respuesta = "{\"ReclamoId\": \"" + reclamoId +  "\"}";
			return respuesta;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String doInsertaReclamoDoctoProcess(int tipoReclamoId, int reclamoId, String archivoNombre, String archivo ){
		System.out.println("doInsertaReclamoDoctoProcess...");
		try{
			System.out.println("tipoReclamoId:" + tipoReclamoId);
			System.out.println("reclamoId:" + reclamoId);
			System.out.println("archivoNombre:" + archivoNombre);			

			boolean status = reclamoDao.insertaReclamoDocto(tipoReclamoId, reclamoId, archivoNombre, archivo);
			String respuesta = "{\"EstatusTran\": \"" + status +  "\"}";
			return respuesta;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
