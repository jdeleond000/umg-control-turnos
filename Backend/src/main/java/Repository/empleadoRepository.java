package Repository;

import Entity.empleados;
import org.springframework.data.repository.CrudRepository;

public interface empleadoRepository extends CrudRepository<empleados, Object> {
}
