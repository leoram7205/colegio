package com.uan.colegio.entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnos_documentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosDocumentos {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID adLlave;
    private UUID adColegio;
    private UUID adAlumno;
    
    private byte[] adFormInscripcionMatricula;
    private byte[] adRegistroCivilNac;
    private byte[] adCarneVacunas;
    private byte[] adCertAfiliacionEpsPrepagada;
    private byte[] adFotos;
    private byte[] adCertCrecimientoDesarrollo;
    private byte[] adCertValoracionVisualAuditiva;
    private byte[] adCedulaMadre;
    private byte[] adCedulaPadre;
    private byte[] adContratoPrestServicios;
}