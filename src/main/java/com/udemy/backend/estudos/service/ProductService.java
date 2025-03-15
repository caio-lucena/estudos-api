package com.udemy.backend.estudos.service;

import com.udemy.backend.estudos.model.Product;
import com.udemy.backend.estudos.repository.ProductRepository;
import com.udemy.backend.estudos.service.exceptions.ExceptionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired // inversão de controle
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){
        if (id > 0){
            return productRepository.findById(id);
        }
        else {
            throw new InputMismatchException("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }
    }

    public void deleteProduct(Integer id){
        if (id > 0){
            productRepository.deleteById(id);
        }
        else {
            throw new InputMismatchException("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }
    }

    public Product updateProduct(Integer id, Product product){

        Product productAux = new Product();

        productAux.setName(product.getName());
        productAux.setAmount(product.getAmount());
        productAux.setPrice(product.getPrice());
        productAux.setDescription(product.getDescription());

        if (id > 0) {
            productRepository.deleteById(id);
        }
        else {
            throw new ExceptionProductService("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }

        return productRepository.save(product);
    }

}
