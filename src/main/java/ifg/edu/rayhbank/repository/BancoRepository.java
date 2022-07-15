package ifg.edu.rayhbank.repository;

import ifg.edu.rayhbank.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}
