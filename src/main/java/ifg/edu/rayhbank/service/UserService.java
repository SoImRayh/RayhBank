package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.User;
import ifg.edu.rayhbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface UserService {
    User save(User user);

}
