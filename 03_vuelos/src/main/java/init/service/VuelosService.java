package init.service;

import java.util.List;

import init.entities.Vuelo;
import init.model.VueloDto;

public interface VuelosService {
	
	List<VueloDto> VuelosPorDetinoYPlazas (String detino, int plazasReservada);
	
	String actualizarPlazas (int idVuelo, int PlazasReservadas);
	
	VueloDto datosVueloPorId (int idVuelo);
	
}
