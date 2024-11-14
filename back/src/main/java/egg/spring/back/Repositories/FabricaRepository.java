package egg.spring.back.Repositories;

import egg.spring.back.Modells.FabricaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricaRepository extends JpaRepository<FabricaModel, String> {
}
