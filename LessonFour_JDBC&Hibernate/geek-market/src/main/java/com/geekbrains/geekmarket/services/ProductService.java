package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Product;
import com.geekbrains.geekmarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
       // Product products = productRepository.findOneByPrice(26000.00);
      //  productRepository.
      //  productRepository.delete();

     //   Product product = productRepository.myQuery(1L);
//        List<Product> products = productRepository.findAllByPriceBetween(20000.0, 40000.0);
//        Page<Product> pr = productRepository.findAll(PageRequest.of(1,1));
//        System.out.println(pr);

        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "Category"));
        List<Product> products = (List<Product>) productRepository.findAll(sort);
//
        System.out.println(products);

//        List<Product> products = new ArrayList<>();
//        products.add(productRepository.myQuery(1L));
        return products;
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }
}
