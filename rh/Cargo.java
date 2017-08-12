package rh;

public class Cargo {
    private String descricao;
    private double gratificacao;

    public Cargo() {
    }

    public Cargo(String descricao, double gratificacao) {
        this.descricao = descricao;
        this.gratificacao = gratificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(double gratificacao) {
        this.gratificacao = gratificacao;
    }

    @Override
    public String toString() {
        return "Cargo{" + "descricao=" + descricao + ", gratificacao=" + gratificacao + '}';
    }
    
    
    
}
