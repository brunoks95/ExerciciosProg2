package control.freq;

import java.util.*;

public interface AlunoDAO {
    boolean create (Aluno aluno);
    List<Aluno> read();
}
