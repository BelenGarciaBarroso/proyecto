package init.service;

import init.entities.Cliente;

public interface ClientesService {
	
	Cliente buscarPorUsuarioYPass (String Usuario, String pass);
	boolean agregar (Cliente cliente);
	Cliente buscarPorUsuario (String usuario);

}
