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

export interface Empleado {
    estado: string;
    nit: string;
    direccion: string;
    nombre: string;
    fechaContratacion: string;
    apellido: string;
    dpi: string;
    correo: string;
    telefono: string;
    salario: number;
}

export interface EmpleadoRH extends Empleado {
    iva?: number;
    igss?: number;
    totalDevengado?: number;
}




export interface catalogos {
    idCatalogo: string;
    codigoCatalogo: string;
    nombreCatalogo: string;
    descripcionCatalogo: string;
}

export interface catalogosPuesto {
    idCatalogo: string;
    codigoCatalogo: string;
    nombreCatalogo: string;
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