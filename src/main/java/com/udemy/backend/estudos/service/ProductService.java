package com.udemy.backend.estudos.service;

import com.udemy.backend.estudos.model.Product;
import com.udemy.backend.estudos.model.exceptions.ResourceNotFoundException;
import com.udemy.backend.estudos.repository.ProductRepository;
import com.udemy.backend.estudos.service.exceptions.ExceptionProductService;
import com.udemy.backend.estudos.shared.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired // inversão de controle
    private ProductRepository productRepository;

    public ProductDto saveProduct(ProductDto productDto){
        productDto.setId(null);
        return productRepository.save(product);
    }

    public List<ProductDto> getAllProducts(){
        List<Product> productList = productRepository.findAll();

        return productList
                .stream()
                .map(x -> new ModelMapper().map(x, ProductDto.class))
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> getProductById(Integer id){

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (id <= 0) {
            throw new ResourceNotFoundException("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }

        if (!optionalProduct.isEmpty()){
            ProductDto productDto = new ModelMapper().map(optionalProduct.get(), ProductDto.class);
            return Optional.of(productDto);
        }
        else{
            throw new ResourceNotFoundException("Produto com id: " + id + " não foi encontrado");
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

    public ProductDto updateProduct(Integer id, ProductDto productDto){

        Product productAux = new Product();

        productAux.setName(productDto.getName());
        productAux.setAmount(productDto.getAmount());
        productAux.setPrice(productDto.getPrice());
        productAux.setDescription(productDto.getDescription());

        if (id > 0) {
            productRepository.deleteById(id);
        }
        else {
            throw new ExceptionProductService("É preciso informar um ID válido. Apenas números inteiros maiores que zero são aceitos");
        }

        return productRepository.save(productAux);
    }

}
