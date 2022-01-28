package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Usuario;
import co.edu.iudigital.app.repository.IUsuarioRepository;
import co.edu.iudigital.app.service.iface.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDto> listUsers() throws RestException {
		
		List<Usuario> usuarioDB = usuarioRepository.findAll();
		List<UsuarioDto> usuarios = new ArrayList<>();
		usuarioDB.stream().forEach(u ->{
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setId(u.getId());
			usuarioDto.setNombre(u.getNombre());
			usuarioDto.setApellido(u.getApellido());
			usuarioDto.setUsername(u.getUsername());
			usuarioDto.setFechaNacimiento(u.getFechaNacimiento());
			usuarioDto.setEnabled(u.getEnabled());
			usuarioDto.setImage(u.getImage());
			List<String> rols = (u.getRoles()).stream()
					.map(r ->r.getNombre())
					.collect(Collectors.toList());
			usuarioDto.setRoles(rols);
			usuarios.add(usuarioDto);			
		});
		return usuarios;

	}

	@Override
	public Usuario listerUser(Long id) throws RestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario saveUser(Usuario usuario) throws RestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario listByUsername(String usuario) throws RestException {
		// TODO Auto-generated method stub
		return null;
	}

}
