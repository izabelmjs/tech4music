package br.com.tech4music.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4music.tech4music.model.Musica;
import br.com.tech4music.tech4music.repository.MusicaRepository;
import br.com.tech4music.tech4music.shared.MusicaDTO;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<MusicaDTO> obterMusicas() {
        List<Musica> musicas = repository.findAll();
        
            return musicas.stream()
            .map(m -> mapper.map(m, MusicaDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public MusicaDTO obterPorId(String id) {
        Optional <Musica> musica = repository.findById(id);

        if (musica.isPresent()) {
            return mapper.map(musica.get(), MusicaDTO.class);
        }
        
        return null;
    }

    @Override
    public MusicaDTO adicionaMusica(MusicaDTO musica) {
        Musica musicaAdd = mapper.map(musica, Musica.class);
        repository.save(musicaAdd);
            return mapper.map(musicaAdd, MusicaDTO.class);
    }

    @Override
    public MusicaDTO atualizarMusica(String id, MusicaDTO musica) {
        Optional<Musica> musicBusca = repository.findById(id);

        if(musicBusca.isPresent()){
        Musica novaMusica = mapper.map(musica, Musica.class);
        novaMusica.setId(id);
        novaMusica = repository.save(novaMusica);
        return mapper.map(novaMusica, MusicaDTO.class);
    }

    return null;
}

    @Override
    public void removerMusica(String id) {
        repository.deleteById(id);
    }
    
}
