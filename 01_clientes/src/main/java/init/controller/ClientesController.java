package init.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.entities.Cliente;
import init.service.ClientesService;

@RestController
public class ClientesController {
	
	ClientesService clientesService;
	public ClientesController(ClientesService clientesService) {
		super();
		this.clientesService = clientesService;
	}
	
	@GetMapping(value="buscarUsuarioPass/{usuario}/{pass}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente>  buscarPorUserYPass (@PathVariable("usuario") String usuario, @PathVariable("pass")String pass) {
		Cliente cli=clientesService.buscarPorUsuarioYPass(usuario, pass);
		if(cli!=null) {
			return new ResponseEntity<>(cli,HttpStatus.OK);			
		}
		return new ResponseEntity<>(null,HttpStatus.CONFLICT);
	}
	
	@PostMapping(value="alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaCliente(@RequestBody Cliente cliente) {
		if(clientesService.agregar(cliente)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping(value="buscarUsuarios/{usuario}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorUsuario (@PathVariable("usuario") String usuario) {
		Cliente cli=clientesService.buscarPorUsuario(usuario);
		if(cli!=null) {
			return new ResponseEntity<>(cli,HttpStatus.OK);			
		}
		return new ResponseEntity<>(null,HttpStatus.CONFLICT);
	}

}
