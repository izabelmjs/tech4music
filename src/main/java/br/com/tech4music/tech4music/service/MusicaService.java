package br.com.tech4music.tech4music.service;

import java.util.List;

import br.com.tech4music.tech4music.shared.MusicaDTO;

public interface MusicaService {
    
    List<MusicaDTO> obterMusicas();
    MusicaDTO obterPorId(String id);
    MusicaDTO adicionaMusica(MusicaDTO musica);
    void removerMusica(String id);
    MusicaDTO atualizarMusica(String id, MusicaDTO musica);
}
