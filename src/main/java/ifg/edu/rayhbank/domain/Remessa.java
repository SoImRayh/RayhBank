package ifg.edu.rayhbank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remessa {
    private static final Long uuidVersion=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private UUID uuid;

    private String filename;

    private String fileType;

    @Lob
    private byte[] data;

    public Remessa(String filename, String fileType, byte[] data) {
        this.filename = filename;
        this.fileType = fileType;
        this.data = data;
    }
}
