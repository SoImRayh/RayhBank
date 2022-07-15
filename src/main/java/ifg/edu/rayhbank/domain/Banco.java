package ifg.edu.rayhbank.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "banco")
@NoArgsConstructor
@AllArgsConstructor
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    @NonNull
    private String nome;

    @Column(name = "numero")
    private String numero;

}
