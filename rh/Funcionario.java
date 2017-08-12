package rh;

import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private double salario;
    private Cargo cargo;
    
    private ArrayList<Dependente> dependentes;
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Funcionario(String nome, double salario, Cargo cargo, Dependente dependentes, Endereco enderecos) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        getDependentes().add(dependentes);
        this.enderecos.add(enderecos);
    }

    public Funcionario(String nome, double salario, Cargo cargo, Endereco enderecos) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        this.enderecos.add(enderecos);
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Dependente> getDependentes() {
        if(dependentes==null) {
            dependentes = new ArrayList<>();
        }
        return dependentes;
    }

    public void setDependentes(ArrayList<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Funcionario: \n"+
        		"\nNome :" + nome +
        		"\nSalario : " + salario + 
        		"\nCargo : " + cargo.getDescricao() +
        		"\nGratificação : " + cargo.getGratificacao() +
        		"\nDependentes: \n" + this.printFuncDep(dependentes) +
        		"\nEnderecos:\n" + this.printFuncEnd(enderecos);

    }
    
    public String printFuncDep(ArrayList<Dependente> dependentes) {
    	
    	String text = "";
    	
    	for(int i = 0; i < dependentes.size(); i++){
    		text += "\n    "+ (i+1) + " - " + dependentes.get(i);
    		
    	}
    	
    	return text;
    	
    }
    
    public String printFuncEnd(ArrayList<Endereco> enderecos) {
    	
    	String text = "";
    	
    	for(int i = 0; i < enderecos.size(); i++){
    		text += "\n\tEndereco "+ (i+1) + " : " + enderecos.get(i);
    		
    	}
    	
    	return text;
    	
    }

 
    
    
    

}


