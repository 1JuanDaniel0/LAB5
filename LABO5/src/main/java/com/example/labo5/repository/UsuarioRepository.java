package com.example.labo5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.labo5.entity.Usuario;
import com.example.labo5.entity.Rol;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByDNI(String dni);
    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByRol(Rol rol);
    Optional<Usuario> findByEmailAndPassword(String email, String pwd);
}
