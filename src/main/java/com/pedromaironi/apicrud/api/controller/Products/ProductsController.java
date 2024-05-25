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

    @GetMapping("/all")
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") Double precio,
            @RequestParam("imagen") String imagen,
            @RequestParam("id_categoria") Integer id_categoria,
            @RequestParam("stock") Double stock) {
        try {
            Products product = new Products();
            product.setNombre(nombre);
            product.setDescripcion(descripcion);
            product.setPrecio(precio);
            product.setImagen(imagen);
            product.setId_categoria(id_categoria);
            product.setStock(stock);

            Products savedProduct = productsRepository.save(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
