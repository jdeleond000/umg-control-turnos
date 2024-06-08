/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.Empleados;
import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.Repository.EmpleadoRepository;
import com.ia.chatbotia.dto.EmpleadoDto;
import com.ia.chatbotia.dto.LoginRequest;
import com.ia.chatbotia.projection.RHProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import com.ia.chatbotia.security.JwtTokenProvider;
import com.ia.chatbotia.security.LoginResponse;
import com.nimbusds.jose.JOSEException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author jairo
 */
@Service
public class EmpleadoSvcImpl {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    EmailServiceImpl email;

    public Empleados guardarEmpleado(EmpleadoDto datos) {
        Empleados empleados;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());

        String nit = datos.getNit();

        Optional<Empleados> empleadoExistente = empleadoRepository.findById(nit);
        boolean nuevo = false;
        if (!empleadoExistente.isPresent()) {
            nuevo = true;
            String hashedPassword = passwordEncoder.encode(datos.getContrasena());
            empleados = new Empleados();
            empleados.setNit(nit);
            empleados.setNombre(datos.getNombre());
            empleados.setApellido(datos.getApellido());
            empleados.setContrasena(hashedPassword);
            empleados.setDpi(datos.getDpi());
            empleados.setCorreoElectronico(datos.getCorreoElectronico());
            empleados.setNumeroTelefono(datos.getNumeroTelefono());
            empleados.setDireccion(datos.getDireccion());
            empleados.setFechaAdicion(fechaAhora);
            empleados.setUsuarioAdicion(datos.getUsuarioAdicion());
            empleados.setCargoId(datos.getCargoId());
            empleados.setEmail(datos.getEmail());
            empleados.setFechaContratacion(datos.getFechaContratacion());
            empleados.setSalario(datos.getSalario());
            empleados.setTurno_id(datos.getTurno_id());
            empleados.setEstado(Long.parseLong("1"));
        } else {
            empleados = empleadoExistente.get();
            empleados.setFechaAdicion(fechaAhora);
            empleados.setUsuarioModificacion(String.valueOf(datos.getNit()));
        }

        Empleados empleado = empleadoRepository.save(empleados);

        if (nuevo) {
            String[] toUser = {empleados.getEmail()};
            String mensaje = "Se ha creado su usuario";
            email.sendEmail(toUser, "CREACION DE USUARIO", mensaje);
        }
        return empleado;
    }

    public List<empleadoProjection> listaEmpleado() {
        return this.empleadoRepository.showEmpleados();
    }

    public List<RHProjection> listaEmpleadoRH() {
        return this.empleadoRepository.showEmpleadosbyRH();
    }

    /**
     * Autentica a un usuario y genera un token JWT para él.
     *
     * @param loginRequest Los datos de inicio de sesión del usuario.
     * @return Un ResponseEntity con el token JWT y otros datos si la
     * autenticación es exitosa.
     */
    public ResponseEntity<?> logueo(LoginRequest loginRequest) throws JOSEException {
        Empleados user = this.empleadoRepository.findEmpleadoByNit(loginRequest.getUsername());

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        // Verificar si la contraseña proporcionada coincide con la almacenada en la base de datos
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getContrasena())) {

            System.out.println("Credeciales iivallidas");
            throw new BadCredentialsException("Credenciales incorrectas");
        }
        // Autenticación exitosa, generar el token JWT y devolver los datos adicionales
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = generateJwtToken(loginRequest.getUsername());

        LoginResponse loginResponse = new LoginResponse(jwt, user.getNit(), "administrador");
        return ResponseEntity.ok(loginResponse);
    }

    public String generateJwtToken(String authentication) throws JOSEException {
        return jwtTokenProvider.generateToken(authentication);
    }

    public Empleados findUsuarioByUsername(String userame) {
        return empleadoRepository.findEmpleadoByNit(userame);
    }

}
