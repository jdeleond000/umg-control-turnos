package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "empleados", schema = "umg_control_turnos")
public class empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nit")
    private Long nit;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "dpi")
    private Integer dpi;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "numero_telefono")
    private Integer numeroTelefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_adicion")
    private Date fechaAdicion;

    @Column(name = "usuario_adicion")
    private String usuarioAdicion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    @Column(name = "cargo_id")
    private Integer cargoId;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_contratacion")
    private Date fechaContratacion;

    @Column(name = "salario")
    private String salario;

    @Column(name = "estado")
    private String estado;

    @Column(name = "turno_id")
    private Integer turno_id;
}
