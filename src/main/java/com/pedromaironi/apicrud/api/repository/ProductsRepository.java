package com.pedromaironi.apicrud.api.repository;

import com.pedromaironi.apicrud.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
