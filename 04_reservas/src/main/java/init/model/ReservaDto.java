package init.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDto {
	
	private int idreserva;
	@JsonProperty(value="hotel")
	private HotelDto hotelDto;
	@JsonProperty(value="vuelo")
	private VueloDto vueloDto;
	private double precio;
	private String usuario;
	public ReservaDto(int idreserva, HotelDto hotelDto, VueloDto vueloDto, double precio, String usuario) {
		super();
		this.idreserva = idreserva;
		this.hotelDto = hotelDto;
		this.vueloDto = vueloDto;
		this.precio = precio;
		this.usuario = usuario;
	}
	public ReservaDto() {
		vueloDto=new VueloDto();
		hotelDto=new HotelDto();
	}
	public int getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}
	public HotelDto getHotelDto() {
		return hotelDto;
	}
	public void setHotelDto(HotelDto hotelDto) {
		this.hotelDto = hotelDto;
	}
	public VueloDto getVueloDto() {
		return vueloDto;
	}
	public void setVueloDto(VueloDto vueloDto) {
		this.vueloDto = vueloDto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
