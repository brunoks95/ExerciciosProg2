package control.freq;

import control.freq.AlunoDAOMySQL;

public class App 
{
    public static void main( String[] args ) {
        AlunoDAOMySQL mysqlDAO= new AlunoDAOMySQL();
        InterfaceUsuario interfaceUsuario= new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();

    }
}
