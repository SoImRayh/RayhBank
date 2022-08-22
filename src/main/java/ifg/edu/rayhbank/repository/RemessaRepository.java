package ifg.edu.rayhbank.repository;

import ifg.edu.rayhbank.domain.Remessa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RemessaRepository extends JpaRepository<Remessa, UUID> {
}
