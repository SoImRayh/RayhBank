package ifg.edu.rayhbank.service.implementations;

import ifg.edu.rayhbank.domain.User;
import ifg.edu.rayhbank.repository.UserRepository;
import ifg.edu.rayhbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImplementation implements UserService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
