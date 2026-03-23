package com.gp.gerenciamentoDeProdutos.Repositories;

import com.gp.gerenciamentoDeProdutos.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
