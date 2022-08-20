package me.dio.academia.digital.init;

import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
//    usuarios para teste

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @Override
    public void run(String... args) {
        Usuario usuario = repository.findByUsername("admin");
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setUsername("admin");
            usuario.setPassword("admin");
            usuario.getPerfis().add("MANAGER");
            repository.save(usuario);
        }

        usuario = repository.findByUsername("user");
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setUsername("user");
            usuario.setPassword("123");
            usuario.getPerfis().add("USER");
            repository.save(usuario);
        }
    }
}
