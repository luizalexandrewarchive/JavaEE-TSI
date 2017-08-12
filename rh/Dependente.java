package rh;

public class Dependente {
    private String nome;
    private String parentesco;

    public Dependente() {
    }

    public Dependente(String nome, String parentesco) {
        this.nome = nome;
        this.parentesco = parentesco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() { 
    	return "Nome: " + this.getNome() + "\n\t" + "Parentesco: " +this.getParentesco() + "\n";
    }   

    
}
