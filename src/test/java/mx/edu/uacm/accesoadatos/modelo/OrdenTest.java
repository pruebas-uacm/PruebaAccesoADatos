package mx.edu.uacm.accesoadatos.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest //Base de datos en memoria H2
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class OrdenTest {
	
	@Autowired //inyeccion de dependencias
	public TestEntityManager entityManager;
	
	@Autowired
	private OrdenRepository ordenRepository;
	
	@Test
	public void debeBuscarPorNombre() {
		//shouldFindByName
		
		//Given
		Orden ordenSimple = insertarOrden();
		
		//When
		List<Orden> ordenes = ordenRepository.findByCliente("diego");
		
		
		//Then 
		//la cadena diego (actual) es igual a la cadena otro (esperado)
		assertThat(ordenes.get(0).getCliente()).isEqualTo("diego");
	}
	
	
	
	
	
	private Orden insertarOrden() {
		
		Orden ordenSimple = new Orden("diego", new Date(), 66.6d);
		entityManager.persist(ordenSimple); //insertar en db
		entityManager.flush(); //commit de la transaccion
		
		return ordenSimple;
	}

}
