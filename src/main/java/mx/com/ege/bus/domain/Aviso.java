package mx.com.ege.bus.domain;

import java.util.Date;

public class Aviso {
	
	private int nAvisoId;
	private int nEmpresaId;
	private int nTipoAvisoId;
	private String vcCorreo;
	private String vcTitulo;
	private String vcTexto;
	private Date dFechaAlta;
	private Date dFechaVer;
	private String bActivo;
	
	public int getnAvisoId() {
		return nAvisoId;
	}
	public void setnAvisoId(int nAvisoId) {
		this.nAvisoId = nAvisoId;
	}
	public int getnEmpresaId() {
		return nEmpresaId;
	}
	public void setnEmpresaId(int nEmpresaId) {
		this.nEmpresaId = nEmpresaId;
	}
	public int getnTipoAvisoId() {
		return nTipoAvisoId;
	}
	public void setnTipoAvisoId(int nTipoAvisoId) {
		this.nTipoAvisoId = nTipoAvisoId;
	}
	public String getVcCorreo() {
		return vcCorreo;
	}
	public void setVcCorreo(String vcCorreo) {
		this.vcCorreo = vcCorreo;
	}
	public String getVcTitulo() {
		return vcTitulo;
	}
	public void setVcTitulo(String vcTitulo) {
		this.vcTitulo = vcTitulo;
	}
	public String getVcTexto() {
		return vcTexto;
	}
	public void setVcTexto(String vcTexto) {
		this.vcTexto = vcTexto;
	}
	public Date getdFechaAlta() {
		return dFechaAlta;
	}
	public void setdFechaAlta(Date dFechaAlta) {
		this.dFechaAlta = dFechaAlta;
	}
	public Date getdFechaVer() {
		return dFechaVer;
	}
	public void setdFechaVer(Date dFechaVer) {
		this.dFechaVer = dFechaVer;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
	
	

}
