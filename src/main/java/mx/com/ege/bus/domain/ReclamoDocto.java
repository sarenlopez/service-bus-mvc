package mx.com.ege.bus.domain;

import java.sql.Blob;
import java.util.Date;

public class ReclamoDocto {
	
	private int nReclamoDoctoId;
	private int nTipoReclamoId;
	private String vcReclamoId;
	private String vcReclamoDoctoNombre;
	private Blob blArchivo;
	private int nStatusDoctoReclamo;
	private Date dFechaAlta;
	private String bActivo;
	public int getnReclamoDoctoId() {
		return nReclamoDoctoId;
	}
	public void setnReclamoDoctoId(int nReclamoDoctoId) {
		this.nReclamoDoctoId = nReclamoDoctoId;
	}
	public int getnTipoReclamoId() {
		return nTipoReclamoId;
	}
	public void setnTipoReclamoId(int nTipoReclamoId) {
		this.nTipoReclamoId = nTipoReclamoId;
	}
	public String getVcReclamoId() {
		return vcReclamoId;
	}
	public void setVcReclamoId(String vcReclamoId) {
		this.vcReclamoId = vcReclamoId;
	}
	public String getVcReclamoDoctoNombre() {
		return vcReclamoDoctoNombre;
	}
	public void setVcReclamoDoctoNombre(String vcReclamoDoctoNombre) {
		this.vcReclamoDoctoNombre = vcReclamoDoctoNombre;
	}
	public Blob getBlArchivo() {
		return blArchivo;
	}
	public void setBlArchivo(Blob blArchivo) {
		this.blArchivo = blArchivo;
	}
	public int getnStatusDoctoReclamo() {
		return nStatusDoctoReclamo;
	}
	public void setnStatusDoctoReclamo(int nStatusDoctoReclamo) {
		this.nStatusDoctoReclamo = nStatusDoctoReclamo;
	}
	public Date getdFechaAlta() {
		return dFechaAlta;
	}
	public void setdFechaAlta(Date dFechaAlta) {
		this.dFechaAlta = dFechaAlta;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
	
	
}
