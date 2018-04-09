package mx.com.ege.bus.repo;

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

import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoDao {
	
	public List<TipoReclamo> getTipoReclamo(int empresa, int contratante, int aseguradora, int tipoPoliza);
	
	public Aseguradora getAseguradora(int empresa, int contratante, int aseguradora);
	
	public List<AseguradoraTelefonos> getAseguradoraTelefonos(int empresa, int contratante, int aseguradora, int tipoPoliza);
	
	public List<AsesorTelefonos> getAsesorTelefonos(int empresa, int contratante, int aseguradora, int tipoPoliza);
	
	public List<AutoTipo> getAutoTipo();
	
	public List<AutoModelo> getAutoModelo();
	
	public List<AutoMarca> getAutoMarca(int tipo, int modelo);
	
	public List<AutoSubMarca> getAutoSubMarca(int tipo, int modelo, int marca);
	
	public List<AutoDescripcion> getAutoDescripcion(int tipo, int modelo, int marca, int submarca );
}
