package Service.Impl;

import Entity.empleados;
import Repository.empleadoRepository;
import dto.EmpleadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class EmpleadoSvcImpl {

    @Autowired
    empleadoRepository EmpleadoRepository;

    public empleados guardarEmpleado(EmpleadoDto e){
        empleados empleados = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (e.getNit()== 0) {
            empleados = new empleados();
            empleados.setFechaAdicion(fechaAhora);
            empleados.setUsuarioAdicion(e.getNombre());
        } else {
            Optional<empleados> empleadoDB = EmpleadoRepository.findById(e.getNit());
            empleados = empleadoDB.get();
            empleados.setFechaModificacion(fechaAhora);
            empleados.setUsuarioModificacion(e.getNombre());
        }
        empleados.setNit(e.getNit());
        empleados.setNombre(e.getNombre());
        empleados.setApellido(e.getApellido());
        return EmpleadoRepository.save(empleados);
    }
}
