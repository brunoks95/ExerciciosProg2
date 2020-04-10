package Proj_jdbc.entidades;

public class Contas {
    private long nro_conta;
    private double saldo;
    private int rg;

    public Contas(){}

    public Contas(long nro_conta, double saldo, int rg)
    {
        this.setNro_conta(nro_conta);
        this.setSaldo(saldo);
        this.setRg(rg);
    }

    public long getNro_conta() {
        return nro_conta;
    }

    public void setNro_conta(long nro_conta) {
        this.nro_conta = nro_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    @Override
    public String toString()
    {
        return nro_conta +
                "[saldo: " + saldo +
                ", rg: "+ rg + "]";
    }
}
