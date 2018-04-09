package mx.com.ege.bus.repo;

import java.util.List;

import mx.com.ege.bus.domain.Aviso;

import org.springframework.stereotype.Repository;

@Repository
public interface AvisoDao {
		
	public List<Aviso> consultaAvisos(String correo);
	
}
