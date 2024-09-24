package init.service;

import java.util.List;

import init.entities.Hotel;

public interface HotelesService {
	
	Hotel DatosHotelPorIdentificador (int identificador);
	
	List<Hotel> hotelesPorLocalizacion (String localizacion);
	
	List<String> listadoLocalizaciones();

}
