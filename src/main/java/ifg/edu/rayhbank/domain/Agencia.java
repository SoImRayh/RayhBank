package ifg.edu.rayhbank.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Data
@Table(name = "agencia_bancaria")
@NoArgsConstructor
@AllArgsConstructor
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "id_banco")
    private Integer idBanco;

    @NotNull
    @Column(name = "endereco")
    private String endereco;

    @NotNull
    @Column(name = "fone")
    private BigInteger fone;
    @NotNull
    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "fone1")
    private BigInteger fone1;
    @Column(name = "tipo1")
    private Integer tipo1;

    @NotNull
    @NotBlank
    @Column(name = "agencia")
    private String agencia;
    @NotNull
    @NotBlank
    @Column(name = "nome_agencia")
    private String nomeAgencia;

}
