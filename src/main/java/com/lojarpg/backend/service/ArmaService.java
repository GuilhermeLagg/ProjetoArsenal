package com.lojarpg.backend.service;

import com.lojarpg.backend.model.Arma;
import com.lojarpg.backend.repository.ArmaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArmaService {

    private final ArmaRepository repository;

    public ArmaService(ArmaRepository repository){
        this.repository = repository;
    }

    public List<Arma> listar(){
        return repository.findAll();
    }

    public Arma buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Arma não encontrada"
                )
        );
    }

    public Arma salvar(Arma arma){
        arma.setId(null); //garante q eh um INSERT novo
        return repository.save(arma);
    }

    public Arma atualizar(Integer id, Arma dados){
        Arma existente = buscarPorId(id); //lança 404 se nao existir
        existente.setNome(dados.getNome());
        existente.setTipo(dados.getTipo());
        existente.setDano(dados.getDano());
        existente.setRaridade(dados.getRaridade());
        existente.setPreco(dados.getPreco());
        existente.setQuantidade(dados.getQuantidade());
        return repository.save(existente);
    }

    public void deletar(Integer id){
        buscarPorId(id); //404 se n existir
        repository.deleteById(id);
    }
}
