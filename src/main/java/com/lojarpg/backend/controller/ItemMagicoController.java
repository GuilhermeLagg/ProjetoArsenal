package com.lojarpg.backend.controller;

import com.lojarpg.backend.model.ItemMagico;
import com.lojarpg.backend.service.ItemMagicoService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-magicos")
public class ItemMagicoController {

    private final ItemMagicoService service;

    public ItemMagicoController(ItemMagicoService service){
        this.service = service;
    }

    @GetMapping
    public List<ItemMagico> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ItemMagico buscar(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemMagico criar(@Validated @RequestBody ItemMagico item){
        return service.salvar(item);
    }

    @PutMapping("/{id}")
    public ItemMagico atualizar(@PathVariable Integer id, @Validated @RequestBody ItemMagico item){
        return service.atualizar(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }
}
