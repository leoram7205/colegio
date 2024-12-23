package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Dimensiones;

@Configuration
public interface DimensionesDao extends CrudRepository<Dimensiones, UUID>{
    
}
