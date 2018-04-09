package mx.com.ege.bus.domain;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

public class Poliza {
	
	private Integer nEmpresaId;
	private Integer nContratanteId;
	private String vcPolizaId;
	private Integer nCertificado;
	private Integer nProductoId;
	private String vcTitularApellidoPatern;
	private String vcTitularApellidoMatern;
	private String vcTitularNombre;
	private BigDecimal nPrima;
	private Date dVigenciaDesde;
	private String vcVigenciaDesde;
	private Date dVigenciaHasta;
	private String vcVigenciaHasta;
	private Integer nTipoPolizaId;
	private String vcTipoPoliza;
	private String vcCampo1;
	private String vcCampo2;
	private String vcCampo3;
	private String vcCampo4;
	private String vcCampo5;
	private String vcCampo6;
	private String vcCampo7;
	private String vcCampo8;
	private String vcCampo9;
	private String vcCampo10;
	private Integer nStatusPolizaId;
	private Date dFechaAlta;
	private String vcFechaAlta;
	private Integer nAseguradoraId;
	private Blob blArchivo;
	private Integer nClasificacionPolizaId;
	private String vcEmpresaContratante;
	private Integer nEndoso;
	private Date dFechaAntiguedad;
	private String vcFechaAntiguedad;
	private Integer nMonedaId;
	private String vcCampo11;
	private String vcCampo12;
	private String vcCampo13;
	private String vcCampo14;
	private String vcCampo15;
	private String vcCampo16;
	private String vcCampo17;
	private String vcCampo18;
	private String vcCampo19;
	private String vcCampo20;
	private String bActivo;
	private int nOrigenPoliza;
	private Date fechaNotifPoliza;
	private int tipoVencimiento;
	
