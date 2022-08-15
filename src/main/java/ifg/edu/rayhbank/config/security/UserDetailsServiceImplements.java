package ifg.edu.rayhbank.config.security;

import ifg.edu.rayhbank.domain.User;
import ifg.edu.rayhbank.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//@Service
@AllArgsConstructor
//@Transactional
public class UserDetailsServiceImplements implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                "usuario nao encontrado" + username));
        /// esse new user é da classe do security e nao do domain
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                user.getAuthorities());
    }

}
