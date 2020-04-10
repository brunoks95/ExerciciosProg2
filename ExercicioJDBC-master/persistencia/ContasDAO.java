package Proj_jdbc.persistencia;

import Proj_jdbc.entidades.Contas;
import java.util.List;

public interface ContasDAO {
    boolean create(Contas contas);
    List<Contas> read ();
    boolean delete(Contas contas);
}
