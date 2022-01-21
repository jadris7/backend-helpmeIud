package co.edu.iudigital.app.dto;

import lombok.Builder;
import lombok.Data;

@Data //crea getter y setter por lombok
@Builder //Construye un objeto
public class DelitoDto {

	private Long id;
	private String nombre;
	private String description;
}
