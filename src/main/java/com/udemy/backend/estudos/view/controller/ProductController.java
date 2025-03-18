package com.udemy.backend.estudos.view.controller;

import com.udemy.backend.estudos.model.Product;
import com.udemy.backend.estudos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/cadastrarProduto")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/obterTodosProdutos")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("obterProdutoPorId/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @DeleteMapping("deletarPorId/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

    @PutMapping("atualizarProdutoPorId/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

}
