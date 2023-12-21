package com.stavaray.reactiveapp.controller;

import com.stavaray.reactiveapp.model.Product;
import com.stavaray.reactiveapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/productos")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> create(@RequestBody Product product) {
        return productService.save(product);
        		
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> update(@PathVariable Long id,
                                                @RequestBody Product product) {
        return productService.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setNombre(product.getNombre());
                    existingProduct.setDescripcion(product.getDescripcion());
                    existingProduct.setEstado(product.getEstado());
                    existingProduct.setPrecio(product.getPrecio());
                    return productService.save(existingProduct);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }
}
