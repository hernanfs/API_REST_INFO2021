package com.informatorio.apirestinfo.repository;

import com.informatorio.apirestinfo.entity.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Long> {

    @Query("from Emprendimiento where tags like %:tag%")
    List<Emprendimiento> findByTag(@Param("tag") String tag);

    @Query("from Emprendimiento where publicado = false ")
    List<Emprendimiento> findByEstado();

}
