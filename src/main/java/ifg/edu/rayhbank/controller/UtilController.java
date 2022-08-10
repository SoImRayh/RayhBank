package ifg.edu.rayhbank.controller;

import ifg.edu.rayhbank.domain.Role;
import ifg.edu.rayhbank.domain.User;
import ifg.edu.rayhbank.repository.RoleRepository;
import ifg.edu.rayhbank.repository.UserRepository;
import ifg.edu.rayhbank.service.RoleService;
import ifg.edu.rayhbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/utils")
public class UtilController {

    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/user")
    public ResponseEntity<User> novoUser(@RequestBody User user){
        return new ResponseEntity(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> novaRole(@RequestBody Role role){
        return new ResponseEntity(roleService.save(role), HttpStatus.CREATED );
    }

}
