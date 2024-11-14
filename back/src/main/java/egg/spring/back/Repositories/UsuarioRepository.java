package egg.spring.back.Repositories;

import egg.spring.back.Modells.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
    Optional<UsuarioModel> findByUsername(String username); // Para buscar usuarios por correo electrónico
}
