package br.com.earthquake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donate_item")
public class DonationItem {

	@Id
	@Column(name="coddon", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name="dscdon")
	private String descricao;
	
	@Column(name="ptsdon")
	private Integer pontos;
	
	@Column(name="maxqtd")
	private Integer limiteMinimo;
	
	public DonationItem() {}
	
	public DonationItem(Long id, String descricao, Integer pontos,
			Integer limiteMinimo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pontos = pontos;
		this.limiteMinimo = limiteMinimo;
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
	
	public Integer getPontos() {
		return pontos;
	}
	
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	
	public Integer getLimiteMinimo() {
		return limiteMinimo;
	}
	
	public void setLimiteMinimo(Integer limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}

	@Override
	public String toString() {
		return "DonationItem [id=" + id + ", descricao=" + descricao
				+ ", pontos=" + pontos + ", limiteMinimo=" + limiteMinimo + "]";
	}
}
