package br.com.tech4music.tech4music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4music.tech4music.service.MusicaService;
import br.com.tech4music.tech4music.shared.MusicaDTO;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

@Autowired
  private MusicaService service;

  @GetMapping
  public List<MusicaDTO> obterMusica(){
    return service.obterMusicas();
  }

  @GetMapping("/{id}")
  public MusicaDTO obterPorId(@PathVariable String id){
    return service.obterPorId(id);
  }

  @PostMapping
  public MusicaDTO adicionarMusica(@RequestBody MusicaDTO musica){
    return service.adicionaMusica(musica);
  }

  @PutMapping("/{id}")
  public MusicaDTO atualizarMusica(@PathVariable String id, @RequestBody MusicaDTO novaMusica){
    return service.atualizarMusica(id, novaMusica);
  }

  @DeleteMapping("/{id}")
  public void removerMusica(@PathVariable String id){
    service.removerMusica(id);
  }
}
