package ifg.edu.rayhbank.controller;

import ifg.edu.rayhbank.domain.Role;
import ifg.edu.rayhbank.domain.User;
import ifg.edu.rayhbank.domain.Utils;
import ifg.edu.rayhbank.service.RoleService;
import ifg.edu.rayhbank.service.UserService;
import ifg.edu.rayhbank.service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/utils")
public class UtilController {

    private final UserService userService;
    private final RoleService roleService;

    private final UtilsService utilsService;

    @GetMapping("/{id}")
    public ResponseEntity<Utils> getUtil(@PathVariable Integer id){
        return ResponseEntity.ok(utilsService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Utils>> getAllByTipo(@RequestParam String tipo){
        return ResponseEntity.ok(utilsService.findByTipo(tipo));
    }


    @PostMapping("/user")
    public ResponseEntity<User> novoUser(@RequestBody User user){
        return new ResponseEntity(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> novaRole(@RequestBody Role role){
        return new ResponseEntity(roleService.save(role), HttpStatus.CREATED );
    }

}
