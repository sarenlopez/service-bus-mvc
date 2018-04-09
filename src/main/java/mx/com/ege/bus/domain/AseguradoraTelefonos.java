package mx.com.ege.bus.domain;

public class AseguradoraTelefonos {

	private int nEmpresaId;
	private int nContratanteId;
	private int nAseguradoraId;
	private int nTipoPolizaId;
	private int nOrden;
	private String vcDescripcion;
	private String vcTelefono;
	private String bActivo;
	
	public int getnEmpresaId() {
		return nEmpresaId;
	}
	public void setnEmpresaId(int nEmpresaId) {
		this.nEmpresaId = nEmpresaId;
	}
	public int getnContratanteId() {
		return nContratanteId;
	}
	public void setnContratanteId(int nContratanteId) {
		this.nContratanteId = nContratanteId;
	}
	public int getnAseguradoraId() {
		return nAseguradoraId;
	}
	public void setnAseguradoraId(int nAseguradoraId) {
		this.nAseguradoraId = nAseguradoraId;
	}
	public int getnTipoPolizaId() {
		return nTipoPolizaId;
	}
	public void setnTipoPolizaId(int nTipoPolizaId) {
		this.nTipoPolizaId = nTipoPolizaId;
	}
	public int getnOrden() {
		return nOrden;
	}
	public void setnOrden(int nOrden) {
		this.nOrden = nOrden;
	}
	public String getVcDescripcion() {
		return vcDescripcion;
	}
	public void setVcDescripcion(String vcDescripcion) {
		this.vcDescripcion = vcDescripcion;
	}
	public String getVcTelefono() {
		return vcTelefono;
	}
	public void setVcTelefono(String vcTelefono) {
		this.vcTelefono = vcTelefono;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}

	
}
