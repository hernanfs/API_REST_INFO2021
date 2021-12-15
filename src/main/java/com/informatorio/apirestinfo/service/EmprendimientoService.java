package com.informatorio.apirestinfo.service;

import com.informatorio.apirestinfo.entity.Emprendimiento;
import com.informatorio.apirestinfo.entity.Tag;
import com.informatorio.apirestinfo.entity.Usuario;
import com.informatorio.apirestinfo.repository.EmprendimientoRepository;
import com.informatorio.apirestinfo.repository.TagRepository;
import com.informatorio.apirestinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class EmprendimientoService {
    private EmprendimientoRepository emprendimientoRepository;
    private UsuarioRepository usuarioRepository;
    private TagRepository tagRepository;

    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository,
                                 UsuarioRepository usuarioRepository,TagRepository tagRepository){
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    public Emprendimiento guardar(Long usuarioId, Emprendimiento emprendimiento){
        Usuario usuario = usuarioRepository.getById(usuarioId);
        emprendimiento.setCreador(usuario);
        return emprendimientoRepository.save(emprendimiento);
    }

    public Emprendimiento modificar(Long id, Emprendimiento emprendimiento){
        Emprendimiento emprendimientoModificado = emprendimientoRepository.getById(id);
        if (!emprendimiento.getNombre().trim().isEmpty()){
            emprendimientoModificado.setNombre(emprendimiento.getNombre());
        }
        if (!emprendimiento.getDescripcion().trim().isEmpty()){
            emprendimientoModificado.setDescripcion(emprendimiento.getDescripcion());
        }
        if (!emprendimiento.getContenido().trim().isEmpty()) {
            emprendimientoModificado.setContenido(emprendimiento.getContenido());
        }
        if (emprendimiento.getObjetivo() != null && emprendimiento.getObjetivo() > 0) {
            emprendimientoModificado.setObjetivo(emprendimiento.getObjetivo());
        }
        if (!emprendimiento.isPublicado()) {
            emprendimientoModificado.setPublicado(false);
        }
        if (emprendimiento.isPublicado()) {
            emprendimientoModificado.setPublicado(true);
        }
        if (emprendimiento.getUrl() != null) {
            emprendimientoModificado.setUrl(emprendimiento.getUrl()); }
        if (emprendimiento.getTags() != null) {
            emprendimientoModificado.setTags(emprendimiento.getTags());
        }
        return emprendimientoRepository.save(emprendimientoModificado);
    }

    public Emprendimiento eliminar(Long id, Emprendimiento emprendimiento){
        Emprendimiento emprendimientoEliminado = emprendimientoRepository.getById(id);
        emprendimientoEliminado.setActivo(false);
        return emprendimientoRepository.save(emprendimientoEliminado);
    }

    public List<Emprendimiento> obtenerTodos(String nombre){
        if (nombre != null){
            Tag tag = tagRepository.findByNombre(nombre);
            return tag.getEmprendimientos();
        }
        else {
            return emprendimientoRepository.findAll();
        }
    }

    public Stream<Emprendimiento> obtenerNoPublicados(){
        return emprendimientoRepository.findAll().stream()
                .filter(Predicate.not(Emprendimiento::isPublicado));
    }


}
