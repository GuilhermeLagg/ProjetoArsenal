package com.lojarpg.backend.controller;
import com.lojarpg.backend.model.Arma;
import com.lojarpg.backend.service.ArmaService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armas")
public class ArmaController {

    private final ArmaService service;

    public ArmaController(ArmaService service){
        this.service = service;
    }

    @GetMapping
    public List<Arma> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Arma buscar(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Arma criar(@Validated @RequestBody Arma arma){
        return service.salvar(arma);
    }

    @PutMapping("/{id}")
    public Arma atualizar(@PathVariable Integer id, @Validated @RequestBody Arma arma){
        return service.atualizar(id, arma);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }
}
