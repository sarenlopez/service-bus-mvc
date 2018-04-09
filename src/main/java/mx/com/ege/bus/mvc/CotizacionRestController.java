package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.Map;

import mx.com.ege.bus.process.CotizacionProcess;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/cotizacion")
public class CotizacionRestController
{
	@Autowired
	private CotizacionProcess cotizacionProcess;

	@RequestMapping(value="/getSolicitudCotizacion", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getSolicitudCotizacion(@RequestBody String input){
    	System.out.println("getSolicitudCotizacion...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = cotizacionProcess.getSolicitudCotizacionProcess(Integer.parseInt(map.get("tipoPoliza").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	
	
	@RequestMapping(value="/doInsertaSolicitudCotizacion", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String doInsertaSolicitudCotizacion(@RequestBody String input){
    	System.out.println("doInsertaSolicitudCotizacion...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = cotizacionProcess.doInsertaSolicitudCotizacionProcess(input);
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }		
	
	
}
