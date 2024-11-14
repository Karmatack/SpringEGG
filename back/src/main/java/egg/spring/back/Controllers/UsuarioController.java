package egg.spring.back.Controllers;

import egg.spring.back.Modells.UsuarioModel;
import egg.spring.back.Services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar usuarios.
 * Proporciona endpoints para crear, obtener, actualizar y eliminar usuarios.
 * 
 * Endpoints:
 * 
 * POST /api/usuarios
 * - Descripción: Crea un nuevo usuario.
 * - Ejemplo de uso en Postman:
 *   - Método: POST
 *   - URL: http://localhost:8080/usuarios
 *   - Body (JSON):
 *     {
 *       "username": "juan@example.com",
 *       "nombre": "Juan",
 *       "apellido": "Pérez",
 *       "rol": "USER" // Opcional, si no se especifica, se asignará USER
 *     }
 *   - Respuesta exitosa (201 Created):
 *     {
 *       "idUsuario": "123e4567-e89b-12d3-a456-426614174000",
 *       "username": "juan@example.com",
 *       "nombre": "Juan",
 *       "apellido": "Pérez",
 *       "rol": "USER"
 *     }
 * 
 * GET /api/usuarios/{id}
 * - Descripción: Obtiene un usuario por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/usuarios/{id}
 *   - Respuesta exitosa (200 OK):
 *     {
 *       "idUsuario": "123e4567-e89b-12d3-a456-426614174000",
 *       "username": "juan@example.com",
 *       "nombre": "Juan",
 *       "apellido": "Pérez",
 *       "rol": "USER"
 *     }
 * 
 * GET /api/usuarios
 * - Descripción: Obtiene todos los usuarios.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/usuarios
 *   - Respuesta exitosa (200 OK):
 *     [
 *       {
 *         "idUsuario": "123e4567-e89b-12d3-a456-426614174000",
 *         "username": "juan@example.com",
 *         "nombre": "Juan",
 *         "apellido": "Pérez",
 *         "rol": "USER"
 *       },
 *       {
 *         "idUsuario": "789e4567-e89b-12d3-a456-426614174111",
 *         "username": "ana@example.com",
 *         "nombre": "Ana",
 *         "apellido": "López",
 *         "rol": "ADMIN"
 *       }
 *     ]
 * 
 * PUT /api/usuarios/{id}
 * - Descripción: Actualiza un usuario existente.
 * - Ejemplo de uso en Postman:
 *   - Método: PUT
 *   - URL: http://localhost:8080/usuarios/{id}
 *   - Body (JSON):
 *     {
 *       "username": "juan.actualizado@example.com",
 *       "nombre": "Juan Actualizado",
 *       "apellido": "Pérez",
 *       "rol": "ADMIN" // Opcional, puedes actualizar el rol
 *     }
 *   - Respuesta exitosa (200 OK):
 *     {
 *       "idUsuario": "123e4567-e89b-12d3-a456-426614174000",
 *       "username": "juan.actualizado@example.com",
 *       "nombre": "Juan Actualizado",
 *       "apellido": "Pérez",
 *       "rol": "ADMIN"
 *     }
 * 
 * DELETE /api/usuarios/{id}
 * - Descripción: Elimina un usuario por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: DELETE
 *   - URL: http://localhost:8080/usuarios/{id}
 *   - Respuesta exitosa (204 No Content): No retorna contenido si la eliminación es exitosa.
 */

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel nuevoUsuario = usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable String id) {
        Optional<UsuarioModel> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UsuarioModel> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable String id, @RequestBody UsuarioModel usuario) {
        usuario.setIdUsuario(id);
        UsuarioModel usuarioActualizado = usuarioService.actualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
