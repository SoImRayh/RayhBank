package ifg.edu.rayhbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RayhBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(RayhBankApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("pedro"));
    }

}
