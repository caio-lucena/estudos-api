package com.udemy.backend.estudos.repository;

import com.udemy.backend.estudos.model.Product;
import com.udemy.backend.estudos.model.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class ProductRepositoryOld {
    private List<Product> productList = new ArrayList<>();
    private Integer lastId = 0;

    public Product saveProduct(Product product){
        lastId++;
        product.setId(lastId);
        productList.add(product);

        return product;
    }

    public List<Product> getAllProducts(){
        return productList;
    }

        public Optional<Product> getProductById(Integer id){

        Optional<Product> optionalProduct = productList
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();

        if (!optionalProduct.isEmpty()){
            return optionalProduct;
        }
        else {
            throw new ResourceNotFoundException("Não foi possível encontrar o produto com o id " + id + " informado");
        }
    }

    public void deleteProduct(Integer id){
        productList.removeIf(x -> x.getId().equals(id));
    }

    public Product updateProduct(Product product){
        Optional<Product> productAux = getProductById(product.getId());

        if (!productAux.isEmpty()){
            deleteProduct(product.getId());
            productList.add(product);
        }
        else {
            throw new ResourceNotFoundException("Produto com o id " + product.getId() + " não foi encontrado para efetuar exclusão");
        }

        return product;
    }
}
