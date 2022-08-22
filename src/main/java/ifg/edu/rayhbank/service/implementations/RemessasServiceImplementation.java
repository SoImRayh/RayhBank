package ifg.edu.rayhbank.service.implementations;

import ifg.edu.rayhbank.domain.Remessa;
import ifg.edu.rayhbank.repository.RemessaRepository;
import ifg.edu.rayhbank.service.RemessaService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemessasServiceImplementation implements RemessaService {

    private final RemessaRepository repository;
    @Override
    public Remessa save(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if (fileName.contains("..")){
                throw new Exception("filename contains invalid sequence "+fileName);
            }

            var remessa = new Remessa(fileName,file.getContentType(),file.getBytes());
            return repository.save(remessa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Remessa> getOne(UUID uuid) {
        return repository.findById(uuid);
    }
}
