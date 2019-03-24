package mx.edu.uacm.accesoadatos.modelo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrdenRepository extends CrudRepository<Orden, Long> {

	List<Orden> findByCliente(String cliente);
	
	//Orden findByDireccion(String direccion);
}
