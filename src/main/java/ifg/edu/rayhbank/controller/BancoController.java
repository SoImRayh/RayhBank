package ifg.edu.rayhbank.controller;

import ifg.edu.rayhbank.domain.Banco;
import ifg.edu.rayhbank.service.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<List<Banco>> list( ){
        return ResponseEntity.ok(bancoService.listAll());
    }

    //procurando um banco espe cifico por ID
    @GetMapping(path = "/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Banco> findById(@PathVariable Integer id){
        return ResponseEntity.ok(bancoService.findById(id));
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Banco>> findWithFilter(@RequestParam String filtro){
        return ResponseEntity.ok(this.bancoService.findWithFilter(filtro));
    }

    //adicionando novo model(banco) ao DB
    @PostMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Banco> salvar(@RequestBody Banco banco){
        return new ResponseEntity<>(bancoService.save(banco), HttpStatus.CREATED);
    }

    //atualizando um model(banco) no DB
    @PutMapping("/edit/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Banco> update(@RequestBody Banco banco){
        return new ResponseEntity<>(bancoService.update(banco) ,HttpStatus.ACCEPTED);
    }

        //para deletar algum model (banco) do DB
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        bancoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
