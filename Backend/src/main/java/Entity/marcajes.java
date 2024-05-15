package Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "marcajes", schema = "umg_control_turnos")
public class marcajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marcaje")
    private Long idMarcaje;

    @Column(name = "nit")
    private String nit;

    @Column(name = "tipo_marcaje")
    private String tipoMarcaje;

    @Column(name = "hora")
    private Date hora;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "llegada_tardia")
    private Boolean llegadaTardia;
}
