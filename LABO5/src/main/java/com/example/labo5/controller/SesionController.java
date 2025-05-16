package com.example.labo5.controller;
import com.example.labo5.entity.Usuario;
import com.example.labo5.repository.RolRepository;
import com.example.labo5.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class SesionController {

    final UsuarioRepository usuarioRepository;
    final RolRepository rolRepository;

    public SesionController(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String logueo(@RequestParam String email, @RequestParam String pwd, Model model, HttpSession session){

        Optional<Usuario> ses = usuarioRepository.findByEmailAndPassword(email, pwd);

        if (ses.isPresent()){
            Usuario usuario = ses.get();
            session.setAttribute("loggedUser", usuario);

            String nombreRol = usuario.getRol().getNombre();
            switch(nombreRol){
                case "ADMIN":
                    return "redirect:/admin";
                case "USER":
                    return "redirect:/user";
                default:
                    return "redirect:/";
            }
        }

        // Falló autenticación
        model.addAttribute("error", "Falló la autenticación");
        return "registro/login";
    }

}
