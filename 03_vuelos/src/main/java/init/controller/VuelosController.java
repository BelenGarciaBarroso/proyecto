package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import init.model.VueloDto;
import init.service.VuelosService;

@RestController
public class VuelosController {
	
	VuelosService vuelosService;
	public VuelosController(VuelosService vuelosService) {
		super();
		this.vuelosService = vuelosService;
	}
	
	@GetMapping(value="buscarVuelosDetinoPlazas/{destino}/{plazasReservadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VueloDto> buscarVuelos (@PathVariable("destino")String destino, @PathVariable("plazasReservadas") int plazasReservadas) {
		return vuelosService.VuelosPorDetinoYPlazas(destino, plazasReservadas);
		
	}
	
	@PutMapping(value="actualizar/{idVuelo}/{plazasReservadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public String actualizar (@PathVariable("idVuelo") int idVuelo, @PathVariable("plazasReservadas") int plazasRevervadas) {
		return  vuelosService.actualizarPlazas(idVuelo, plazasRevervadas);
	}
	
	@GetMapping(value="vueloId/{idVuelo}",produces=MediaType.APPLICATION_JSON_VALUE )
	public VueloDto vueloPorID (@PathVariable("idVuelo") int idVuelo){
		return vuelosService.datosVueloPorId(idVuelo);
	}
	
	
	
	
	
}
