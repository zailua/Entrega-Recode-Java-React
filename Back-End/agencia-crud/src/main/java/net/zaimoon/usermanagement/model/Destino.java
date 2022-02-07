package net.zaimoon.usermanagement.model;

public class Destino {

	private int id;
	private String nome;
	private String uf;
	private String country;
	
	
	
	
	
	
	
	
	
	
	
	
	public Destino(String nome, String uf, String country) {
		super();
		this.nome = nome;
		this.uf = uf;
		this.country = country;
	}
	public Destino(int id, String nome, String uf, String country) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.country = country;
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	

