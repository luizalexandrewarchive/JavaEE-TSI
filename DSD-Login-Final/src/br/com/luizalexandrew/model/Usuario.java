package br.com.luizalexandrew.model;

public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	private String usuario;
	private String senha;
	
	public Usuario(int id, String nome, String email, String usuario, String senha){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Usuario(String nome, String email, String usuario, String senha){
		this.id = 0;
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Usuario(String usuario, String senha){
		this.id = 0;
		this.nome = "";
		this.email = "";
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
