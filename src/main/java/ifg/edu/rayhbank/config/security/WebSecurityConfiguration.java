package ifg.edu.rayhbank.config.security;

import ifg.edu.rayhbank.config.security.filters.JwtFilter;
import ifg.edu.rayhbank.config.security.filters.LoginFilter;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    @Autowired
    @Lazy
    private LoginFilter loginFilter;

    @Autowired
    private JwtFilter jwtFilter;

    /** crinando atenticação em memoria:*/
    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        uds.createUser(User.builder().username("user").password("{noop}user").roles("USER").build());
        uds.createUser(User.builder().username("admin").password("{noop}admin").roles("ADMIN", "USER").build());
        return uds;
    }

    //desabilitei aqui apenas comentando uma linha de codigo nada mais
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeHttpRequests().anyRequest().permitAll();
        http.addFilterAt(loginFilter, BasicAuthenticationFilter.class);
        http.addFilterAt(jwtFilter, BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) throws Exception{
        var dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService);
        return new ProviderManager(dao);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
