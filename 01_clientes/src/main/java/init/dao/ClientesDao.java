package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Cliente;

public interface ClientesDao  extends JpaRepository<Cliente,String>{
	
	
	Cliente findByUsuarioAndPassword (String usuario, String pass);

}
