package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.Banco;
import ifg.edu.rayhbank.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BancoService {

    private final BancoRepository bancoRepository;

    public List<Banco> listAll(){
        return bancoRepository.findAll();
    }

    public Banco findById(Long id){
    return bancoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "banco não encontrado"));
    }

    public Banco save(Banco banco) {
        return bancoRepository.save(banco);
    }
}
