package mx.com.ege.bus.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.ege.bus.domain.Cotizacion;
import mx.com.ege.bus.domain.CotizacionCatalogo;
import mx.com.ege.bus.domain.CotizacionMap;
import mx.com.ege.bus.domain.SolicitudCotizacion;
import mx.com.ege.bus.enums.TipoCampo;
import mx.com.ege.bus.repo.CotizacionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CotizacionProcess {
	
	@Autowired
	private CotizacionDao cotizacionDao;
	
	public String getSolicitudCotizacionProcess(int tipoPoliza){
		System.out.println("getSolicitudCotizacionProcess...");
		try{
			System.out.println("tipoPoliza:" + tipoPoliza);
			SolicitudCotizacion solicitudCotizacion = new SolicitudCotizacion();
			List<CotizacionMap> listaParaSolicitudCot = new ArrayList<CotizacionMap>();
			//Se obtiene la lista de Mapeo
			List<CotizacionMap> listaCotMap = cotizacionDao.consultaMapCotizacion(tipoPoliza);
			
			//Se itera lista de Mapeo para obtener opciones de Catálogo
			for(CotizacionMap cotizacionMap: listaCotMap){
				//Si es de tipo Combo, se obtiene el catálogo
				if(cotizacionMap.getVcTipoCampo().equals(TipoCampo.COMBO.getValue())){
					List<CotizacionCatalogo> listaCotCat = cotizacionDao.consultaCatalogo(cotizacionMap.getVcCatalogo());
					cotizacionMap.setListaCotizacionCatalogo(listaCotCat);
				}
				
				listaParaSolicitudCot.add(cotizacionMap);
				
			}
			solicitudCotizacion.setCotizacionMap(listaParaSolicitudCot);
			String json = new Gson().toJson(solicitudCotizacion);
			System.out.println("json:"+ json);
			return json;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	
	public String doInsertaSolicitudCotizacionProcess(String json){
		System.out.println("doInsertaSolicitudCotizacionProcess...");
		try{
			System.out.println("json:" + json);
			
			Gson gson = new Gson(); 
			Map<String,String> map = new HashMap<String,String>();
			map = (Map<String,String>) gson.fromJson(json, map.getClass());

			Cotizacion cotizacion = new Cotizacion();
			cotizacion.setVcCorreo(map.get("correo"));
			cotizacion.setnTipoPolizaId(Integer.parseInt(map.get("tipoPoliza")));
			cotizacion.setVcCampo1(map.get("VC_CAMPO_1"));
			cotizacion.setVcCampo2(map.get("VC_CAMPO_2"));
			cotizacion.setVcCampo3(map.get("VC_CAMPO_3"));
			cotizacion.setVcCampo4(map.get("VC_CAMPO_4"));
			cotizacion.setVcCampo5(map.get("VC_CAMPO_5"));
			cotizacion.setVcCampo6(map.get("VC_CAMPO_6"));
			cotizacion.setVcCampo7(map.get("VC_CAMPO_7"));
			cotizacion.setVcCampo8(map.get("VC_CAMPO_8"));
			cotizacion.setVcCampo9(map.get("VC_CAMPO_9"));
			cotizacion.setVcCampo10(map.get("VC_CAMPO_10"));
			cotizacion.setVcCampo11(map.get("VC_CAMPO_11"));
			cotizacion.setVcCampo12(map.get("VC_CAMPO_12"));
			cotizacion.setVcCampo13(map.get("VC_CAMPO_13"));
			cotizacion.setVcCampo14(map.get("VC_CAMPO_14"));
			cotizacion.setVcCampo15(map.get("VC_CAMPO_15"));
			cotizacion.setVcCampo16(map.get("VC_CAMPO_16"));
			cotizacion.setVcCampo17(map.get("VC_CAMPO_17"));
			cotizacion.setVcCampo18(map.get("VC_CAMPO_18"));
			cotizacion.setVcCampo19(map.get("VC_CAMPO_19"));
			cotizacion.setVcCampo20(map.get("VC_CAMPO_20"));
			
			boolean estatusTran = cotizacionDao.insertaCotizacion(cotizacion);
			String respuesta = "{\"EstatusTran\": \"" + estatusTran +  "\"}";
			return respuesta;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
