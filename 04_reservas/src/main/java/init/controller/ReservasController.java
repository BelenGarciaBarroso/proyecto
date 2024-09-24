package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.ReservaDto;
import init.service.ReservasService;

@RestController
public class ReservasController {
	
	ReservasService reservasService;
	public ReservasController(ReservasService reservasService) {
		super();
		this.reservasService = reservasService;
	}
	
	@PostMapping (value="alta/{plazasReserva}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody ReservaDto reserva, @PathVariable("plazasReserva") int plazasReserva) {
		reservasService.altaReserva(reserva, plazasReserva);
	}
	
	@GetMapping(value="reservascliente/{usuario}",produces=MediaType.APPLICATION_JSON_VALUE )
	public List<ReservaDto> listaReservasCliente(@PathVariable("usuario") String usuario) {
		return reservasService.listaReservasCliente(usuario);
	}
	



}
