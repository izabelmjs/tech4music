package br.com.tech4music.tech4music.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4music.tech4music.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String>  {
    
}
