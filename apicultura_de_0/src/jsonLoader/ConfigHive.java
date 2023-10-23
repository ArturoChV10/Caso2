package jsonLoader;

import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

//Esta clase se comporta como loader

public class ConfigHive {
	private int hora;
	private int cantidadTecnicos;
	private int minTiempoReparacion;
	private int maxTiempoReparacion;
	private int cantidadFincas;
	private int cantidadColmenas;
	private int minTiempoMiel;
	private int maxTiempoMiel;
	private int minTiempoParedes;
	private int maxTiempoParedes;
	private int minPosibilidadParedes;
	private int maxPosibilidadParedes;
	private int minTiempoComederos;
	private int maxTiempoComederos;
	private int minPosibilidadComederos;
	private int maxPosibilidadComederos;
	private int minTiempoVentilacion;
	private int maxTiempoVentilacion;
	private int minPosibilidadVentilacion;
	private int maxPosibilidadVentilacion;
	
	public ConfigHive() {
		loadInfo();
	}
	
	public void loadInfo() {
		String pathtofile = "C:\\Users\\PRINCIPAL\\eclipse-workspace\\apicultura_de_0\\jsonApicultura.json";
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            JsonObject jsonparser = reader.readObject();
            
            if (jsonparser.containsKey("hora")) {
            	hora = jsonparser.getJsonNumber("hora").intValue();
            }
            
            if (jsonparser.containsKey("cantTecnicos")) {
            cantidadTecnicos = jsonparser.getJsonNumber("cantTecnicos").intValue();
            }
            
            if(jsonparser.containsKey("minTiempoArreglo")) {
            	minTiempoReparacion = jsonparser.getJsonNumber("minTiempoArreglo").intValue();
            }
            
            if(jsonparser.containsKey("maxTiempoArreglo")) {
            	maxTiempoReparacion = jsonparser.getJsonNumber("maxTiempoArreglo").intValue();
            }
            
            if(jsonparser.containsKey("cantFincas")) {
            	cantidadFincas = jsonparser.getJsonNumber("cantFincas").intValue();
            }
            
            if (jsonparser.containsKey("cantColmenasXFinca")) {
            cantidadColmenas = jsonparser.getJsonNumber("cantColmenasXFinca").intValue();
            }
            
            if (jsonparser.containsKey("minTiempoProduccion")) {
            minTiempoMiel = jsonparser.getJsonNumber("minTiempoProduccion").intValue();
            }
            
            if (jsonparser.containsKey("maxTiempoProduccion")) {
            maxTiempoMiel = jsonparser.getJsonNumber("maxTiempoProduccion").intValue();
            }
                   
            if (jsonparser.containsKey("minTiempoDanoParedes")) {
            minTiempoParedes = jsonparser.getJsonNumber("minTiempoDanoParedes").intValue();
            }
            
            if (jsonparser.containsKey("maxTiempoDanoParedes")) {
            maxTiempoParedes = jsonparser.getJsonNumber("maxTiempoDanoParedes").intValue();
            }
            
            if(jsonparser.containsKey("minPosibilidadParedes")) {
            	minPosibilidadParedes = jsonparser.getJsonNumber("minPosibilidadParedes").intValue();
            }
            
            if(jsonparser.containsKey("maxPosibilidadParedes")) {
            	maxPosibilidadParedes = jsonparser.getJsonNumber("maxPosibilidadParedes").intValue();
            }
            
            if (jsonparser.containsKey("minTiempoDanoComederos")) {
            minTiempoComederos = jsonparser.getJsonNumber("minTiempoDanoComederos").intValue();
            }
            
            if (jsonparser.containsKey("maxTiempoDanoComederos")) {
            maxTiempoComederos = jsonparser.getJsonNumber("maxTiempoDanoComederos").intValue();
            }
            
            if(jsonparser.containsKey("minPosibilidadComederos")) {
            	minPosibilidadComederos = jsonparser.getJsonNumber("minPosibilidadComederos").intValue();
            }
            
            if(jsonparser.containsKey("maxPosibilidadComederos")) {
            	maxPosibilidadComederos = jsonparser.getJsonNumber("maxPosibilidadComederos").intValue();
            }
            
            if (jsonparser.containsKey("minTiempoDanoVentilacion")) {
            minTiempoVentilacion = jsonparser.getJsonNumber("minTiempoDanoVentilacion").intValue();
            }
            
            if (jsonparser.containsKey("maxTiempoDanoVentilacion")) {
            maxTiempoVentilacion = jsonparser.getJsonNumber("maxTiempoDanoVentilacion").intValue();
            }
            
            if(jsonparser.containsKey("minPosibilidadVentilacion")) {
            	minPosibilidadVentilacion = jsonparser.getJsonNumber("minPosibilidadVentilacion").intValue();
            }
            
            if(jsonparser.containsKey("maxPosibilidadVentilacion")) {
            	maxPosibilidadVentilacion = jsonparser.getJsonNumber("maxPosibilidadVentilacion").intValue();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
	
	public int getHora() {
		return hora;
	}
	public int getCantidadTecnicos() {
		return cantidadTecnicos;
	}
	public int getCantidadFincas() {
		return cantidadFincas;
	}
	public int getCantidadColmenas() {
		return cantidadColmenas;
	}
	public int getMinTiempoMiel() {
		return minTiempoMiel;
	}
	public int getMaxTiempoMiel() {
		return maxTiempoMiel;
	}
	public int getMinTiempoParedes() {
		return minTiempoParedes;
	}
	public int getMaxTiempoParedes() {
		return maxTiempoParedes;
	}
	public int getMinPosibilidadParedes() {
		return minPosibilidadParedes;
	}
	public int getMaxPosibilidadParedes() {
		return maxPosibilidadParedes;
	}
	public int getMinTiempoComederos() {
		return minTiempoComederos;
	}
	public int getMaxTiempoComederos() {
		return maxTiempoComederos;
	}
	public int getMinPosibilidadComederos() {
		return minPosibilidadComederos;
	}
	public int getMaxPosibilidadComederos() {
		return maxPosibilidadComederos;
	}
	public int getMinTiempoVentilacion() {
		return minTiempoVentilacion;
	}
	public int getMaxTiempoVentilacion() {
		return maxTiempoVentilacion;
	}
	public int getMinPosibilidadVentilacion() {
		return minPosibilidadVentilacion;
	}
	public int getMaxPosibilidadVentilacion() {
		return maxPosibilidadVentilacion;
	}
	public int getMinTiempoReparacion() {
		return minTiempoReparacion;
	}
	public int getMaxTiempoReparacion() {
		return maxTiempoReparacion;
	}
	
}
