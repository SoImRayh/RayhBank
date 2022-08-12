package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.Utils;

import java.util.List;

public interface UtilsService {

    List<Utils> findByTipo(String tipo);

    Utils findById(Integer id);
}
