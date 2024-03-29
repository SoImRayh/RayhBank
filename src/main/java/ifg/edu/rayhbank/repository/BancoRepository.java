package ifg.edu.rayhbank.repository;

import ifg.edu.rayhbank.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

    public List<Banco> findByNomeContaining(String filtro);
}
