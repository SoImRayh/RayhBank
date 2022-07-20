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

    //listando todos os bancos
    @GetMapping
    public ResponseEntity<Page<Banco>> list(Pageable pageable){
        return ResponseEntity.ok(bancoService.listAll(pageable));
    }
    //procurando um banco espe cifico por ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Banco> findById(@PathVariable Integer id){
        return ResponseEntity.ok(bancoService.findById(id));
    }
    //adicionando novo model(banco) ao DB
    @PostMapping("/new")
    public ResponseEntity<Banco> salvar(@RequestBody Banco banco){
        return new ResponseEntity<>(bancoService.save(banco), HttpStatus.CREATED);
    }
    //atualizando um model(banco) no DB
    @PutMapping("/edit/{id}")
    public ResponseEntity<Banco> update(@RequestBody Banco banco){
        ;
        return new ResponseEntity<>(bancoService.update(banco) ,HttpStatus.ACCEPTED);
    }

        //para deletar algum model (banco) do DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        bancoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
