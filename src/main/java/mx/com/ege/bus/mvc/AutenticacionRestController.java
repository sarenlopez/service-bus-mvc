package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.Map;

import mx.com.ege.bus.process.AutenticacionProcess;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/autenticacion")
public class AutenticacionRestController
{
	@Autowired
	private AutenticacionProcess autenticacionProcess;


	@RequestMapping(value="/getAutenticacion", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    public @ResponseBody String getAutenticacion(@RequestBody String input){
    	System.out.println("getAutenticacion...");
    	
    	try{
    		
    		System.out.println("input:" + input);
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = autenticacionProcess.getAutenticacionProcess(map.get("correo").toString(), map.get("contrasena").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }
	
	@RequestMapping(value="/doOlvidoContrasena", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String doOlvidoContrasena(@RequestBody String input){
    	System.out.println("doOlvidoContrasena...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = autenticacionProcess.doOlvidoContrasenaProcess(map.get("correo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/getAsesor", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAsesor(@RequestBody String input){
    	System.out.println("getAsesor...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = autenticacionProcess.getAsesorProcess(map.get("correo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }

	@RequestMapping(value="/getUsuario", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getUsuario(@RequestBody String input){
    	System.out.println("getUsuario...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = autenticacionProcess.getUsuarioProcess(map.get("correo").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/doCreaUsuario", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String doCreaUsuario(@RequestBody String input){
    	System.out.println("doCreaUsuario...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = autenticacionProcess.doCreaUsuario(map.get("correo").toString(), map.get("contrasena").toString(), Integer.parseInt(map.get("tipoUsuario").toString()), map.get("nombre").toString(), map.get("apPaterno").toString(), map.get("apMaterno").toString(), map.get("telefonoMovil").toString(), map.get("telefonoFijo").toString(), map.get("correoAsesor").toString(), map.get("fotoPerfil").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

}
