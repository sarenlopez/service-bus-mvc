package mx.com.ege.bus.repo;

import java.util.List;

import mx.com.ege.bus.domain.Cotizacion;
import mx.com.ege.bus.domain.CotizacionCatalogo;
import mx.com.ege.bus.domain.CotizacionMap;

import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionDao {
	
	public List<CotizacionMap> consultaMapCotizacion(int tipoPoliza);
	
	public List<CotizacionCatalogo> consultaCatalogo(String nombreTabla);
	
	public boolean insertaCotizacion(Cotizacion cotizacion);
	
}
