package com.ues.dsi.sistemaadopcionbackend.models.repository;

import com.ues.dsi.sistemaadopcionbackend.models.entity.Mascota;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    
    List<Mascota> findMascotasByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    List<Mascota> findAllByNombre(String nombre);
    List<Mascota> findAllByRaza(String raza);
    List<Mascota> findAllByEspecie(String especie);
    List<Mascota> findAllByGenero(String genero);
    List<Mascota> findAllByFechaNacimiento(String fechaNacimiento);

    Mascota findMascotaByNombre(String nombre);
    Boolean existsByNombre(String nombre);
}