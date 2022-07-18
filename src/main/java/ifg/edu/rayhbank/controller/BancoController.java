package ifg.edu.rayhbank.controller;

import ifg.edu.rayhbank.domain.Banco;
import ifg.edu.rayhbank.service.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancos")
@Component
@RequiredArgsConstructor
public class BancoController {

    private final BancoService bancoService;


    @GetMapping
    public ResponseEntity<Page<Banco>> list(Pageable pageable){
        return ResponseEntity.ok(bancoService.listAll(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Banco> findById(@PathVariable Long id){
        return ResponseEntity.ok(bancoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Banco> salvar(@RequestBody Banco banco){
        return new ResponseEntity<>(bancoService.save(banco), HttpStatus.CREATED);
    }

}
