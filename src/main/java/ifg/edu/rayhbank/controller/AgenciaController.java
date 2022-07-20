package ifg.edu.rayhbank.controller;


import ifg.edu.rayhbank.domain.Agencia;
import ifg.edu.rayhbank.repository.AgenciaRepository;
import ifg.edu.rayhbank.service.AgenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/agencias")
@Component
@RequiredArgsConstructor
public class AgenciaController {
    private final AgenciaService agenciaService;

    @GetMapping
    public ResponseEntity<Page<Agencia>> findall(Pageable pageable){
        return new ResponseEntity<>(agenciaService.findAll(pageable) , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agencia> findbyId(@PathVariable Integer id){
        return new ResponseEntity<>(agenciaService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Agencia> create(@RequestBody Agencia agencia){
        return new ResponseEntity<>(agenciaService.save(agencia), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Agencia> update(@RequestBody Agencia agencia){
        return new ResponseEntity<>(agenciaService.update(agencia), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        return new ResponseEntity<>(agenciaService.delete(id), HttpStatus.NO_CONTENT);
    }
}
