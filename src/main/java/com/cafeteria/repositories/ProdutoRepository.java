package com.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteria.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
 
}
