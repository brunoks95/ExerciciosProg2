package control.freq;

import control.freq.Aluno;
import control.freq.AlunoDAO;
import java.util.*;

public class InterfaceUsuario {
    AlunoDAO dao;
    Scanner in;

    public InterfaceUsuario(AlunoDAO dao){
        this.dao= dao;
        this.in= new Scanner(System.in);
    }

    public void iniciar(){
        imprimirMenu();
    }

    private void imprimirMenu(){
        int opc=0;
        do{
            System.out.println("\n==================");
            System.out.println("==== MENU ====");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Sair");
            System.out.println("\n==================");
            System.out.println("Escolha uma opção: ");
            opc= in.nextInt();

            in.nextLine();

            switch (opc){
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    System.out.println("Você saiu!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println("Escolha uma das opções exibidas no menu!");
            }

        }while(opc!=3);
    }

    private void create(){
        Aluno aluno = new Aluno();

        System.out.println("\n***************");
        System.out.println("*** Novo aluno ***");
        System.out.println("\n***************");
        System.out.println("\nInforme o TIA do aluno: ");
        aluno.setTia(in.nextLong());
        in.nextLine();

        System.out.println("Informe o NOME do aluno: ");
        aluno.setNome(in.nextLine());

        System.out.println("Informe o HORARIO DE ENTRADA: ");
        aluno.setHorarioEntrada(in.nextLine());

        System.out.println("Informe o HORARIO DE SAIDA: ");
        aluno.setHorarioSaida(in.nextLine());

        if(dao.create(aluno)){
            System.out.println("Informações do aluno adicionadas ao banco de dados");
        }else{
            System.out.println("Erro: Não foi possível adicionar as informções no banco de dados");
        }
    }

    private void read(){
        List<Aluno> alunos = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Alunos Cadastrados ***");
        System.out.println("***********************************");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