	public Integer getnEmpresaId() {
		return nEmpresaId;
	}
	public void setnEmpresaId(Integer nEmpresaId) {
		this.nEmpresaId = nEmpresaId;
	}
	public Integer getnContratanteId() {
		return nContratanteId;
	}
	public void setnContratanteId(Integer nContratanteId) {
		this.nContratanteId = nContratanteId;
	}
	public String getVcPolizaId() {
		return vcPolizaId;
	}
	public void setVcPolizaId(String vcPolizaId) {
		this.vcPolizaId = vcPolizaId;
	}
	public Integer getnCertificado() {
		return nCertificado;
	}
	public void setnCertificado(Integer nCertificado) {
		this.nCertificado = nCertificado;
	}
	public Integer getnProductoId() {
		return nProductoId;
	}
	public void setnProductoId(Integer nProductoId) {
		this.nProductoId = nProductoId;
	}
	public String getVcTitularApellidoPatern() {
		return vcTitularApellidoPatern;
	}
	public void setVcTitularApellidoPatern(String vcTitularApellidoPatern) {
		this.vcTitularApellidoPatern = vcTitularApellidoPatern;
	}
	public String getVcTitularApellidoMatern() {
		return vcTitularApellidoMatern;
	}
	public void setVcTitularApellidoMatern(String vcTitularApellidoMatern) {
		this.vcTitularApellidoMatern = vcTitularApellidoMatern;
	}
	public String getVcTitularNombre() {
		return vcTitularNombre;
	}
	public void setVcTitularNombre(String vcTitularNombre) {
		this.vcTitularNombre = vcTitularNombre;
	}
	public BigDecimal getnPrima() {
		return nPrima;
	}
	public void setnPrima(BigDecimal nPrima) {
		this.nPrima = nPrima;
	}
	public Date getdVigenciaDesde() {
		return dVigenciaDesde;
	}
	public void setdVigenciaDesde(Date dVigenciaDesde) {
		this.dVigenciaDesde = dVigenciaDesde;
	}
	public Date getdVigenciaHasta() {
		return dVigenciaHasta;
	}
	public void setdVigenciaHasta(Date dVigenciaHasta) {
		this.dVigenciaHasta = dVigenciaHasta;
	}
	public Integer getnTipoPolizaId() {
		return nTipoPolizaId;
	}
	public void setnTipoPolizaId(Integer nTipoPolizaId) {
		this.nTipoPolizaId = nTipoPolizaId;
	}
	public String getVcTipoPoliza() {
		return vcTipoPoliza;
	}
	public void setVcTipoPoliza(String vcTipoPoliza) {
		this.vcTipoPoliza = vcTipoPoliza;
	}
	public String getVcCampo1() {
		return vcCampo1;
	}
	public void setVcCampo1(String vcCampo1) {
		this.vcCampo1 = vcCampo1;
	}
	public String getVcCampo2() {
		return vcCampo2;
	}
	public void setVcCampo2(String vcCampo2) {
		this.vcCampo2 = vcCampo2;
	}
	public String getVcCampo3() {
		return vcCampo3;
	}
	public void setVcCampo3(String vcCampo3) {
		this.vcCampo3 = vcCampo3;
	}
	public String getVcCampo4() {
		return vcCampo4;
	}
	public void setVcCampo4(String vcCampo4) {
		this.vcCampo4 = vcCampo4;
	}
	public String getVcCampo5() {
		return vcCampo5;
	}
	public void setVcCampo5(String vcCampo5) {
		this.vcCampo5 = vcCampo5;
	}
	public String getVcCampo6() {
		return vcCampo6;
	}
	public void setVcCampo6(String vcCampo6) {
		this.vcCampo6 = vcCampo6;
	}
	public String getVcCampo7() {
		return vcCampo7;
	}
	public void setVcCampo7(String vcCampo7) {
		this.vcCampo7 = vcCampo7;
	}
	public String getVcCampo8() {
		return vcCampo8;
	}
	public void setVcCampo8(String vcCampo8) {
		this.vcCampo8 = vcCampo8;
	}
	public String getVcCampo9() {
		return vcCampo9;
	}
	public void setVcCampo9(String vcCampo9) {
		this.vcCampo9 = vcCampo9;
	}
	public String getVcCampo10() {
		return vcCampo10;
	}
	public void setVcCampo10(String vcCampo10) {
		this.vcCampo10 = vcCampo10;
	}
	public Integer getnStatusPolizaId() {
		return nStatusPolizaId;
	}
	public void setnStatusPolizaId(Integer nStatusPolizaId) {
		this.nStatusPolizaId = nStatusPolizaId;
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
	public Integer getnClasificacionPolizaId() {
		return nClasificacionPolizaId;
	}
	public void setnClasificacionPolizaId(Integer nClasificacionPolizaId) {
		this.nClasificacionPolizaId = nClasificacionPolizaId;
	}
	public String getVcEmpresaContratante() {
		return vcEmpresaContratante;
	}
	public void setVcEmpresaContratante(String vcEmpresaContratante) {
		this.vcEmpresaContratante = vcEmpresaContratante;
	}
	public Integer getnEndoso() {
		return nEndoso;
	}
	public void setnEndoso(Integer nEndoso) {
		this.nEndoso = nEndoso;
	}
	public Date getdFechaAntiguedad() {
		return dFechaAntiguedad;
	}
	public void setdFechaAntiguedad(Date dFechaAntiguedad) {
		this.dFechaAntiguedad = dFechaAntiguedad;
	}
	public Integer getnMonedaId() {
		return nMonedaId;
	}
	public void setnMonedaId(Integer nMonedaId) {
		this.nMonedaId = nMonedaId;
	}
	public String getVcCampo11() {
		return vcCampo11;
	}
	public void setVcCampo11(String vcCampo11) {
		this.vcCampo11 = vcCampo11;
	}
	public String getVcCampo12() {
		return vcCampo12;
	}
	public void setVcCampo12(String vcCampo12) {
		this.vcCampo12 = vcCampo12;
	}
	public String getVcCampo13() {
		return vcCampo13;
	}
	public void setVcCampo13(String vcCampo13) {
		this.vcCampo13 = vcCampo13;
	}
	public String getVcCampo14() {
		return vcCampo14;
	}
	public void setVcCampo14(String vcCampo14) {
		this.vcCampo14 = vcCampo14;
	}
	public String getVcCampo15() {
		return vcCampo15;
	}
	public void setVcCampo15(String vcCampo15) {
		this.vcCampo15 = vcCampo15;
	}
	public String getVcCampo16() {
		return vcCampo16;
	}
	public void setVcCampo16(String vcCampo16) {
		this.vcCampo16 = vcCampo16;
	}
	public String getVcCampo17() {
		return vcCampo17;
	}
	public void setVcCampo17(String vcCampo17) {
		this.vcCampo17 = vcCampo17;
	}
	public String getVcCampo18() {
		return vcCampo18;
	}
	public void setVcCampo18(String vcCampo18) {
		this.vcCampo18 = vcCampo18;
	}
	public String getVcCampo19() {
		return vcCampo19;
	}
	public void setVcCampo19(String vcCampo19) {
		this.vcCampo19 = vcCampo19;
	}
	public String getVcCampo20() {
		return vcCampo20;
	}
	public void setVcCampo20(String vcCampo20) {
		this.vcCampo20 = vcCampo20;
	}
	public String getbActivo() {
		return bActivo;
	}
	public void setbActivo(String bActivo) {
		this.bActivo = bActivo;
	}
	public int getnOrigenPoliza() {
		return nOrigenPoliza;
	}
	public void setnOrigenPoliza(int nOrigenPoliza) {
		this.nOrigenPoliza = nOrigenPoliza;
	}
	public Date getFechaNotifPoliza() {
		return fechaNotifPoliza;
	}
	public void setFechaNotifPoliza(Date fechaNotifPoliza) {
		this.fechaNotifPoliza = fechaNotifPoliza;
	}
	public int getTipoVencimiento() {
		return tipoVencimiento;
	}
	public void setTipoVencimiento(int tipoVencimiento) {
		this.tipoVencimiento = tipoVencimiento;
	}
	public String getVcVigenciaDesde() {
		return vcVigenciaDesde;
	}
	public void setVcVigenciaDesde(String vcVigenciaDesde) {
		this.vcVigenciaDesde = vcVigenciaDesde;
	}
	public String getVcVigenciaHasta() {
		return vcVigenciaHasta;
	}
	public void setVcVigenciaHasta(String vcVigenciaHasta) {
		this.vcVigenciaHasta = vcVigenciaHasta;
	}
	public String getVcFechaAntiguedad() {
		return vcFechaAntiguedad;
	}
	public void setVcFechaAntiguedad(String vcFechaAntiguedad) {
		this.vcFechaAntiguedad = vcFechaAntiguedad;
	}
	public String getVcFechaAlta() {
		return vcFechaAlta;
	}
	public void setVcFechaAlta(String vcFechaAlta) {
		this.vcFechaAlta = vcFechaAlta;
	}
}
