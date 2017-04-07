package br.com.earthquake.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.earthquake.enums.JobEnum;
import br.com.earthquake.enums.PalleteEnum;

@Entity
@Table(name="usuario")
@SuppressWarnings("serial")
public class Usuario implements Serializable {
	
	@Id
	@Column(name="codusr", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name="nomusr", nullable = false)
	private String nome;
	
	@Column(name="emausr", nullable = false)
	private String email;
	
	@Column(name="logusr", nullable = false)
	private String login;
	
	@Column(name="senusr", nullable = false)
	private String senha;
	
	@Column(name="rolusr", nullable = true)
	private String role;
	
	@Column(name="codchr", nullable = false)
	private Integer codigoCharacter;
	
	@Column(name="numjob", nullable = false)
	private JobEnum job;
	
	@Column(name="codpal", nullable = false)
	private PalleteEnum palleteEnum;
	
	@Column(name="stausr", nullable = false)
	private Boolean statusAtivo;
	
	@Column(name="nomchr")
	private String nomeChar;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_perfil", joinColumns = { @JoinColumn(name = "codusr") }, inverseJoinColumns = { @JoinColumn(name = "codprf") })
	private List<Perfil> perfis;
	
	@ManyToOne
	@JoinColumn(name="codprt")
	private Party party;
	
	public Usuario() {
		this.statusAtivo = true;
		this.perfis = new ArrayList<Perfil>();
	}
	
	public Usuario(Long id, String nome, String email, String login,
			String senha, String role, Integer codigoCharacter, JobEnum job, 
			PalleteEnum palleteEnum, List<Perfil> perfis) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.role = role;
		this.palleteEnum = palleteEnum;
		this.codigoCharacter = codigoCharacter;
		this.job = job;
		this.statusAtivo = true;
		this.perfis = new ArrayList<Perfil>();
		this.perfis = perfis;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getCodigoCharacter() {
		return codigoCharacter;
	}
	
	public void setCodigoCharacter(Integer codigoCharacter) {
		this.codigoCharacter = codigoCharacter;
	}

	public JobEnum getJob() {
		return job;
	}

	public void setJob(JobEnum job) {
		this.job = job;
	}
	
	public PalleteEnum getPalleteEnum() {
		return palleteEnum;
	}

	public void setPalleteEnum(PalleteEnum palleteEnum) {
		this.palleteEnum = palleteEnum;
	}
	
	public Boolean getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(Boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public String getNomeChar() {
		return nomeChar;
	}

	public void setNomeChar(String nomeChar) {
		this.nomeChar = nomeChar;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoCharacter == null) ? 0 : codigoCharacter.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((palleteEnum == null) ? 0 : palleteEnum.hashCode());
		result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result
				+ ((statusAtivo == null) ? 0 : statusAtivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigoCharacter == null) {
			if (other.codigoCharacter != null)
				return false;
		} else if (!codigoCharacter.equals(other.codigoCharacter))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job != other.job)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (palleteEnum != other.palleteEnum)
			return false;
		if (perfis == null) {
			if (other.perfis != null)
				return false;
		} else if (!perfis.equals(other.perfis))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (statusAtivo == null) {
			if (other.statusAtivo != null)
				return false;
		} else if (!statusAtivo.equals(other.statusAtivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", role=" + role
				+ ", codigoCharacter=" + codigoCharacter + ", job=" + job + ", pallete="+ palleteEnum + "]";
	}

}
