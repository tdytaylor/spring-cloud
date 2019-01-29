package com.taylor.cloud.service.impl;

import com.taylor.cloud.domain.ProductOrder;
import com.taylor.cloud.service.ProductOrderService;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public ProductOrder save(int userId, int productId) {

    Object obj = restTemplate
        .getForObject("http://product-service/api/v1/product/find?id="
            + productId, Object.class);
    
    System.out.println(obj);

    ProductOrder productOrder = new ProductOrder();
    productOrder.setCreateTime(new Date());
    productOrder.setUserId(userId);
    productOrder.setTradeNo(UUID.randomUUID().toString());

    return productOrder;
  }
}
