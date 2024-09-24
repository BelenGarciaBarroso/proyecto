package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.entities.Hotel;
import init.service.HotelesService;

@RestController
public class HotelesController {
	
	HotelesService hotelesService;
	public HotelesController(HotelesService hotelesService) {
		super();
		this.hotelesService = hotelesService;
	}
	
	@GetMapping(value="buscarHotel/{identificador}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> buscarHotelIdentificador (@PathVariable("identificador")int identificador) {
		Hotel hotel=hotelesService.DatosHotelPorIdentificador(identificador);
		if (hotel!=null) {
			return new ResponseEntity<>(hotel,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.CONFLICT);
	}
	
	@GetMapping(value="ListadoHoteles/{localizacion}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> buscarHotelesPorLocalizacion (@PathVariable("localizacion") String localizacion){
		return hotelesService.hotelesPorLocalizacion(localizacion);
	}
	
	@GetMapping(value="localizaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> localizavciones(){
		return hotelesService.listadoLocalizaciones();
	}
	

}
