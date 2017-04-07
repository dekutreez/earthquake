package br.com.earthquake.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.earthquake.enums.JobEnum;

@Entity
@Table(name="video")
public class Video {
	
	@Id
	@Column(name="codvid", nullable = false)
	@GeneratedValue
	Long id;
	
	@Column(name="titvid", nullable = false)
	String titulo;
	
	@Column(name="lnkvid", nullable = false)
	String link;
	
	@Column(name="dscvid", nullable = false)
	String descricao;
	
	@Column(name="srvvid", nullable = false)
	String server;
	
	@Column(name="nummes", nullable = false)
	Integer mes;
	
	@Column(name="numano", nullable = false)
	Integer ano;
	
	@Column(name="nompla", nullable = false)
	String nomePlayer;
	
	@Column(name="jobpla", nullable = false)
	JobEnum jobPlayer;
	
	@Column(name="gervid", nullable = false)
	Integer geracao;
	
	public Video() {}
	
	public Video(Long id, String titulo, String link, String descricao,
			String server, Integer mes, Integer ano, String nomePlayer,
			JobEnum jobPlayer, Integer geracao) {
		this.id = id;
		this.titulo = titulo;
		this.link = link;
		this.descricao = descricao;
		this.server = server;
		this.mes = mes;
		this.ano = ano;
		this.nomePlayer = nomePlayer;
		this.jobPlayer = jobPlayer;
		this.geracao = geracao;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getEmbedLink() {
		
		String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

	    Pattern compiledPattern = Pattern.compile(pattern);
	    Matcher matcher = compiledPattern.matcher(link);

	    if(matcher.find()){
	        return "https://www.youtube.com/embed/"+matcher.group();
	    }
		
		return "";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getServer() {
		if(server.equals("")) return "-";
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Integer getMes() {
		return mes;
	}
	
	public String getMesNome() {
		if(mes == null) return "-";

		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = df.parse ("01/"+mes+"/2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df2 = new SimpleDateFormat ("MMMMM", new Locale ("pt", "BR"));
		
		return df2.format (dt);
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		if(ano == null) return 0;
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNomePlayer() {
		return nomePlayer;
	}

	public void setNomePlayer(String nomePlayer) {
		this.nomePlayer = nomePlayer;
	}

	public JobEnum getJobPlayer() {
		return jobPlayer;
	}

	public void setJobPlayer(JobEnum jobPlayer) {
		this.jobPlayer = jobPlayer;
	}

	public Integer getGeracao() {
		return geracao;
	}

	public void setGeracao(Integer geracao) {
		this.geracao = geracao;
	}
}
