package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.VuelosDao;
import init.entities.Vuelo;
import init.model.VueloDto;
import init.utilidades.Mapeador;

@Service
public class VuelosServiceImpl implements VuelosService {
	
	VuelosDao vuelosDao;
	Mapeador mapeador;
	public VuelosServiceImpl(VuelosDao vuelosDao, Mapeador mapeador) {
		super();
		this.vuelosDao = vuelosDao;
		this.mapeador = mapeador;
	}

	@Override
	public List<VueloDto> VuelosPorDetinoYPlazas(String detino, int plazasReservada) {
		return vuelosDao.findByDestinoAndPlazas(detino, plazasReservada).stream()
				.map(v->mapeador.vueloEntityToDto(v))
				.toList();
	}

	@Override
	public String actualizarPlazas(int idVuelo, int plazasReservadas) {
		Vuelo vuelo=vuelosDao.findById(idVuelo).orElse(null);
		if(vuelo!=null) {
			if(vuelo.getPlazas()>plazasReservadas) {
				vuelo.setPlazas(vuelo.getPlazas()-plazasReservadas);
				vuelosDao.save(vuelo);
				return "Actualizado";
			}else {
				return "No hay plazas suficientes";
			}
		}
		return "No existe el vuelo";
	}

	@Override
	public VueloDto datosVueloPorId(int idVuelo) {
		return vuelosDao.findById(idVuelo).stream()
				.map(v->mapeador.vueloEntityToDto(v))
				.findFirst()
				.orElse(null);
	}

}
