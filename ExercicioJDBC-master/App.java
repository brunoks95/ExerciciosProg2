package Proj_jdbc;


import Proj_jdbc.persistencia.ContasDAOMySQL;

import java.sql.*;
public class App {
    public static void main(final String[] args) {
        ContasDAOMySQL mysqlDAO = new ContasDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}