package com.bandtec.projetocontinuada.controle;

import com.bandtec.projetocontinuada.dominio.Lutador;
import com.bandtec.projetocontinuada.repositorio.LutadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lutas")
public class LutaController {

    @Autowired
    private LutadorRepositorio repository;

    @PostMapping("/lutadores")
    public ResponseEntity postLutadores(@RequestBody @Valid Lutador novoLutador) {
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/lutadores/contagem-vivos")
    public ResponseEntity getCountLutadores() {
        return ResponseEntity.status(201).body(repository.findAllCount());
    }

    @GetMapping("/lutadores/mortos")
    public ResponseEntity getCountLutadoresMortos() {
        return ResponseEntity.status(201).body(repository.findAllCountMortos());
    }

    @GetMapping("/lutadores")
    public ResponseEntity getLutador() {
        List<Lutador> lutador = repository.findAll();

        if (lutador.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(repository.findAllByForcaGolpe());
        }
    }
}