package com.pedromaironi.apicrud.api.controller.Products;

import com.pedromaironi.apicrud.api.repository.ProductsRepository;
import com.pedromaironi.apicrud.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/getProducts")
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

}
