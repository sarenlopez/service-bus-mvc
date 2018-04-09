package mx.com.ege.bus.repo;

import mx.com.ege.bus.domain.Respuesta1;

import org.springframework.stereotype.Repository;

@Repository
public interface PrePolizaDao {
	
	public Respuesta1 insertaPrePoliza(String correo, int origenPoliza, String imagenPoliza);
	
}
