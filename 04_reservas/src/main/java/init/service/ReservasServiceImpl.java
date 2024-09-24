package init.service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.dao.ReservasDao;
import init.entities.Reserva;
import init.model.ReservaDto;
import init.utilidades.Mapeador;

@Service
public class ReservasServiceImpl implements ReservasService {
	
	String url="http://servicio-vuelos/vuelos/";
	RestClient restClient;
	ReservasDao reservasDao;
	Mapeador mapeador;
	public ReservasServiceImpl(RestClient restClient, ReservasDao reservasDao, Mapeador mapeador) {
		super();
		this.restClient = restClient;
		this.reservasDao = reservasDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean altaReserva(ReservaDto reserva, int plazasReserva) {
		System.out.println(reserva.getVueloDto().getPrecio());
		if(reservasDao.findById(reserva.getIdreserva())!=null) {
			Reserva reserva2 = mapeador.reservaDtoToEntity(reserva);
			reserva2.setPrecio(plazasReserva*reserva2.getVuelo().getPrecio());
			reservasDao.save(reserva2);
			actualizarPlazas(plazasReserva,reserva2.getVuelo().getIdvuelo());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<ReservaDto> listaReservasCliente(String usuario) {
		return reservasDao.findByUsuario(usuario).stream()
				.map(r->mapeador.reservasEntityToDto(r))
				.toList();
	}
	
	public void actualizarPlazas (int plazasReservadas, int idVuelo) {
		restClient
		.put()
		.uri(url+"actualizar/"+idVuelo+"/"+plazasReservadas)
		.retrieve();
		
		
		
	}

	

	
}
