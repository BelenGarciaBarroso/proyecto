package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
import init.model.HotelDto;
import init.model.ReservaDto;
import init.model.VueloDto;




@Component

public class Mapeador {
	
	public HotelDto hotelEntitytoDto (Hotel hotel) {
		return new HotelDto (hotel.getIdHotel(), 
				hotel.getNombre(), 
				hotel.getCategoria(), 
				hotel.getPrecio(), 
				hotel.getDisponible(), 
				hotel.getLocalizacion());
	}

	public Hotel hotelDtoToEntity (HotelDto hotel) {
		return new Hotel (hotel.getIdHotel(), 
				hotel.getNombre(), 
				hotel.getCategoria(), 
				hotel.getPrecio(), 
				hotel.getDisponible(), 
				hotel.getLocalizacion());
	}
		
	public VueloDto vueloEntitytoDto (Vuelo vuelo) {
		return new VueloDto (vuelo.getIdvuelo(), 
				vuelo.getCompany(), 
				vuelo.getFecha(), 
				vuelo.getPrecio(), 
				vuelo.getPlazas(), 
				vuelo.getDestino());
	}
	
	public Vuelo vueloDtoToEntity (VueloDto vuelo) {
		return new Vuelo (vuelo.getIdvuelo(), 
				vuelo.getCompany(), 
				vuelo.getFecha(), 
				vuelo.getPrecio(), 
				vuelo.getPlazas(), 
				vuelo.getDestino());
	}
	
	public ReservaDto reservasEntityToDto (Reserva reserva) {
		return new ReservaDto(reserva.getIdreserva(),
				hotelEntitytoDto(reserva.getHotel()),
				vueloEntitytoDto(reserva.getVuelo()),
				reserva.getPrecio(),
				reserva.getUsuario());
	}
	
	public Reserva reservaDtoToEntity (ReservaDto reserva) {
		return new Reserva (reserva.getIdreserva(), 
			hotelDtoToEntity(reserva.getHotelDto()),
			vueloDtoToEntity(reserva.getVueloDto()),
			reserva.getPrecio(),
			reserva.getUsuario());
	}
}
