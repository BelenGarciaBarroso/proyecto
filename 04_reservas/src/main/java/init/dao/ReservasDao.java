package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import init.entities.Reserva;
import init.entities.Vuelo;

public interface ReservasDao extends JpaRepository<Reserva,Integer> {
	
	List<Reserva> findByUsuario(String usuario);
	
	
	

}
