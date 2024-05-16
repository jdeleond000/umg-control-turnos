package dto;

import lombok.Data;

import java.util.Date;

@Data
public class MarcajesDto {

    private Long idMarcaje;

    private String nit;

    private String tipoMarcaje;

    private Date hora;

    private Date fecha;

    private Boolean llegadaTardia;
}
