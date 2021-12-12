package com.informatorio.apirestinfo.controller;

import com.informatorio.apirestinfo.entity.Emprendimiento;
import com.informatorio.apirestinfo.repository.EmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value= "/emprendimiento")
public class EmprendimientoController {

    private final EmprendimientoRepository emprendimientoRepository;

    @Autowired
    public EmprendimientoController(EmprendimientoRepository emprendimientoRepository){
        this.emprendimientoRepository = emprendimientoRepository;
    }

    @PostMapping
    public ResponseEntity<?> createEmprendimiento(@Valid @RequestBody Emprendimiento emprendimiento){
        return new ResponseEntity<>(emprendimientoRepository.save(emprendimiento), HttpStatus.CREATED);
    }
    
}
