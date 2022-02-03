package co.edu.iudigital.app.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Delito;
import co.edu.iudigital.app.model.Usuario;
import co.edu.iudigital.app.service.iface.IEmailService;
import co.edu.iudigital.app.service.iface.IUsuarioService;
import co.edu.iudigital.app.util.ConstUtil;
import co.edu.iudigital.app.util.Helper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


@RestController
@RequestMapping("/usuarios")
@Api(value = "/usuarios", tags = {"usuarios"})
@SwaggerDefinition(tags = {
		@Tag(name = "Usuarios", description = "Gestion API Usuarios")
})
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IEmailService emailService;
	
	@ApiOperation(value = "Obtiene todos los usuarios",
			produces = "application/json",
			httpMethod ="GET")
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> index() throws RestException {
		List<UsuarioDto> usuarioDto = usuarioService.listUsers();
		return ResponseEntity.ok().body(usuarioDto);
	}
	
	@ApiOperation(value = "Obtiene usuario por id",
			response = Usuario.class,
			produces = "application/json",
			httpMethod ="GET")
	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDto> show(@PathVariable Long id) throws RestException {
		Usuario usuario = usuarioService.listUser(id);
		UsuarioDto usuarioDto = Helper.getMapValuesClient(usuario);
		return ResponseEntity.ok().body(usuarioDto);
	}
	
	@ApiOperation(value = "Registra un usaurio en la aplicación",
			response = Usuario.class,
			produces = "application/json",
			httpMethod ="POST")
	@PostMapping("/signup")
	public ResponseEntity<UsuarioDto> create(@RequestBody Usuario usuario) throws RestException{
		Usuario usuarioSaved = usuarioService.saveUser(usuario);
		if(Objects.isNull(usuarioSaved)) {
			String mess="Su usuario "+ usuarioSaved.getUsername()+
					"y contraseña "+ usuarioSaved.getPassword() ;
			String to="usuarioSaved.getUsername";
			String subj=ConstUtil.ASUNTO_MESSAGE;
			boolean sent = emailService.sendEmail(mess, to, subj);
			if(!sent) {
				System.out.print("No Envió mensaje");
				//Colocar log y una excepción
			}
		}
		UsuarioDto usuarioDto = Helper.getMapValuesClient(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
	}
	
}
