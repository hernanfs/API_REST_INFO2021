package com.informatorio.apirestinfo.service;

import java.util.List;

import com.informatorio.apirestinfo.dto.VotoDTO;
import com.informatorio.apirestinfo.entity.Emprendimiento;
import com.informatorio.apirestinfo.entity.Voto;
import com.informatorio.apirestinfo.repository.EmprendimientoRepository;
import com.informatorio.apirestinfo.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final Converter<VotoDTO, Voto> votoDTOVotoConverter;
    private final VotoRepository votoRepository;

    @Autowired
    public VotoService(EmprendimientoRepository emprendimientoRepository,
                       Converter<VotoDTO, Voto> votoDTOVotoConverter,
                       VotoRepository votoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.votoDTOVotoConverter = votoDTOVotoConverter;
        this.votoRepository = votoRepository;
    }
    public boolean chequearVoto(VotoDTO votoDTO){
        Voto voto = votoDTOVotoConverter.convert(votoDTO);
        return votoRepository.findAll().stream().anyMatch(v -> {
            assert voto != null;
            return v.getUsuarioId().equals(voto.getUsuarioId()) && v.getEmprendimientoId().equals(voto.getEmprendimientoId());
        });
    }
    public Boolean crearVoto(VotoDTO votoDTO) {
        Voto voto = votoDTOVotoConverter.convert(votoDTO);
        if(!chequearVoto(votoDTO)){
            assert voto != null;
            Emprendimiento emprendimiento = emprendimientoRepository.getById(voto.getEmprendimientoId());
            emprendimiento.setContadorDeVotos(emprendimiento.getContadorDeVotos()+1);
            emprendimientoRepository.save(emprendimiento);
            votoRepository.save(voto);
            return true;
        }
        return false;
    }
    public List<Voto> obtenerVotos(Long usuarioId) {
        return votoRepository.findByUsuarioId(usuarioId);
    }
}