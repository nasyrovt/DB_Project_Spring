package nasyrov.takhir.spring.boot.db.project;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VeloRepository extends CrudRepository<Velo, Long> {

    List<Velo> findByModeleName(String modeleName);

    Velo findById(long id);
}