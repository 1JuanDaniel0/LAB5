package com.example.labo5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.labo5.entity.Usuario;
import com.example.labo5.entity.Rol;

import java.util.Optional;
import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByIdrol(Integer idrol);
    Rol findByNombre(String nombre);
}
