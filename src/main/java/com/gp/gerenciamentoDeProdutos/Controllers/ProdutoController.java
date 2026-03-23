package com.gp.gerenciamentoDeProdutos.Controllers;

import com.gp.gerenciamentoDeProdutos.Models.ProdutoModel;
import com.gp.gerenciamentoDeProdutos.Repositories.ProdutoRepository;
import com.gp.gerenciamentoDeProdutos.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.salvarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(produtoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> request = produtoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> findById(@PathVariable Long id) {
        ProdutoModel request = produtoService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }


}
