package com.digikalspring.digikalspring.repository;

import com.digikalspring.digikalspring.model.Product;
import com.digikalspring.digikalspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


}
