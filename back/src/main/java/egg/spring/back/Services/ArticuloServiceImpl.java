package egg.spring.back.Services;

import egg.spring.back.Modells.ArticuloModel;
import egg.spring.back.Repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticuloServiceImpl implements IArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public ArticuloModel crearArticulo(ArticuloModel articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public List<ArticuloModel> obtenerTodosLosArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public ArticuloModel actualizarArticulo(ArticuloModel articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(String id) {
        articuloRepository.deleteById(id);
    }
}
