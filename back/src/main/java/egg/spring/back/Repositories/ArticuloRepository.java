package egg.spring.back.Repositories;

import egg.spring.back.Modells.ArticuloModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<ArticuloModel, String> {
}
