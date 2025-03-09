package com.udemy.backend.estudos.service;

import com.udemy.backend.estudos.model.Product;
import com.udemy.backend.estudos.repository.ProductRepositoryOld;
import com.udemy.backend.estudos.service.exceptions.ExceptionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired // inversão de controle
    private ProductRepositoryOld productRepositoryOld;

    public Product saveProduct(Product product){
        return productRepositoryOld.saveProduct(product);
    }

    public List<Product> getAllProducts(){
        return productRepositoryOld.getAllProducts();
    }

    public Optional<Product> getProductById(Integer id){
        if (id > 0){
            return productRepositoryOld.getProductById(id);
        }
        else {
            throw new InputMismatchException("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }
    }

    public void deleteProduct(Integer id){
        if (id > 0){
            productRepositoryOld.deleteProduct(id);
        }
        else {
            throw new InputMismatchException("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }
    }

    public Product updateProduct(Integer id, Product product){

        if (id > 0) {
            product.setId(id);
        }
        else {
            throw new ExceptionProductService("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }

        return productRepositoryOld.updateProduct(product);
    }

}
