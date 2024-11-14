package egg.spring.back.Services;

import egg.spring.back.Modells.FabricaModel;
import java.util.List;

public interface IFabricaService {
    FabricaModel crearFabrica(FabricaModel fabrica);
    List<FabricaModel> obtenerTodasLasFabricas();
    FabricaModel actualizarFabrica(FabricaModel fabrica);
    void eliminarFabrica(String id);
}
