package mx.com.ege.bus.domain;

public class Aseguradora {

	private int nEmpresaId;
	private int nContratanteId;
	private int nAseguradoraId;
	private String vcNombreAseguradora;
	private String vcTelefonoCabinaSiniestro;
	private String vcCorreo;
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
	public String getVcNombreAseguradora() {
		return vcNombreAseguradora;
	}
	public void setVcNombreAseguradora(String vcNombreAseguradora) {
		this.vcNombreAseguradora = vcNombreAseguradora;
	}
	public String getVcTelefonoCabinaSiniestro() {
		return vcTelefonoCabinaSiniestro;
	}
	public void setVcTelefonoCabinaSiniestro(String vcTelefonoCabinaSiniestro) {
		this.vcTelefonoCabinaSiniestro = vcTelefonoCabinaSiniestro;
	}
	public String getVcCorreo() {
		return vcCorreo;
	}
	public void setVcCorreo(String vcCorreo) {
		this.vcCorreo = vcCorreo;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
}
