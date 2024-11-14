package egg.spring.back.Controllers;

import egg.spring.back.Modells.ArticuloModel;
import egg.spring.back.Services.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar artículos.
 * Proporciona endpoints para crear, obtener, actualizar y eliminar artículos.
 * 
 * Endpoints:
 * 
 * POST /api/articulos
 * - Descripción: Crea un nuevo artículo.
 * - Ejemplo de uso en Postman:
 *   - Método: POST
 *   - URL: http://localhost:8080/api/articulos
 *   - Body (JSON):
 *     {
 *       "nombreArticulo": "Cable de cobre",
 *       "descripcionArticulo": "Cable de alta resistencia",
 *       "fabrica": {
 *           "idFabrica": "a3b2c1d4-e5f6-7890-ab12-cd34ef567890"
 *       }
 *     }
 *   - Respuesta exitosa (201 Created):
 *     {
 *       "idArticulo": "f7e8d9c0-b1a2-3456-df78-9101cd23ef45",
 *       "nroArticulo": 1,
 *       "nombreArticulo": "Cable de cobre",
 *       "descripcionArticulo": "Cable de alta resistencia",
 *       "fabrica": {
 *           "idFabrica": "a3b2c1d4-e5f6-7890-ab12-cd34ef567890",
 *           "nombreFabrica": "Fabrica Central"
 *       }
 *     }
 * 
 * GET /api/articulos
 * - Descripción: Obtiene todos los artículos disponibles.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/articulos
 * 
 * PUT /api/articulos/{id}
 * - Descripción: Actualiza un artículo existente.
 * - Ejemplo de uso en Postman:
 *   - Método: PUT
 *   - URL: http://localhost:8080/api/articulos/{id}
 *   - Body (JSON):
 *     {
 *       "nombreArticulo": "Cable de cobre actualizado",
 *       "descripcionArticulo": "Cable de alta resistencia actualizado",
 *       "fabrica": {
 *           "idFabrica": "a3b2c1d4-e5f6-7890-ab12-cd34ef567890"
 *       }
 *     }
 * 
 * DELETE /api/articulos/{id}
 * - Descripción: Elimina un artículo por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: DELETE
 *   - URL: http://localhost:8080/api/articulos/{id}
 */

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final IArticuloService articuloService;

    @Autowired
    public ArticuloController(IArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    /**
     * Crea un nuevo artículo.
     * @param articulo Objeto de tipo ArticuloModel que contiene la información del artículo a crear.
     * @return El artículo creado junto con un código de estado 201 Created.
     */
    @PostMapping
    public ResponseEntity<ArticuloModel> crearArticulo(@RequestBody ArticuloModel articulo) {
        ArticuloModel nuevoArticulo = articuloService.crearArticulo(articulo);
        return new ResponseEntity<>(nuevoArticulo, HttpStatus.CREATED);
    }

    /**
     * Obtiene todos los artículos disponibles.
     * @return Lista de todos los artículos.
     */
    @GetMapping
    public List<ArticuloModel> obtenerTodosLosArticulos() {
        return articuloService.obtenerTodosLosArticulos();
    }

    /**
     * Actualiza un artículo existente.
     * @param id ID del artículo a actualizar.
     * @param articulo Objeto de tipo ArticuloModel que contiene los datos actualizados del artículo.
     * @return El artículo actualizado junto con un código de estado 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ArticuloModel> actualizarArticulo(@PathVariable String id, @RequestBody ArticuloModel articulo) {
        articulo.setIdArticulo(id);
        ArticuloModel articuloActualizado = articuloService.actualizarArticulo(articulo);
        return ResponseEntity.ok(articuloActualizado);
    }

    /**
     * Elimina un artículo por su ID.
     * @param id ID del artículo a eliminar.
     * @return Respuesta sin contenido con un código de estado 204 No Content si la eliminación es exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable String id) {
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}
