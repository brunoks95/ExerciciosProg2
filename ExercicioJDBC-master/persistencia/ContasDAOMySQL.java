package Proj_jdbc.persistencia;

import Proj_jdbc.entidades.Contas;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.*;

public class ContasDAOMySQL implements ContasDAO{
    private String createSQL = "INSERT INTO contas VALUES (?, ?, ?)";
    private String readSQL = "SELECT * FROM contas";
    private String deleteSQL = "DELETE FROM contas WHERE nro_conta=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Contas contas) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setLong(1, contas.getNro_conta());
            stm.setDouble(2, contas.getSaldo());
            stm.setInt(3, contas.getRg());

            int registros = stm.executeUpdate();

            return registros > 0;

        } catch (final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final  Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Contas> read() {
        Connection conexao = mysql.getConnection();
        List<Contas> contas = new ArrayList<>();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                Contas contas1 = new Contas();
                contas1.setNro_conta(rs.getLong("nro_conta"));
                contas1.setSaldo(rs.getDouble("saldo"));
                contas1.setRg(rs.getInt("rg"));
                contas.add(contas1);
            }

            return contas;
        } catch (final SQLException ex){
            System.out.println("Falha de conexao com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return contas;
    }

    @Override
    public boolean delete(Contas contas) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);


            stm.setLong(1, contas.getNro_conta());

            int registros = stm.executeUpdate();

            return registros > 0;
        } catch (final SQLException ex){
            System.out.println("Falha de conexao com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        } finally{
            try{
                conexao.close();
            } catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

}
