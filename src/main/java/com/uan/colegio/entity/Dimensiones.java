package com.uan.colegio.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dimensiones")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dimensiones {
    @Id
    @GeneratedValue(generator = "uuid2")
	private UUID dmLlave;
    @ManyToOne
    @JoinColumn(name = "dm_colegio")
	private Colegios colegios;
    private String dmCodigo;
	private String dmNombre;
    private Boolean dmEstado;
}
