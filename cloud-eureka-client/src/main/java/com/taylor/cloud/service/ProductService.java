package com.taylor.cloud.service;

import com.taylor.cloud.domain.Product;
import java.util.List;

public interface ProductService {

  List<Product> listProduct();

  Product findById(int id);
}
