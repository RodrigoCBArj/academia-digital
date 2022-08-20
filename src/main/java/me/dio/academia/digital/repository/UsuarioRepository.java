package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("SELECT u FROM Usuario u JOIN FETCH u.perfis WHERE u.username = :username")
//    Usuario findByUsername(@Param("username") String username);

    Usuario findByUsername (String username);
}
