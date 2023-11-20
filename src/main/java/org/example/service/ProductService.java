package org.example.service;

import org.example.dto.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Transactional
    public void saveProductInfo(){
          for (int i = 1; i <= 10; i++) {
              Product product = new Product();
              product.setName("test" + i);
              productRepository.saveProduct(product);
              if ( i == 7 ) {
                  throw new RuntimeException("Something went wrong");
              }
          }
    }
}