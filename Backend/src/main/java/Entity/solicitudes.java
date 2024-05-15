package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "solicitudes", schema = "umg_control_turnos")
public class solicitudes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @Column(name = "nit")
    private String nit;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;

    @Column(name = "revisor")
    private String revisor;

    @Column(name = "fecha_revision")
    private Date fechaRevision;

    @Column(name = "comentario_revision")
    private String comentarioRevision;
}
