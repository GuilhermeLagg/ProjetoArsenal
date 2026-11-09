package com.lojarpg.backend.service;

import com.lojarpg.backend.model.Arma;
import com.lojarpg.backend.model.ItemMagico;
import com.lojarpg.backend.repository.ArmaRepository;
import com.lojarpg.backend.repository.ItemMagicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItemMagicoService {

    private final ItemMagicoRepository repository;
    private final ArmaRepository armaRepository;

    public ItemMagicoService(ItemMagicoRepository repository, ArmaRepository armaRepository){
        this.repository = repository;
        this.armaRepository = armaRepository;
    }

    public List<ItemMagico> listar(){
        return repository.findAll();
    }

    public ItemMagico buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Item mágico não encontrado!"
                )
        );
    }

    public ItemMagico salvar(ItemMagico item){
        item.setId(null);
        item.setArma(resolverArma(item.getArma()));
        return repository.save(item);
    }

    public ItemMagico atualizar(Integer id, ItemMagico dados){
        ItemMagico existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setEfeito(dados.getEfeito());
        existente.setRaridade(dados.getRaridade());
        existente.setPreco(dados.getPreco());
        existente.setArma(resolverArma(dados.getArma()));
        return repository.save(existente);
    }

    public void deletar(Integer id){
        buscarPorId(id);
        repository.deleteById(id);
    }

    private Arma resolverArma(Arma arma){
        if (arma == null || arma.getId() == null){
            return null;
        }

        return armaRepository.findById(arma.getId()).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "A arma informada não existe!"
                )
        );
    }


}
