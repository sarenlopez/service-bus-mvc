package mx.com.ege.bus.domain;

import java.util.Date;

public class Reclamo {
	
	private String vcReclamoId;
	private String vcTipoReclamoId;
	private String vcNumSiniestro;
	private int nEmpresaId;
	private int nContratanteId;
	private int nAseguradoraId;
	private String vcPolizaId;
	private int nCertificado;
	private int nDependiente;
	private int nStatusReclamoId;
	private Date dFechaAlta;
	private String bActivo;
	
	public String getVcReclamoId() {
		return vcReclamoId;
	}
	public void setVcReclamoId(String vcReclamoId) {
		this.vcReclamoId = vcReclamoId;
	}
	public String getVcTipoReclamoId() {
		return vcTipoReclamoId;
	}
	public void setVcTipoReclamoId(String vcTipoReclamoId) {
		this.vcTipoReclamoId = vcTipoReclamoId;
	}
	public String getVcNumSiniestro() {
		return vcNumSiniestro;
	}
	public void setVcNumSiniestro(String vcNumSiniestro) {
		this.vcNumSiniestro = vcNumSiniestro;
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
	public String getVcPolizaId() {
		return vcPolizaId;
	}
	public void setVcPolizaId(String vcPolizaId) {
		this.vcPolizaId = vcPolizaId;
	}
	public int getnCertificado() {
		return nCertificado;
	}
	public void setnCertificado(int nCertificado) {
		this.nCertificado = nCertificado;
	}
	public int getnDependiente() {
		return nDependiente;
	}
	public void setnDependiente(int nDependiente) {
		this.nDependiente = nDependiente;
	}
	public int getnStatusReclamoId() {
		return nStatusReclamoId;
	}
	public void setnStatusReclamoId(int nStatusReclamoId) {
		this.nStatusReclamoId = nStatusReclamoId;
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
