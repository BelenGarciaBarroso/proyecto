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
	
	String url="http://localhost:9500/vuelos/";
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
		System.out.println(plazasReserva);
		if(reservasDao.findById(reserva.getIdreserva())!=null) {
			Reserva reserva2 = mapeador.reservaDtoToEntity(reserva);
			System.out.println(reserva2.getHotel().getIdHotel());
			reservasDao.save(reserva2);
			System.out.println("despues de grabar");
			System.out.println(reserva2.getVuelo().getPlazas());
			actualizarPlazas(plazasReserva,reserva2.getVuelo().getIdvuelo());
			return true;
		}else {
			System.err.println("false");
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
		System.out.println("Id de vuelo"+idVuelo);
		System.out.println("plazas"+plazasReservadas);
		System.out.println(url+"actualizar/"+idVuelo+"/"+plazasReservadas);
		restClient
		.put()
		.uri(url+"actualizar/"+idVuelo+"/"+plazasReservadas)
		.retrieve();
		
		
		
	}

	

	
}
