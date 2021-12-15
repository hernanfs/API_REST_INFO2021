package com.informatorio.apirestinfo.converter;

import com.informatorio.apirestinfo.dto.VotoDTO;
import com.informatorio.apirestinfo.entity.Voto;
import com.informatorio.apirestinfo.repository.EmprendimientoRepository;
import com.informatorio.apirestinfo.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VotoDTOVotoConverter implements Converter<VotoDTO, Voto> {
    public VotoDTOVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmpredimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    }
}