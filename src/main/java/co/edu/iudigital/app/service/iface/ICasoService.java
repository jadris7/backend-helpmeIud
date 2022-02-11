package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.dto.CasoDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Caso;

public interface ICasoService {
	
	public List<CasoDto> findAll() throws RestException;
	
	Caso save(Caso caso) throws RestException;
	
	public Boolean visible(Boolean visible, Long id) throws RestException;
	
	public Caso findById(Long id) throws RestException;

}
