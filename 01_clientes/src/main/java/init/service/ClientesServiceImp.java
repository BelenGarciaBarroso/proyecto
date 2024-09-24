package init.service;

import org.springframework.stereotype.Service;

import init.dao.ClientesDao;
import init.entities.Cliente;

@Service
public class ClientesServiceImp implements ClientesService {
	ClientesDao clientesDao;
	public ClientesServiceImp(ClientesDao clientesDao) {
		this.clientesDao = clientesDao;
	}

	@Override
	public Cliente buscarPorUsuarioYPass(String Usuario, String pass) {
		Cliente c=clientesDao.findByUsuarioAndPassword(Usuario, pass);
		if (c!=null) {
			return c;
		}else {
			return null;
		}
	}

	@Override
	public boolean agregar(Cliente cliente) {
		if(clientesDao.findById(cliente.getUsuario())!=null) {
			clientesDao.save(cliente);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Cliente buscarPorUsuario(String usuario) {
		Cliente c=(clientesDao.findById(usuario))
				.orElse(null);
		if(c!=null) {
			return c;
			
		}else {
			return null;
		}
	}

}
