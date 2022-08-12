package ifg.edu.rayhbank.service.implementations;

import ifg.edu.rayhbank.domain.Utils;
import ifg.edu.rayhbank.repository.UtilsRepository;
import ifg.edu.rayhbank.service.UtilsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilsServiceImplementation implements UtilsService {

    private final UtilsRepository utilsRepository;
    @Override
    public List<Utils> findByTipo(String tipo) {
        return utilsRepository.findUtilsByTipoContainingIgnoreCase( tipo );
    }

    @Override
    public Utils findById(Integer id) {
        return utilsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "util not found"));
    }
}
