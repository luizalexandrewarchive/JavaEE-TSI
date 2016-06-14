package br.com.luizalexandrew.crudjsp.Model;

import java.util.List;

import br.com.luizalexandrew.crudjsp.ModelDao.UsuarioDao;

public class Usuario {

	private int id;
	private String nome;
	private String cpf;
	private String email;
	
	
	public Usuario(){
		this.id = 0;
		this.nome = "Luiz";
		this.cpf = "";
		this.email = "";
	}
	
	public Usuario(String nome, String cpf, String email){
		this.id = 0;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public Usuario(int id, String nome, String cpf, String email){
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public List<Usuario> recuperarAll() {
		UsuarioDao userdao = new UsuarioDao();
		return userdao.recuperarAll();
	}
	
	public Usuario recuperarUser(String id){
		UsuarioDao userdao = new UsuarioDao();
		return userdao.recuperarUsuario(Integer.parseInt(id));
	}
	
	public void atualizar(){
		UsuarioDao userdao = new UsuarioDao();
		userdao.atualizar(this);
	}
	
	public void cadastrar(){
		UsuarioDao userdao = new UsuarioDao();
		userdao.adiciona(this);
	}
	
	public void excluir(String id){
		UsuarioDao userdao = new UsuarioDao();
		userdao.remove(id);
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
