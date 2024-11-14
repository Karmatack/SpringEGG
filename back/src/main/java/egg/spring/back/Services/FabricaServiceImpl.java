package egg.spring.back.Services;

import egg.spring.back.Modells.FabricaModel;
import egg.spring.back.Repositories.FabricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FabricaServiceImpl implements IFabricaService {

    private final FabricaRepository fabricaRepository;

    @Autowired
    public FabricaServiceImpl(FabricaRepository fabricaRepository) {
        this.fabricaRepository = fabricaRepository;
    }

    @Override
    public FabricaModel crearFabrica(FabricaModel fabrica) {
        return fabricaRepository.save(fabrica);
    }

    @Override
    public List<FabricaModel> obtenerTodasLasFabricas() {
        return fabricaRepository.findAll();
    }

    @Override
    public FabricaModel actualizarFabrica(FabricaModel fabrica) {
        return fabricaRepository.save(fabrica);
    }

    @Override
    public void eliminarFabrica(String id) {
        fabricaRepository.deleteById(id);
    }
}
