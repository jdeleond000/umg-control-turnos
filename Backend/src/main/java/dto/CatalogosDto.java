package dto;

import lombok.Data;

import java.util.Date;
@Data
public class CatalogosDto {

    private Long idCatalogo;

    private String codigoCatalogo;

    private String nombreCatalogo;

    private String descripcionCatalogo;

    private Date fechaCreacion;

    private Boolean estado;

    private Date fechaModificacion;

    private String usuarioAdicion;

    private String usuarioModificacion;
}
