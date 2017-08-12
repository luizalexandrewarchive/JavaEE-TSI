package rh;

public class Main {
    public static void main(String[] args) {
    	
    	
    	Endereco primeiroEndereco = new Endereco("Rua 14 Numero 52", "Jardim América", "Morrinhos", "GO", "Quadra 19");
    	Endereco segundoEndereco = new Endereco("Rua 45 Numero 99", "Jardim Goiás", "Morrinhos", "GO", "Quadra 29");
    	Endereco terceiroEndereco = new Endereco("Rua 34 Numero 23", "Centro", "Morrinhos", "GO", "Quadra 19");
    	
    	Dependente dependenteUm = new Dependente("Jose", "Filho");
    	Dependente dependentDois = new Dependente("Maria", "Filho");  		
    	
    	Cargo cargo = new Cargo("Desenvolvedor", 978.50);
    	
    	Funcionario luiz = new Funcionario("Luiz Alexandre de Sousa Freitas", 2542.32, cargo, primeiroEndereco);
    	
    	luiz.getEnderecos().add(segundoEndereco);
    	luiz.getEnderecos().add(terceiroEndereco);
    	
    	luiz.getDependentes().add(dependenteUm);
    	luiz.getDependentes().add(dependentDois);
    	
    	System.out.println(luiz);
    	
    	
       
       
    }
    
}
