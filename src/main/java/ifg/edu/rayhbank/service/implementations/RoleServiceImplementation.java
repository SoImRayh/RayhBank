package ifg.edu.rayhbank.service.implementations;

import ifg.edu.rayhbank.domain.Role;
import ifg.edu.rayhbank.repository.RoleRepository;
import ifg.edu.rayhbank.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImplementation implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
