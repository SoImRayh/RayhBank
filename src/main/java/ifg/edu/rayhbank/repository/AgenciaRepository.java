package ifg.edu.rayhbank.repository;

import ifg.edu.rayhbank.domain.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
}
