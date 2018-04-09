package mx.com.ege.bus.domain;

import java.util.Date;

public class Usuario {
	
	private String vcCorreo;
	private String vcContrasena;
	private int nTipoUsuarioId;
	private String vcTipoUsuarioNombre;
	private String vcNombre;
	private String vcApellidoPaterno;
	private String vcApellidoMaterno;
	private String vcTelefonoMovil;
	private String vcTelefonoFijo;
	private Date dFechaAlta;
	private String vcFechaAlta;
	private String bActivo;
	private String vcCorreoAsesor;
	private String blFotoPerfil;
	
	public String getVcCorreo() {
		return vcCorreo;
	}
	public void setVcCorreo(String vcCorreo) {
		this.vcCorreo = vcCorreo;
	}
	public String getVcContrasena() {
		return vcContrasena;
	}
	public void setVcContrasena(String vcContrasena) {
		this.vcContrasena = vcContrasena;
	}
	public int getnTipoUsuarioId() {
		return nTipoUsuarioId;
	}
	public void setnTipoUsuarioId(int nTipoUsuarioId) {
		this.nTipoUsuarioId = nTipoUsuarioId;
	}
	public String getVcTipoUsuarioNombre() {
		return vcTipoUsuarioNombre;
	}
	public void setVcTipoUsuarioNombre(String vcTipoUsuarioNombre) {
		this.vcTipoUsuarioNombre = vcTipoUsuarioNombre;
	}
	public String getVcNombre() {
		return vcNombre;
	}
	public void setVcNombre(String vcNombre) {
		this.vcNombre = vcNombre;
	}
	public String getVcApellidoPaterno() {
		return vcApellidoPaterno;
	}
	public void setVcApellidoPaterno(String vcApellidoPaterno) {
		this.vcApellidoPaterno = vcApellidoPaterno;
	}
	public String getVcApellidoMaterno() {
		return vcApellidoMaterno;
	}
	public void setVcApellidoMaterno(String vcApellidoMaterno) {
		this.vcApellidoMaterno = vcApellidoMaterno;
	}
	public String getVcTelefonoMovil() {
		return vcTelefonoMovil;
	}
	public void setVcTelefonoMovil(String vcTelefonoMovil) {
		this.vcTelefonoMovil = vcTelefonoMovil;
	}
	public String getVcTelefonoFijo() {
		return vcTelefonoFijo;
	}
	public void setVcTelefonoFijo(String vcTelefonoFijo) {
		this.vcTelefonoFijo = vcTelefonoFijo;
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
	public String getVcFechaAlta() {
		return vcFechaAlta;
	}
	public void setVcFechaAlta(String vcFechaAlta) {
		this.vcFechaAlta = vcFechaAlta;
	}
	public String getBlFotoPerfil() {
		return blFotoPerfil;
	}
	public void setBlFotoPerfil(String blFotoPerfil) {
		this.blFotoPerfil = blFotoPerfil;
	}
	public String getVcCorreoAsesor() {
		return vcCorreoAsesor;
	}
	public void setVcCorreoAsesor(String vcCorreoAsesor) {
		this.vcCorreoAsesor = vcCorreoAsesor;
	}	
}
