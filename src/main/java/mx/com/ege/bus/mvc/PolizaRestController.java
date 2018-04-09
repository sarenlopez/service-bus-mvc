package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.Map;

import mx.com.ege.bus.process.PolizaProcess;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/poliza")
public class PolizaRestController
{
	@Autowired
	private PolizaProcess polizaProcess;

	@RequestMapping(value="/getPolizas", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getPolizas(@RequestBody String input){
    	System.out.println("getPolizas...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getPolizasProcess(map.get("correo").toString(), Integer.parseInt(map.get("tipoPoliza").toString()), Integer.parseInt(map.get("origenPoliza").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/getPolizasTodas", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getPolizasTodas(@RequestBody String input){
    	System.out.println("getPolizasTodas...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getPolizasProcess(map.get("correo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	
	
	
	@RequestMapping(value="/getPolizasVencidas", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getPolizasVencidas(@RequestBody String input){
    	System.out.println("getPolizasVencidas...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getPolizasVencidasProcess(map.get("correo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	
	
	@RequestMapping(value="/getPolizasAdicionales", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getPolizasAdicionales(@RequestBody String input){
    	System.out.println("getPolizasAdicionales...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getPolizasAdicionalesProcess(map.get("correo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }		
	
	@RequestMapping(value="/getPoliza", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getPoliza(@RequestBody String input){
    	System.out.println("getPoliza...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getPolizaProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), map.get("poliza").toString(), Integer.parseInt(map.get("certificado").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/getMapPoliza", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getMapPoliza(@RequestBody String input){
    	System.out.println("getMapPoliza...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getMapPolizaProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), map.get("poliza").toString(), Integer.parseInt(map.get("certificado").toString()), Integer.parseInt(map.get("tipo").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	


	@RequestMapping(value="/getMapPolizaPorTipo", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getMapPolizaPorTipo(@RequestBody String input){
    	System.out.println("getMapPolizaPorTipo...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getMapPolizaPorTipoProcess(Integer.parseInt(map.get("tipo").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/getPolizaAseguradosAdic", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getPolizaAseguradosAdic(@RequestBody String input){
     	System.out.println("getPolizaAseguradosAdic...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = polizaProcess.getPolizaAseguradosAdicProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), map.get("poliza").toString(), Integer.parseInt(map.get("certificado").toString()));
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }		
}
