package dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class SolicitudesDto {

    private Long idSolicitud;
    private String nit;
    private String tipoSolicitud;

    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private Date fechaSolicitud;
    private String revisor;
    private Date fechaRevision;
    private String comentarioRevision;
}
