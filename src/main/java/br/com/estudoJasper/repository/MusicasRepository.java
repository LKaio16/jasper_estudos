package br.com.estudoJasper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudoJasper.domain.Musicas;

public interface MusicasRepository extends JpaRepository<Musicas, Long> {

}