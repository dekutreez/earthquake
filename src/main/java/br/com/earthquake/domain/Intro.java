package br.com.earthquake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Intro")
@Table(name="intro")
public class Intro {
	
	@Id
	@GeneratedValue
	@Column(name="codint", nullable = false)
	Long id;
	
	@Column(name="titint")
	String titulo;
	
	@Column(name="txtint")
	String texto;
	
	@Column(name="icoint")
	String icon;
	
	@Column(name="posint")
	Integer position;
	
	public Intro() {}
	
	public Intro(Long id, String titulo, String texto, String icon,
			Integer position) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.icon = icon;
		this.position = position;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public void setPosition(Integer position) {
		this.position = position;
	}
}
