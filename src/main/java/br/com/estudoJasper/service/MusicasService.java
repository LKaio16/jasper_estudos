package br.com.estudoJasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudoJasper.domain.Musicas;
import br.com.estudoJasper.repository.MusicasRepository;

@Service
public class MusicasService {
	@Autowired
	private MusicasRepository musicasRepository;
	
	public MusicasRepository getMusicasRepository() {
		return musicasRepository;
	}
	
	public void salvar(Musicas musicas) {
		this.musicasRepository.save(musicas);
	}
	
	
	public List<Musicas> listar() {
		this.musicasRepository.findAll();
		return this.musicasRepository.findAll();
	}
}
