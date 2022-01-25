package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.iudigital.app.dto.DelitoDto;
import co.edu.iudigital.app.model.Delito;
import co.edu.iudigital.app.repository.IDelitoRepository;
import co.edu.iudigital.app.service.iface.IDelitoService;

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
	public Delito findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delito save(Delito delito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
