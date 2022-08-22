package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.Remessa;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@Service
public interface RemessaService {
    Remessa save(MultipartFile file);

    Optional<Remessa> getOne(UUID uuid);
}
