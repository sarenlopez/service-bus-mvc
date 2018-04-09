package mx.com.ege.bus.domain;

import java.util.List;

public class CotizacionMap {

	private int nTipoPolizaId;
	private int nMapCampoId;
	private String vcMapNombreCampo;
	private String vcTipoCampo;
	private String vcCatalogo;
	private String vcMapTexto;
	private int nOrden;
	private String bActivo;
	private String vcTextoDefecto;
	private List<CotizacionCatalogo> listaCotizacionCatalogo;
	
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
	public String getVcMapNombreCampo() {
		return vcMapNombreCampo;
	}
	public void setVcMapNombreCampo(String vcMapNombreCampo) {
		this.vcMapNombreCampo = vcMapNombreCampo;
	}
	public String getVcTipoCampo() {
		return vcTipoCampo;
	}
	public void setVcTipoCampo(String vcTipoCampo) {
		this.vcTipoCampo = vcTipoCampo;
	}
	public String getVcCatalogo() {
		return vcCatalogo;
	}
	public void setVcCatalogo(String vcCatalogo) {
		this.vcCatalogo = vcCatalogo;
	}
	public String getVcMapTexto() {
		return vcMapTexto;
	}
	public void setVcMapTexto(String vcMapTexto) {
		this.vcMapTexto = vcMapTexto;
	}
	public int getnOrden() {
		return nOrden;
	}
	public void setnOrden(int nOrden) {
		this.nOrden = nOrden;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
	public List<CotizacionCatalogo> getListaCotizacionCatalogo() {
		return listaCotizacionCatalogo;
	}
	public void setListaCotizacionCatalogo(
			List<CotizacionCatalogo> listaCotizacionCatalogo) {
		this.listaCotizacionCatalogo = listaCotizacionCatalogo;
	}
	public String getVcTextoDefecto() {
		return vcTextoDefecto;
	}
	public void setVcTextoDefecto(String vcTextoDefecto) {
		this.vcTextoDefecto = vcTextoDefecto;
	}
	
}
