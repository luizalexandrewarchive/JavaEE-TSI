package rh;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String cidade, String estado, String complemento) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return  this.getLogradouro() + "," +
        		this.getComplemento() + "," +
        		this.getCidade() + "," + 
        		this.getEstado();
    }
    
    
    
}
