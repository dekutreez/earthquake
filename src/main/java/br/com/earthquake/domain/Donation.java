package br.com.earthquake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doacoes")
public class Donation {
	
	@Id
	@Column(name="coddoa")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="codusr")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="coddon")
	private DonationItem donation;
	
	@Column(name="qtddoa")
	private Integer quantidadeDoada;
	
	public Donation() {}

	public Donation(Long id, Usuario usuario, DonationItem donation,
			Integer quantidadeDoada) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.donation = donation;
		this.quantidadeDoada = quantidadeDoada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DonationItem getDonation() {
		return donation;
	}

	public void setDonation(DonationItem donation) {
		this.donation = donation;
	}

	public Integer getQuantidadeDoada() {
		return quantidadeDoada;
	}

	public void setQuantidadeDoada(Integer quantidadeDoada) {
		this.quantidadeDoada = quantidadeDoada;
	}
	
	public Integer getPorcentagemDoada() {
		return ((quantidadeDoada * 100) / donation.getLimiteMinimo());
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", usuario=" + usuario + ", donation="
				+ donation + ", quantidadeDoada=" + quantidadeDoada + "]";
	}	
}
