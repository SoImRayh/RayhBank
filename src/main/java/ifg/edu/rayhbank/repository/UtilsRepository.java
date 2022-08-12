package ifg.edu.rayhbank.repository;

import ifg.edu.rayhbank.domain.Utils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilsRepository extends JpaRepository<Utils, Integer> {

    public List<Utils> findUtilsByTipoContainingIgnoreCase(String tipo);
}
