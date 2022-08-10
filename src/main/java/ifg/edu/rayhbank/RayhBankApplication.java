package ifg.edu.rayhbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RayhBankApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("\n"+bCryptPasswordEncoder.encode("admin")+"\n");
        SpringApplication.run(RayhBankApplication.class, args);
    }

}
