package mx.com.ege.bus.domain;

import java.sql.Blob;
import java.util.Date;

public class PrePoliza {
	
	private Integer nPrePolizaId;
	private String vcCorreo;
	private Integer nStatusPrePolizaId;
	private Date dFechaAlta;
	private Integer nAseguradoraId;
	private Blob blArchivo;
	private int nOrigenPoliza;
	
	public Integer getnPrePolizaId() {
		return nPrePolizaId;
	}
	public void setnPrePolizaId(Integer nPrePolizaId) {
		this.nPrePolizaId = nPrePolizaId;
	}
	public String getVcCorreo() {
		return vcCorreo;
	}
	public void setVcCorreo(String vcCorreo) {
		this.vcCorreo = vcCorreo;
	}
	public Integer getnStatusPrePolizaId() {
		return nStatusPrePolizaId;
	}
	public void setnStatusPrePolizaId(Integer nStatusPrePolizaId) {
		this.nStatusPrePolizaId = nStatusPrePolizaId;
	}
	public Date getdFechaAlta() {
		return dFechaAlta;
	}
	public void setdFechaAlta(Date dFechaAlta) {
		this.dFechaAlta = dFechaAlta;
	}
	public Integer getnAseguradoraId() {
		return nAseguradoraId;
	}
	public void setnAseguradoraId(Integer nAseguradoraId) {
		this.nAseguradoraId = nAseguradoraId;
	}
	public Blob getBlArchivo() {
		return blArchivo;
	}
	public void setBlArchivo(Blob blArchivo) {
		this.blArchivo = blArchivo;
	}
	public int getnOrigenPoliza() {
		return nOrigenPoliza;
	}
	public void setnOrigenPoliza(int nOrigenPoliza) {
		this.nOrigenPoliza = nOrigenPoliza;
	}

	
}
