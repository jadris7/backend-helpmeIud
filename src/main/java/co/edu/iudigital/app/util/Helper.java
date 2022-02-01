package co.edu.iudigital.app.util;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.model.Usuario;

public interface Helper {
	
	//Método que retorne un usaurio DTO
	
	public static UsuarioDto getMapValuesClient(Usuario usuario) {
		UsuarioDto uDto = new UsuarioDto();
		
		uDto.setId(usuario.getId());
		uDto.setNombre(usuario.getNombre());
		uDto.setApellido(usuario.getApellido());
		uDto.setFechaNacimiento(usuario.getFechaNacimiento());
		uDto.setImage(usuario.getImage());
		uDto.setEnabled(usuario.getEnabled());
		
		List<String> rolesDto = usuario.getRoles()
				.stream()
				.map(r -> r.getNombre())
				.collect(Collectors.toList());
		uDto.setRoles(rolesDto);
		uDto.setUsername(usuario.getUsername());
		
		return uDto;
	}
	
	public static void setMapValuesClient(List<Usuario> usuarios, List<UsuarioDto> usuariosDto) {
		usuarios.stream()
				.map(usuario ->{
					UsuarioDto uDto = getMapValuesClient(usuario);
					return uDto;					
				}).forEach(cDto -> {
					usuariosDto.add(cDto);
				});
		}

}
