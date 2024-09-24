package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.HotelesDao;
import init.entities.Hotel;

@Service
public class HotelesServiceImp implements HotelesService {
	
	HotelesDao hotelesDao;
	public HotelesServiceImp(HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}

	@Override
	public Hotel DatosHotelPorIdentificador(int identificador) {
		Hotel h=hotelesDao.findById(identificador).orElse(null);
		if(h!=null) {
			return h;
		}
		return null;
	}

	@Override
	public List<Hotel> hotelesPorLocalizacion(String localizacion) {
		List<Hotel> hoteles=hotelesDao.findByLocalizacion(localizacion);
		return hoteles;
	
	}

	@Override
	public List<String> listadoLocalizaciones() {
		return hotelesDao.findAll().stream()
				.map(l->l.getLocalizacion())
				.distinct()
				.toList();
		
	}

}
