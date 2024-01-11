package com.aldo.authentication.praticaAutenticacao.Controller;

import com.aldo.authentication.praticaAutenticacao.Repository.ProductRepository;
import com.aldo.authentication.praticaAutenticacao.domain.product.ProductDomain;
import com.aldo.authentication.praticaAutenticacao.domain.product.ProductRequestDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProductRequestDTO productData){
        ProductDomain newProduct = new ProductDomain(productData);
        this.productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllProducts(){
        var products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}
