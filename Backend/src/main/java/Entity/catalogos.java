package Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "catalogos", schema = "umg_control_turnos")
public class catalogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Long idCatalogo;

    @Column(name = "codigo_catalogo")
    private String codigoCatalogo;

    @Column(name = "nombre_catalogo")
    private String nombreCatalogo;

    @Column(name = "descripcion_catalogo")
    private String descripcionCatalogo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usuario_adicion")
    private String usuarioAdicion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
}
