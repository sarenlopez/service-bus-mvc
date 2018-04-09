package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.Map;

import mx.com.ege.bus.process.PrePolizaProcess;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/prepoliza")
public class PrePolizaRestController
{
	@Autowired
	private PrePolizaProcess prePolizaProcess;

	@RequestMapping(value="/doInsertaPrePoliza", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String doInsertaPrePoliza(@RequestBody String input){
    	System.out.println("doInsertaPrePoliza...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		String respuesta = prePolizaProcess.doInsertaPrePolizaProcess(map.get("correo").toString(), Integer.parseInt(map.get("origenPoliza").toString()), map.get("imagenPoliza").toString());
    		return respuesta;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	


}
