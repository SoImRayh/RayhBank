package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.Agencia;
import ifg.edu.rayhbank.repository.AgenciaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AgenciaService {
    private final AgenciaRepository agenciaRepository;


    public List<Agencia> findAll( ) {
        return agenciaRepository.findAll();
    }

    public Agencia findById(Integer id) {
        return agenciaRepository.findById(id).orElseThrow( () ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "agencia nao encontrada"));
    }

    public Agencia save(@Valid Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    public Agencia update( Agencia agencia) {
        if(agenciaRepository.findById(agencia.getId()) != null){
            agenciaRepository.save(agencia);
            return agencia;
        }else{
            throw new
                    ResponseStatusException(HttpStatus.BAD_REQUEST,  "agencia nao existente");
        }

    }

    public Void delete(Integer id) {
        if (agenciaRepository.findById(id) != null){
            agenciaRepository.delete(agenciaRepository.findById(id).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "agencia nao encontrada")
            ));
        }
        return null;
    }
}
