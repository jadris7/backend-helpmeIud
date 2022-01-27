package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.iudigital.app.dto.DelitoDto;
import co.edu.iudigital.app.exception.ErrorDto;
import co.edu.iudigital.app.exception.NotFoundException;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Delito;
import co.edu.iudigital.app.repository.IDelitoRepository;
import co.edu.iudigital.app.service.iface.IDelitoService;
import co.edu.iudigital.app.util.ConstUtil;

@Service
public class DelitoServiceImpl implements IDelitoService{

	
	//inyección de dependencia servicios depende de repositorios
	@Autowired
	private IDelitoRepository delitoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<DelitoDto> findAll() {
		List<Delito> delitos = delitoRepository.findAll();
		List<DelitoDto> delitosDto = new ArrayList<>();
		//primera forma
		for(Delito delito : delitos) {
			DelitoDto delitoDto = new DelitoDto();
			delitoDto.setId(delito.getId());
			delitoDto.setNombre(delito.getNombre());
			delitoDto.setDescription(delito.getDescripcion());
			delitosDto.add(delitoDto);
		}
		
		//Segunda forma
		/*delitos.stream()
			.forEach(d -> {
				DelitoDto delitoDto = new DelitoDto();
				delitoDto.setId(d.getId());
				delitoDto.setNombre(d.getNombre());
				delitoDto.setDescription(d.getDescripcion());
				delitosDto.add(delitoDto);
			});*/
		return delitosDto;
	}

	@Override
	@Transactional(readOnly = true)
	public Delito findById(Long id) {		
		return delitoRepository.findById(id).orElse(null);
	}

	@Override
	public Delito save(Delito delito) {
	
		return delitoRepository.save(delito);
	}

	@Override
	@Transactional
	public void delete(Long id) throws RestException{
		Optional<Delito> delito = delitoRepository.findById(id);
		if(delito.isPresent()) {
			delitoRepository.deleteById(id);
		}else {
			throw new NotFoundException(ErrorDto.getErrorDto(
					HttpStatus.NOT_FOUND.getReasonPhrase(),
					ConstUtil.MESSAGE_NOT_FOUNT,
					HttpStatus.NOT_FOUND.value())
					);
		}
		
	}

}
