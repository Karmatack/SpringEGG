package egg.spring.back.Services;

import egg.spring.back.Modells.UsuarioModel;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    UsuarioModel crearUsuario(UsuarioModel usuario);
    
    Optional<UsuarioModel> obtenerUsuarioPorId(String id);
    Optional<UsuarioModel> obtenerUsuarioPorUsername(String username);
    List<UsuarioModel> obtenerTodosLosUsuarios();
    UsuarioModel actualizarUsuario(UsuarioModel usuario);
    void eliminarUsuario(String id);
}
