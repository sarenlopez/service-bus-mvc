package mx.com.ege.bus.domain;

public class PolizaMap {
	
	private int nTipoPolizaId;
	private int nMapCampoId;
	private String vcMapTexto;
	private String bActivo;
	private String vcMapNombre;
	private String vcMapValor;
	private int nOrden;
	
	public int getnTipoPolizaId() {
		return nTipoPolizaId;
	}
	public void setnTipoPolizaId(int nTipoPolizaId) {
		this.nTipoPolizaId = nTipoPolizaId;
	}
	public int getnMapCampoId() {
		return nMapCampoId;
	}
	public void setnMapCampoId(int nMapCampoId) {
		this.nMapCampoId = nMapCampoId;
	}
	public String getVcMapTexto() {
		return vcMapTexto;
	}
	public void setVcMapTexto(String vcMapTexto) {
		this.vcMapTexto = vcMapTexto;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
	public String getVcMapNombre() {
		return vcMapNombre;
	}
	public void setVcMapNombre(String vcMapNombre) {
		this.vcMapNombre = vcMapNombre;
	}
	public String getVcMapValor() {
		return vcMapValor;
	}
	public void setVcMapValor(String vcMapValor) {
		this.vcMapValor = vcMapValor;
	}
	public int getnOrden() {
		return nOrden;
	}
	public void setnOrden(int nOrden) {
		this.nOrden = nOrden;
	}
}
