package com.taylor.cloud.controller;

import com.taylor.cloud.domain.Product;
import com.taylor.cloud.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Value("${server.port}")
  private String port;

  /**
   * 获取所有商品列表
   */
  @RequestMapping("list")
  public Object list() {
    return productService.listProduct();
  }

  /**
   * 根据id查找商品详情
   */
  @RequestMapping("find")
  public Object findById(@RequestParam("id") int id) {
    Product product = productService.findById(id);
    Product result = new Product();
    BeanUtils.copyProperties(product, result);
    result.setName(product.getName() + " data from port : " + port);
    return result;
  }
}
