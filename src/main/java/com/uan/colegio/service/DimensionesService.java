package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.DimensionesDto;
import com.uan.colegio.entity.Dimensiones;

public interface DimensionesService extends GenericService<Dimensiones, UUID>{
    public List<DimensionesDto> findAll();
	public DimensionesDto findByid(UUID id);
	public DimensionesDto save(DimensionesDto dimensionesDto) ;
	void delete(DimensionesDto dimensionesDto);
	void deleteById(UUID id);
}
