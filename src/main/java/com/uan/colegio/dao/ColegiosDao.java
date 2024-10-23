package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Colegios;


@Configuration
public interface ColegiosDao extends CrudRepository<Colegios, UUID>{

}
