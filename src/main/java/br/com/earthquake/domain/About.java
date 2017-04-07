package br.com.earthquake.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="About")
@Table(name="about")
@SuppressWarnings("serial")
public class About implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="codabt", nullable = false)
	private Integer id;
	
	@Column(name="txtabt", nullable = false)
	private String texto;
	
	@Column(name="codpag", nullable = false)
	private Integer pagina;
	
	@Column(name="titabt", nullable = true)
	private String titulo;
	
	public About() {}
	
	public About(Integer id, String texto, Integer pagina) {
		super();
		this.id = id;
		this.texto = texto;
		this.pagina = pagina;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Integer getPagina() {
		return pagina;
	}
	
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
		
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "About [id=" + id + ", texto=" + texto + ", pagina=" + pagina
				+ "]";
	}
}
