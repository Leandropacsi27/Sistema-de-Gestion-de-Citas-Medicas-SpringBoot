package com.leandro.citas.controller;

import com.leandro.citas.model.Cita;
import com.leandro.citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaRepository.save(cita);
    }

    @PutMapping("/{id}")
    public Cita updateCita(@PathVariable Long id, @RequestBody Cita cita) {
        cita.setId(id);
        return citaRepository.save(cita);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id) {
        citaRepository.deleteById(id);
    }
}