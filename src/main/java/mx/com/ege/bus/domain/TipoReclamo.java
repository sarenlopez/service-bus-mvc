package mx.com.ege.bus.domain;

public class TipoReclamo {
	
	private int nTipoReclamoId;
	private int nEmpresaId;
	private int nContratanteId;
	private int nAseguradoraId;
	private int nTipoPolizaId;
	private int nProductoId;
	private String vcUrlDocumentacion;
	private String vcUrlInstructivo;
	private String vcNombreDocumento;
	private String bActivo;
	
	public int getnTipoReclamoId() {
		return nTipoReclamoId;
	}
	public void setnTipoReclamoId(int nTipoReclamoId) {
		this.nTipoReclamoId = nTipoReclamoId;
	}
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
	public int getnProductoId() {
		return nProductoId;
	}
	public void setnProductoId(int nProductoId) {
		this.nProductoId = nProductoId;
	}
	public String getVcUrlDocumentacion() {
		return vcUrlDocumentacion;
	}
	public void setVcUrlDocumentacion(String vcUrlDocumentacion) {
		this.vcUrlDocumentacion = vcUrlDocumentacion;
	}
	public String getVcUrlInstructivo() {
		return vcUrlInstructivo;
	}
	public void setVcUrlInstructivo(String vcUrlInstructivo) {
		this.vcUrlInstructivo = vcUrlInstructivo;
	}
	public String getVcNombreDocumento() {
		return vcNombreDocumento;
	}
	public void setVcNombreDocumento(String vcNombreDocumento) {
		this.vcNombreDocumento = vcNombreDocumento;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
	
	

}
