package br.com.earthquake.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
public class Perfil {
	
	@Id
	@Column(name="codprf", nullable = false)
	@GeneratedValue
	Long id;
	
	@Column(name="dscprf", nullable = false)
	String descricao;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "papel_perfil", joinColumns = { @JoinColumn(name = "codprf") }, inverseJoinColumns = { @JoinColumn(name = "codpap") })
	List<Papel> papeis;
	
	public Perfil() {
		papeis = new ArrayList<Papel>();
	}	
	
	public Perfil(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", descricao=" + descricao + "]";
	}
}
