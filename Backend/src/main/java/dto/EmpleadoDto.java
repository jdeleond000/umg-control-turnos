package dto;
import java.util.Date;
import lombok.Data;

@Data
public class EmpleadoDto {

    private Long nit;

    private String nombre;

    private String apellido;

    private String contrasena;

    private Integer dpi;

    private String correoElectronico;

    private Integer numeroTelefono;

    private String direccion;

    private Date fechaAdicion;

    private String usuarioAdicion;

    private Date fechaModificacion;

    private String usuarioModificacion;

    private Integer cargoId;

    private String email;

    private Date fechaContratacion;

    private String salario;

    private String estado;

    private Integer turno_id;
}


