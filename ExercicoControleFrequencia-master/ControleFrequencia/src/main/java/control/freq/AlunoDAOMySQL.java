package control.freq;

import java.sql.*;
import java.util.*;

public class AlunoDAOMySQL implements AlunoDAO{
    private String createSQL= "INSERT INTO aluno VALUES (?,?,?,?)";
    private String readSQL= "SELECT * FROM aluno";

    private final MySQLConnection mysql= new MySQLConnection();

    @Override
    public boolean create(Aluno aluno) {
        Connection conexao= mysql.getConnection();
        try{
            PreparedStatement stm= conexao.prepareStatement(createSQL);

            stm.setLong(1,aluno.getTia());
            stm.setString(2,aluno.getNome());
            stm.setString(3,aluno.getHorarioEntrada());
            stm.setString(4,aluno.getHorarioSaida());

            int registros= stm.executeUpdate();

            return registros>0 ? true:false;
        }catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }catch(final Exception ex) {
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Aluno> read() {
        Connection conexao= mysql.getConnection();
        List<Aluno> alunos= new ArrayList();

        try{
            PreparedStatement stm= conexao.prepareStatement(readSQL);
            ResultSet rs= stm.executeQuery();

            while(rs.next()){
                Aluno aluno=new Aluno();
                aluno.setTia(rs.getLong("tia"));
                aluno.setNome(rs.getString("nome"));
                aluno.setHorarioEntrada(rs.getString("horarioEntrada"));
                aluno.setHorarioSaida(rs.getString("horarioSaida"));
                alunos.add(aluno);
            }
            return alunos;
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return alunos;
    }
}

