package co.edu.iudigital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.iudigital.app.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//Select * from usuarios where nombre = 'Adriana' and apellido = 'Aguilar' ==>Consulta SQL
	//Consulta JPA
	//public Usuario findByNombreAndApellido(String nombre, String apellido);

	
	/*Con etiqueta Query JPQL recomendable para un join
	@Query("SELECT u FROM Usuario u WHERE u.nombre=?1 AND u.apellido=?2")
	public Usuario findByNombreAndApellido2(String nombre, String apellido);
	
	/*
	 * select * from delitos d 
	 * inner join usuarios u 
	 * on d.usuarios_id = u.id 
	 * where u.nombre = 'Adriana';
	 */
	
	/*@Query("Value = 	 * select * from delitos d"
			+ "inner join usuarios u"
			+ "on d.usuarios_id = u.id"
			+ " where u.nombre =?1", nativeQuery = true)
	public List<Delitos> findDelitos(String nombre);*/
	
	public Usuario findByUsername(String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.username=?1")
	public Usuario findByUsername2(String email);
	
	

}
