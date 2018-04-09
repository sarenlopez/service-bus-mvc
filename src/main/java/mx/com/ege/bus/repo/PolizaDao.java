package mx.com.ege.bus.repo;

import java.util.List;

import mx.com.ege.bus.domain.Poliza;
import mx.com.ege.bus.domain.PolizaAseguradoAdic;
import mx.com.ege.bus.domain.PolizaMap;

import org.springframework.stereotype.Repository;

@Repository
public interface PolizaDao {
	
	public List<Poliza> consultaPolizas(String correo, int tipoPoliza, int origenPoliza);
	
	public List<Poliza> consultaPolizas(String correo);
	
	public List<Poliza> consultaPolizasVencidas(String correo);
	
	public List<Poliza> consultaPolizasAdicionales(String correo);
	
	public Poliza consultaPoliza(int empresaId, int contratante, String polizaId, int certificado);
	
	public List<PolizaMap> consultaMapPoliza(int empresaId, int contratante, String polizaId, int certificado, int tipo);

	public List<PolizaMap> consultaMapPolizaPorTipo(int tipo);
	
	public List<PolizaAseguradoAdic> consultaAseguradosAdicionales(int empresaId, int contratante, String polizaId, int certificado);

}
