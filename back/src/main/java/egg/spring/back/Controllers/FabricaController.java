package egg.spring.back.Controllers;

import egg.spring.back.Modells.FabricaModel;
import egg.spring.back.Services.IFabricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar fábricas.
 * Proporciona endpoints para crear, obtener, actualizar y eliminar fábricas.
 * 
 * Endpoints:
 * 
 * POST /api/fabricas
 * - Descripción: Crea una nueva fábrica.
 * - Ejemplo de uso en Postman:
 *   - Método: POST
 *   - URL: http://localhost:8080/api/fabricas
 *   - Body (JSON):
 *     {
 *       "nombreFabrica": "Fabrica Central"
 *     }
 *   - Respuesta exitosa (201 Created):
 *     {
 *       "idFabrica": "a3b2c1d4-e5f6-7890-ab12-cd34ef567890",
 *       "nombreFabrica": "Fabrica Central"
 *     }
 * 
 * GET /api/fabricas
 * - Descripción: Obtiene todas las fábricas registradas.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/fabricas
 *   - Respuesta exitosa (200 OK):
 *     [
 *       {
 *         "idFabrica": "a3b2c1d4-e5f6-7890-ab12-cd34ef567890",
 *         "nombreFabrica": "Fabrica Central"
 *       },
 *       {
 *         "idFabrica": "f7e8d9c0-b1a2-3456-df78-9101cd23ef45",
 *         "nombreFabrica": "Fabrica Norte"
 *       }
 *     ]
 * 
 * PUT /api/fabricas/{id}
 * - Descripción: Actualiza una fábrica existente.
 * - Ejemplo de uso en Postman:
 *   - Método: PUT
 *   - URL: http://localhost:8080/api/fabricas/{id}
 *   - Body (JSON):
 *     {
 *       "nombreFabrica": "Fabrica Central Actualizada"
 *     }
 *   - Respuesta exitosa (200 OK):
 *     {
 *       "idFabrica": "a3b2c1d4-e5f6-7890-ab12-cd34ef567890",
 *       "nombreFabrica": "Fabrica Central Actualizada"
 *     }
 * 
 * DELETE /api/fabricas/{id}
 * - Descripción: Elimina una fábrica por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: DELETE
 *   - URL: http://localhost:8080/api/fabricas/{id}
 *   - Respuesta exitosa (204 No Content): No retorna contenido si la eliminación es exitosa.
 */

@RestController
@RequestMapping("/api/fabricas")
public class FabricaController {

    private final IFabricaService fabricaService;

    @Autowired
    public FabricaController(IFabricaService fabricaService) {
        this.fabricaService = fabricaService;
    }

    /**
     * Crea una nueva fábrica.
     * @param fabrica Objeto de tipo FabricaModel que contiene la información de la fábrica a crear.
     * @return La fábrica creada junto con un código de estado 201 Created.
     */
    @PostMapping
    public ResponseEntity<FabricaModel> crearFabrica(@RequestBody FabricaModel fabrica) {
        FabricaModel nuevaFabrica = fabricaService.crearFabrica(fabrica);
        return new ResponseEntity<>(nuevaFabrica, HttpStatus.CREATED);
    }

    /**
     * Obtiene todas las fábricas registradas.
     * @return Lista de todas las fábricas.
     */
    @GetMapping
    public List<FabricaModel> obtenerTodasLasFabricas() {
        return fabricaService.obtenerTodasLasFabricas();
    }

    /**
     * Actualiza una fábrica existente.
     * @param id ID de la fábrica a actualizar.
     * @param fabrica Objeto de tipo FabricaModel que contiene los datos actualizados de la fábrica.
     * @return La fábrica actualizada junto con un código de estado 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FabricaModel> actualizarFabrica(@PathVariable String id, @RequestBody FabricaModel fabrica) {
        fabrica.setIdFabrica(id);
        FabricaModel fabricaActualizada = fabricaService.actualizarFabrica(fabrica);
        return ResponseEntity.ok(fabricaActualizada);
    }

    /**
     * Elimina una fábrica por su ID.
     * @param id ID de la fábrica a eliminar.
     * @return Respuesta sin contenido con un código de estado 204 No Content si la eliminación es exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFabrica(@PathVariable String id) {
        fabricaService.eliminarFabrica(id);
        return ResponseEntity.noContent().build();
    }
}
