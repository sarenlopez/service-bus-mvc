package mx.com.ege.bus.mvc;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.ege.bus.domain.Aseguradora;
import mx.com.ege.bus.domain.AseguradoraTelefonos;
import mx.com.ege.bus.domain.AsesorTelefonos;
import mx.com.ege.bus.domain.AutoDescripcion;
import mx.com.ege.bus.domain.AutoMarca;
import mx.com.ege.bus.domain.AutoModelo;
import mx.com.ege.bus.domain.AutoSubMarca;
import mx.com.ege.bus.domain.AutoTipo;
import mx.com.ege.bus.domain.TipoReclamo;
import mx.com.ege.bus.process.CatalogoProcess;

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
@RequestMapping("/rest/catalogo")
public class CatalogoRestController
{
	@Autowired
	private CatalogoProcess catalogoProcess;

	@RequestMapping(value="/getTipoReclamo", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getTipoReclamo(@RequestBody String input){
    	System.out.println("getTipoReclamo...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<TipoReclamo> listaTipoReclamo = catalogoProcess.getTipoReclamoProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), Integer.parseInt(map.get("aseguradora").toString()), Integer.parseInt(map.get("tipoPoliza").toString()));
    		
			String json = new Gson().toJson(listaTipoReclamo);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return null;
    }	

	@RequestMapping(value="/getAseguradora", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAseguradora(@RequestBody String input){
    	System.out.println("getAseguradora...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		Aseguradora aseguradora = catalogoProcess.getAseguradoraProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), Integer.parseInt(map.get("aseguradora").toString()));
    		
			String json = new Gson().toJson(aseguradora);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }	

	@RequestMapping(value="/getAseguradoraTelefonos", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAseguradoraTelefonos(@RequestBody String input){
    	System.out.println("getAseguradoraTelefonos...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<AseguradoraTelefonos> listaAseguradoras = catalogoProcess.getAseguradoraTelefonosProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), Integer.parseInt(map.get("aseguradora").toString()), Integer.parseInt(map.get("tipoPoliza").toString()));
    		
			String json = new Gson().toJson(listaAseguradoras);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }	


	@RequestMapping(value="/getAsesorTelefonos", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAsesorTelefonos(@RequestBody String input){
    	System.out.println("getAsesorTelefonos...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<AsesorTelefonos> listaAsesorTelefonos = catalogoProcess.getAsesorTelefonosProcess(Integer.parseInt(map.get("empresa").toString()), Integer.parseInt(map.get("contratante").toString()), Integer.parseInt(map.get("aseguradora").toString()), Integer.parseInt(map.get("tipoPoliza").toString()));
    		
			String json = new Gson().toJson(listaAsesorTelefonos);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }	
	
	@RequestMapping(value="/getAutoTipo", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAutoTipo(@RequestBody String input){
    	System.out.println("getAutoTipo...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		List<AutoTipo> listaAutoTipo = catalogoProcess.getAutoTipoProcess();
    		
			String json = new Gson().toJson(listaAutoTipo);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }	
	
	@RequestMapping(value="/getAutoModelo", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAutoModelo(@RequestBody String input){
    	System.out.println("getAutoModelo...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		List<AutoModelo> listaAutoModelo = catalogoProcess.getAutoModeloProcess();
    		
			String json = new Gson().toJson(listaAutoModelo);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }	
	
	@RequestMapping(value="/getAutoMarca", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAutoMarca(@RequestBody String input){
    	System.out.println("getAutoMarca...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<AutoMarca> listaAutoMarca = catalogoProcess.getAutoMarcaProcess(Integer.parseInt(map.get("tipo").toString()), Integer.parseInt(map.get("modelo").toString()));
    		
			String json = new Gson().toJson(listaAutoMarca);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }		
	
	@RequestMapping(value="/getAutoSubMarca", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAutoSubMarca(@RequestBody String input){
    	System.out.println("getAutoSubMarca...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<AutoSubMarca> listaAutoSubMarca = catalogoProcess.getAutoSubMarcaProcess(Integer.parseInt(map.get("tipo").toString()), Integer.parseInt(map.get("modelo").toString()), Integer.parseInt(map.get("marca").toString()));
    		
			String json = new Gson().toJson(listaAutoSubMarca);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }		

	
	@RequestMapping(value="/getAutoDescripcion", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody String getAutoDescripcion(@RequestBody String input){
    	System.out.println("getAutoDescripcion...");
    	
    	try{
    		ObjectMapper mapper = new ObjectMapper();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map = mapper.readValue(input, new TypeReference<Map<String, String>>(){});
    		List<AutoDescripcion> listaDescripcion = catalogoProcess.getAutoDescripcionProcess(Integer.parseInt(map.get("tipo").toString()), Integer.parseInt(map.get("modelo").toString()), Integer.parseInt(map.get("marca").toString()), Integer.parseInt(map.get("submarca").toString()));
    		
			String json = new Gson().toJson(listaDescripcion);
			System.out.println("json:"+ json);
			return json;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }		
	

}
