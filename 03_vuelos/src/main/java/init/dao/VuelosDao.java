package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import init.entities.Vuelo;
import jakarta.transaction.Transactional;

public interface VuelosDao extends JpaRepository<Vuelo,Integer> {
	
	@Query("select v from Vuelo v where v.destino=?1 and v.plazas>=?2")
	List<Vuelo> findByDestinoAndPlazas (String destino, int plazasReserva);
	

}
