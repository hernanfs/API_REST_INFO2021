package com.informatorio.apirestinfo.repository;

import com.informatorio.apirestinfo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("from Usuario where fechaDeCreacion >= ?1")
    List<Usuario> findByFechaDeCreacion(LocalDateTime fechaDeCreacion);

    @Query ("from Usuario where ciudad like %:name% ")
    List<Usuario> findByCiudad(@Param("name") String Ciudad);


}
