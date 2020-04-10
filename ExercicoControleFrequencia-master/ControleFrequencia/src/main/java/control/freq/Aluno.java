package control.freq;

public class Aluno {
    private long tia;
    private String nome;
    private String horarioEntrada;
    private String horarioSaida;

    public Aluno(){}

    public Aluno(long tia, String nome, String horarioEntrada, String horarioSaida){
        this.tia=tia;
        this.nome=nome;
        this.horarioEntrada=horarioEntrada;
        this.horarioSaida=horarioSaida;
    }

    public long getTia(){
        return tia;
    }

    public void setTia(long tia){
        this.tia=tia;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getHorarioEntrada(){
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada){
        this.horarioEntrada=horarioEntrada;
    }

    public String getHorarioSaida(){
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida){
        this.horarioSaida=horarioSaida;
    }

@Override
    public String toString() {
    return nome +
            "  [tia:" + tia +
            ",  horario de entrada: " + horarioEntrada +
            ",  horario de saida: " + horarioSaida + "]";
}

}
