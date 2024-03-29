package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.Banco;
import ifg.edu.rayhbank.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Banco findById(Integer id){
    return bancoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "banco não encontrado"));
    }

    public Banco save(Banco banco) {
        return bancoRepository.save(banco);
    }

    public Void delete(Integer id){
        Banco banco = findById(id);
        if(banco != null){
            bancoRepository.delete(banco);
        }
        return null;
    }

    public Banco update(Banco banco) {
        if(findById(banco.getId()) != null){

            bancoRepository.save(banco);
            return banco;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "banco nao existente");
        }

    }

    public List<Banco> findWithFilter(String filtro){
        return bancoRepository.findByNomeContaining(filtro);
    }
}
