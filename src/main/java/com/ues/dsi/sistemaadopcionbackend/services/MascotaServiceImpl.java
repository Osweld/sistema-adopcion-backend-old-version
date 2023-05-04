package com.ues.dsi.sistemaadopcionbackend.services;

import com.ues.dsi.sistemaadopcionbackend.exceptions.UniqueValidationException;
import com.ues.dsi.sistemaadopcionbackend.models.entity.Mascota;
import com.ues.dsi.sistemaadopcionbackend.models.repository.MascotaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Mascota> getAllMascotas(Pageable pageable) {
        return mascotaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota getMascotaById(Long idMascota) {
        return mascotaRepository.getReferenceById(idMascota);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> searchByNombre(String nombre) {
        return mascotaRepository.findMascotasByNombreContainingIgnoreCase(nombre, PageRequest.of(0,5));
    }

    @Override
    @Transactional
    public List<Mascota> findByNombre(String nombre) {
        return mascotaRepository.findAllByNombre(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Mascota findMascotaByNombre(String nombre) {
        return mascotaRepository.findMascotaByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> findByRaza(String raza) {
        return mascotaRepository.findAllByRaza(raza);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> findByEspecie(String especie) {
        return mascotaRepository.findAllByEspecie(especie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> findByGenero(String genero) {
        return mascotaRepository.findAllByGenero(genero);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> findByFechaNacimiento(String fechaNacimiento) {
        return mascotaRepository.findAllByFechaNacimiento(fechaNacimiento);
    }

    @Override
    @Transactional
    public Mascota createMascota(Mascota mascota) {
        if(mascotaRepository.existsByNombre(mascota.getNombre()))
            throw new UniqueValidationException("Ya existe la mascota con el nombre ingresado");
        return mascotaRepository.saveAndFlush(mascota);
    }

    @Override
    @Transactional
    public Mascota editMascota(Long idMascota, Mascota mascota) {
        return mascotaRepository.findById(idMascota).map( mascotaDB -> {
            if(!mascotaDB.getNombre().equals(mascota.getNombre())
                    && mascotaRepository.existsByNombre(mascota.getNombre()))
                throw new UniqueValidationException("Ya existe la mascota con el nombre ingresado");
            mascotaDB.setNombre(mascota.getNombre());
            mascotaDB.setFechaNacimiento(mascota.getFechaNacimiento());
            mascotaDB.setEspecie(mascota.getEspecie());
            mascotaDB.setGenero(mascota.getGenero());
            mascotaDB.setRaza(mascota.getRaza());
            mascotaDB.setColor(mascota.getColor());
            mascotaDB.setEstadoSalud(mascota.getEstadoSalud());
            mascotaDB.setDescripcion(mascota.getDescripcion());
            return mascotaRepository.save(mascotaDB);
        }).orElseThrow();
    }

    @Override
    @Transactional
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

}
