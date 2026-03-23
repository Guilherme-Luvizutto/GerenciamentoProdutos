package com.gp.gerenciamentoDeProdutos.Services;

import com.gp.gerenciamentoDeProdutos.Models.ProdutoModel;
import com.gp.gerenciamentoDeProdutos.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public ProdutoModel salvarProduto(ProdutoModel produtoModel) {
        return repository.save(produtoModel);
    }

    public ProdutoModel findById(Long id) {
        return repository.findById(id).get();
    }

    public List<ProdutoModel> findAll() {
        return repository.findAll();
    }

    public void deletarProduto(Long id) {
        repository.deleteById(id);
    }


}
