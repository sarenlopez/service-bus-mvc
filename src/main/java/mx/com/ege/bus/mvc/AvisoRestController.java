package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.ege.bus.domain.Aviso;
import mx.com.ege.bus.process.AvisoProcess;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/rest/aviso")
public class AvisoRestController
{
	@Autowired
	private AvisoProcess avisoProcess;

	@RequestMapping(value="/getAvisos", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAvisos(@RequestBody String input){
    	System.out.println("getAvisos...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<Aviso> listaAvisos = avisoProcess.getAvisosProcess(map.get("correo").toString());
    		
			String json = new Gson().toJson(listaAvisos);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

}
