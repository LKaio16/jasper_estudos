package br.com.estudoJasper.bean;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudoJasper.domain.Musicas;
import br.com.estudoJasper.service.MusicasService;

@Named(value = "musicaBean")
@ViewScoped
public class MusicasBean {
	
	@Autowired
	private MusicasService musicasService;
	
	private Musicas musica;
	private List<Musicas> musicas;
	
	public MusicasBean() {
		this.musica = new Musicas();
		
		// TODO Auto-generated constructor stub
	}

	public MusicasBean(Musicas musica, List<Musicas> musicas) {
		super();
		this.musica = musica;
		this.musicas = musicas;
	}
	
	public Musicas getMusica() {
		return musica;
	}
	public void setMusica(Musicas musica) {
		this.musica = musica;
	}
	public List<Musicas> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Musicas> musicas) {
		this.musicas = musicas;
	}
	
	
	public void cadastrar() {
		Musicas musica = this.musica;
		
		this.musicasService.salvar(musica);
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	
}
