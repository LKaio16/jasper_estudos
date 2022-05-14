package br.com.estudoJasper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "musicas")
public class Musicas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private String album; 
	
	@Column(name="duracao_musica")
	private Long duracaoMin;

	public Musicas() {
		super();
	}

	public Musicas(Long id, String titulo, String album, Long duracaoMin) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.album = album;
		this.duracaoMin = duracaoMin;
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

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Long getDuracaoMin() {
		return duracaoMin;
	}

	public void setDuracaoMin(Long duracaoMin) {
		this.duracaoMin = duracaoMin;
	} 
	
}
