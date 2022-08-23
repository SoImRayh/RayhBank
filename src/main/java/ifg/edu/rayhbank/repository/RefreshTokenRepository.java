package ifg.edu.rayhbank.repository;

import ifg.edu.rayhbank.domain.RefreshToken;
import ifg.edu.rayhbank.service.RefreshTokenService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
