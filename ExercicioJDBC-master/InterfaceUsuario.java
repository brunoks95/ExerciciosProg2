package Proj_jdbc;

import Proj_jdbc.entidades.Contas;
import Proj_jdbc.persistencia.ContasDAO;

import java.util.*;

public class InterfaceUsuario {
    ContasDAO dao;
    Scanner in;

    public InterfaceUsuario(ContasDAO dao){
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar(){ imprimirMenu();}

    private void imprimirMenu(){
        int opc = 0;
        do{
            System.out.println("\t1. Criar conta");
            System.out.println("\t2. Deletar conta");
            System.out.println("\t3. ver contas");
            System.out.println("\t4. Sair");
            System.out.println("Escolha uma opção: ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc){
                case 1:
                    this.create();
                    break;
                case 2:
                    this.delete();
                    break;
                case 3:
                    this.read();
                    break;
                case 4:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(opc != 4);
    }

    private void create(){
        Contas contas = new Contas();

        System.out.println("Informe a conta que deseja inserir: ");
        contas.setNro_conta(in.nextLong());

        in.nextLine();

        System.out.println("Informe o saldo: ");
        contas.setSaldo(in.nextDouble());

        System.out.println("Informe o rg: ");
        contas.setRg(in.nextInt());

        if(dao.create(contas)){
            System.out.println("Conta adicionada com sucesso");
        }else{
            System.out.println("Problema ao adionar conta");
        }
    }

    private void read() {
        List<Contas> contas1 = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Contas Cadastrados ***");
        System.out.println("***********************************");
        for(Contas contas : contas1) {
            System.out.println(contas);
        }
    }

    private void delete() {
        List<Contas> contas1 = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Alunos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Contas contas : contas1) {
                System.out.println(i + " - " + contas);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual conta deseja remover? ");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= contas1.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(contas1.get(opc))) {
                    System.out.println("Contas " + contas1.get(opc).getNro_conta() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                //Isso para o while infinito
                break;
            }
        }
    }
}
