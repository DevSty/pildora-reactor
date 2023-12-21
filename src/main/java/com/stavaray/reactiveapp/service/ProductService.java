package com.stavaray.reactiveapp.service;

import com.stavaray.reactiveapp.model.Product;
import com.stavaray.reactiveapp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }
 
    public Mono<Void> deleteById(Long id){
        return this.productRepository.findById(id)
                .flatMap(this.productRepository::delete);
    }
    
}
