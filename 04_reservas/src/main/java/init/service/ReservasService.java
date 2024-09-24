package init.service;

import java.util.List;

import init.entities.Reserva;
import init.model.ReservaDto;

public interface ReservasService {
	
	boolean altaReserva (ReservaDto reserva, int plazasReservadas);
	
	List<ReservaDto> listaReservasCliente (String usuario);

}
