package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.Map;

import mx.com.ege.bus.process.ReclamoProcess;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/reclamo")
public class ReclamoRestController
{
	@Autowired
	private ReclamoProcess reclamoProcess;

	@RequestMapping(value="/doInsertaReclamo", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String doInsertaReclamo(@RequestBody String input){
    	System.out.println("doInsertaReclamo...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = reclamoProcess.doInsertaReclamoProcess(map.get("tipoReclamoDesc").toString(), map.get("numSiniestro").toString(), 
    				Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), Integer.parseInt(map.get("aseguradora").toString()), map.get("poliza").toString(), Integer.parseInt(map.get("certificado").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/doInsertaReclamoDocto", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String doInsertaReclamoDocto(@RequestBody String input){
    	System.out.println("doInsertaReclamoDocto...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = reclamoProcess.doInsertaReclamoDoctoProcess( Integer.parseInt(map.get("tipoReclamoId").toString()), Integer.parseInt(map.get("reclamoId").toString()), map.get("archivoNombre").toString(), map.get("archivo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

		

}
