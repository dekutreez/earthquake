package br.com.earthquake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.earthquake.enums.TipoStuffEnum;

@Entity
@Table(name="guild_stuff")
public class GuildStuff {

	@Id
	@Column(name="codstu")
	@GeneratedValue
	private Long id;
	
	@Column(name="nomstu")
	private String nome;
	
	@Column(name="tipstu")
	private TipoStuffEnum tipoStuff;
	
	@Column(name="qtdstu")
	private Integer quantidade;
	
	public GuildStuff() {}

	public GuildStuff(Long id, String nome, TipoStuffEnum tipoStuff,
			Integer quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoStuff = tipoStuff;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoStuffEnum getTipoStuff() {
		return tipoStuff;
	}

	public void setTipoStuff(TipoStuffEnum tipoStuff) {
		this.tipoStuff = tipoStuff;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "GuildStuff [id=" + id + ", nome=" + nome + ", tipoStuff="
				+ tipoStuff + ", quantidade=" + quantidade + "]";
	}	
}
