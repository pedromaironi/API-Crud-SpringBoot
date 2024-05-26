package com.pedromaironi.apicrud.api.controller.Products;

import com.pedromaironi.apicrud.api.repository.ProductsRepository;
import com.pedromaironi.apicrud.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/all")
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        try {
            Products savedProduct = productsRepository.save(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProduct(
            @PathVariable("id") int id,
            @RequestBody Products productDetails) {
        Optional<Products> productData = productsRepository.findById(id);

        if (productData.isPresent()) {
            Products existingProduct = productData.get();
            existingProduct.setNombre(productDetails.getNombre());
            existingProduct.setDescripcion(productDetails.getDescripcion());
            existingProduct.setPrecio(productDetails.getPrecio());
            existingProduct.setImagen(productDetails.getImagen());
            existingProduct.setId_categoria(productDetails.getId_categoria());
            existingProduct.setStock(productDetails.getStock());

            Products updatedProduct = productsRepository.save(existingProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id) {
        try {
            Optional<Products> product = productsRepository.findById(id);
            if (product.isPresent()) {
                productsRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
