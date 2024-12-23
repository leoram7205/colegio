package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.DimensionesDao;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.DimensionesDto;
import com.uan.colegio.entity.Dimensiones;
import com.uan.colegio.service.DimensionesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class DimensionesServiceImpl extends GenericServiceImpl<Dimensiones, UUID> implements DimensionesService {

    @Autowired
	private DimensionesDao dimensionesDao;


    @Override
    public List<DimensionesDto> findAll() {
        List<DimensionesDto> listaDimensionesDto = new ArrayList<>();

		Iterable<Dimensiones> dimensionesItr = this.dimensionesDao.findAll();

		for (Dimensiones dimensiones : dimensionesItr) {

			DimensionesDto dimensionesDto = new DimensionesDto();
			dimensionesDto = MHelpers.modelMapper().map(dimensiones, DimensionesDto.class);
            dimensionesDto.setColegiosDto(MHelpers.modelMapper().map(dimensiones.getColegios(), ColegiosDto.class));
			listaDimensionesDto.add(dimensionesDto);
		}

		return listaDimensionesDto;
    }

    @Override
    public DimensionesDto findByid(UUID id) {
        Optional<Dimensiones> dimensiones = this.dimensionesDao.findById(id);
		DimensionesDto dimensionesDto = MHelpers.modelMapper().map(dimensiones.get(), DimensionesDto.class);
        dimensionesDto.setColegiosDto(MHelpers.modelMapper().map(dimensiones.get().getColegios(), ColegiosDto.class));

		return dimensionesDto;
    }

    @Override
    public DimensionesDto save(DimensionesDto DimensionesDto) {
        Dimensiones Dimensiones = MHelpers.modelMapper().map(DimensionesDto, Dimensiones.class);

		Dimensiones = this.dimensionesDao.save(Dimensiones);
		DimensionesDto = MHelpers.modelMapper().map(Dimensiones, DimensionesDto.class);

		return DimensionesDto;
    }

    @Override
    public void delete(DimensionesDto DimensionesDto) {
        Dimensiones Dimensiones = MHelpers.modelMapper().map(DimensionesDto, Dimensiones.class);
		this.dimensionesDao.delete(Dimensiones);
    }

    @Override
    public void deleteById(UUID id) {
        dimensionesDao.deleteById(id);
    }

    @Override
    public CrudRepository<Dimensiones, UUID> getDao() {
        return dimensionesDao;
    }
    
}
