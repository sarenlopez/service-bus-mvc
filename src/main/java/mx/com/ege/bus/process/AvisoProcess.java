package mx.com.ege.bus.process;

import java.util.List;

import mx.com.ege.bus.domain.Aviso;
import mx.com.ege.bus.repo.AvisoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisoProcess {
	
	@Autowired
	private AvisoDao avisoDao;
	
	public List<Aviso> getAvisosProcess(String correo){
		System.out.println("getAvisos...");
		try{
			System.out.println("correo:" + correo);
						
			List<Aviso> listaAvisos = avisoDao.consultaAvisos(correo);
			return listaAvisos;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
