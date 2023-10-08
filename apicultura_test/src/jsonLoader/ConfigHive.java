package jsonLoader;

import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class ConfigHive {
	private int hora;
	private int cantidadTecnicos;
	private int minTiempoReparacion;
	private int maxTiempoReparacion;
	private int cantidadColmenas;
	private int minTiempoMiel;
	private int maxTiempoMiel;
	private int minTiempoParedes;
	private int maxTiempoParedes;
	private int minTiempoComederos;
	private int maxTiempoComederos;
	private int minTiempoVentilacion;
	private int maxTiempoVentilacion;
	
	public ConfigHive() {
		loadInfo();
	}
	
	public void loadInfo() {
		String pathtofile = "C:\\Users\\PRINCIPAL\\eclipse-workspace\\apicultura_test\\jsonApicultura.json";
        
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
            
            if (jsonparser.containsKey("cantColmenas")) {
            cantidadColmenas = jsonparser.getJsonNumber("cantColmenas").intValue();
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
            
            if (jsonparser.containsKey("minTiempoDanoComederos")) {
            minTiempoComederos = jsonparser.getJsonNumber("minTiempoDanoComederos").intValue();
            }
            
            if (jsonparser.containsKey("maxTiempoDanoComederos")) {
            maxTiempoComederos = jsonparser.getJsonNumber("maxTiempoDanoComederos").intValue();
            }
            
            if (jsonparser.containsKey("minTiempoDanoVentilacion")) {
            minTiempoVentilacion = jsonparser.getJsonNumber("minTiempoDanoVentilacion").intValue();
            }
            
            if (jsonparser.containsKey("maxTiempoDanoVentilacion")) {
            maxTiempoVentilacion = jsonparser.getJsonNumber("maxTiempoDanoVentilacion").intValue();
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
	public int getMinTiempoComederos() {
		return minTiempoComederos;
	}
	public int getMaxTiempoComederos() {
		return maxTiempoComederos;
	}
	public int getMinTiempoVentilacion() {
		return minTiempoVentilacion;
	}
	public int getMaxTiempoVentilacion() {
		return maxTiempoVentilacion;
	}
	public int getMinTiempoReparacion() {
		return minTiempoReparacion;
	}
	public int getMaxTiempoReparacion() {
		return maxTiempoReparacion;
	}
	
}
