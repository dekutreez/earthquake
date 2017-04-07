package br.com.earthquake.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="party")
public class Party {
	
	@Id
	@Column(name="codprt")
	@GeneratedValue
	private Integer id;
	
	@Column(name="nomprt")
	private String nome;
	
	@Column(name="imgprt")
	private String imagem;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "party")
	List<Usuario> usuarios;
	
	public Party() {}

	public Party(Integer id, String nome, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", nome=" + nome + ", imagem=" + imagem
				+ "]";
	}
}
