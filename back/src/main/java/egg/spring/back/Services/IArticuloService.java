package egg.spring.back.Services;

import egg.spring.back.Modells.ArticuloModel;
import java.util.List;

public interface IArticuloService {
    ArticuloModel crearArticulo(ArticuloModel articulo);
    List<ArticuloModel> obtenerTodosLosArticulos();
    ArticuloModel actualizarArticulo(ArticuloModel articulo);
    void eliminarArticulo(String id);
}
