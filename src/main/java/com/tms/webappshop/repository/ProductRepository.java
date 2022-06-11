package com.tms.webappshop.repository;

import com.tms.webappshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
