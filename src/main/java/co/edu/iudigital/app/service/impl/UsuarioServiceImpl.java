package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.BadRequestException;
import co.edu.iudigital.app.exception.ErrorDto;
import co.edu.iudigital.app.exception.NotFoundException;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Role;
import co.edu.iudigital.app.model.Usuario;
import co.edu.iudigital.app.repository.IUsuarioRepository;
import co.edu.iudigital.app.service.iface.IUsuarioService;
import co.edu.iudigital.app.util.ConstUtil;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
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
	
	@Transactional(readOnly = true)
	@Override
	public Usuario listUser(Long id) throws RestException {
		Optional<Usuario> usuarioDB = usuarioRepository.findById(id);
		if(!usuarioDB.isPresent()) {
			throw  new NotFoundException(ErrorDto.getErrorDto(
			HttpStatus.NOT_FOUND.getReasonPhrase(),
			ConstUtil.MESSAGE_NOT_FOUNT,
			HttpStatus.NOT_FOUND.value())
		);
		}
		return usuarioRepository.findById(id).get();
	}

	@Transactional
	@Override
	public Usuario saveUser(Usuario usuario) throws RestException {
		if(Objects.isNull(usuario)) {
			throw  new BadRequestException(ErrorDto.getErrorDto(
			HttpStatus.BAD_REQUEST.getReasonPhrase(),
			ConstUtil.MESSAGE_NOT_FOUNT,
			HttpStatus.BAD_REQUEST.value())
		);
		}
		
		Usuario usuarioDb = usuarioRepository.findByUsername(usuario.getUsername());
		if(Objects.nonNull(usuarioDb)) {
			throw new BadRequestException(ErrorDto.getErrorDto(
					HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Usuario ya existe",
					 HttpStatus.BAD_REQUEST.value()));
		}
		
		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		role.setId(2L);
		roles.add(role);
		usuario.setRoles(roles);
		return usuarioRepository.save(usuario);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario listByUsername(String usuario) throws RestException {
		
		return usuarioRepository.findByUsername(usuario);
	}


	@Transactional
	@Override
	public Usuario updateUser(Usuario usuario) throws RestException {
		if(Objects.isNull(usuario)) {
			throw new BadRequestException(ErrorDto.getErrorDto(
					HttpStatus.BAD_REQUEST.getReasonPhrase(), 
					ConstUtil.MESSAGE_BAD_REQUEST, //TODO: CREAR CONSTANTE EN CONSUTIL
					HttpStatus.BAD_REQUEST.value())
				);
		}
		return usuarioRepository.save(usuario);
	}

}
