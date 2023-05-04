package com.ues.dsi.sistemaadopcionbackend.services;

import com.ues.dsi.sistemaadopcionbackend.models.entity.Mascota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface MascotaService {

    Page<Mascota> getAllMascotas(Pageable pageable);

    List<Mascota> getAllMascotas();

    Mascota getMascotaById(Long idMascota);

    List<Mascota> searchByNombre(String nombre);

    List<Mascota> findByNombre(String nombre);

    List<Mascota> findByRaza(String raza);

    List<Mascota> findByEspecie(String especie);

    List<Mascota> findByGenero(String genero);

    List<Mascota> findByFechaNacimiento(String fechaNacimiento);

    Mascota findMascotaByNombre(String nombre);

    Mascota createMascota(Mascota mascota);

    Mascota editMascota(Long idMascota, Mascota mascota);

    void deleteMascota(Long idMascota);

}
