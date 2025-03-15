package com.udemy.backend.estudos.repository;

import com.udemy.backend.estudos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // injeção de dependência
public interface ProductRepository extends JpaRepository <Product, Integer> {

}
