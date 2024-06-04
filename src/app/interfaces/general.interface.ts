export interface Empleado {
    estado: string;
    nit: string;
    direccion: string;
    nombre: string;
    fechaContratacion: string;
    apellido: string;
    dpi: string;
    correo: string;
    tel: string;
}

export interface EmpleadoRH {
    estado: string;
    nit: string;
    direccion: string;
    nombre: string;
    fechaContratacion: string;
    apellido: string;
    dpi: string;
    correo: string;
    tel: string;
}

export interface catalogos {
    idCatalogo: string;
    codigoCatalogo: string;
    combreCatalogo: string;
    descripcionCatalogo: string;
}

export interface dataSolicitudes {
    idCatalogo: string;
    descripcionCatalogo: string;
    nombreCatalogo: string;
}

export interface catalogoRegistroSolicitud {
    comentario: string;
    tipoSolicitud: string;
    estado: string;
    fechaInicio: string;
    fechaFin: string;
    idSolicitud: string;
}

export interface motivo {
    descripcion: string;
}

export interface tipoSolicitud {
    descripcion: string;
}