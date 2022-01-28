package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Usuario;

public interface IUsuarioService {
//Se declara lo que se va hacer
	
	public List<UsuarioDto> listUsers() throws RestException;
	
	public Usuario listerUser(Long id) throws RestException;
	
	public Usuario saveUser(Usuario usuario) throws RestException;
	
	public Usuario listByUsername(String usuario) throws RestException;;
}
