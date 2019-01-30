package com.taylor.cloud.service.impl;

import com.taylor.cloud.domain.ProductOrder;
import com.taylor.cloud.service.ProductOrderService;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient balancerClient;

  @Override
  public ProductOrder save(int userId, int productId) {

    balancerClient.choose("eureka-client-service");

    Map<String, Object> productMap = restTemplate
        .getForObject("http://eureka-client-service/api/v1/product/find?id="
            + productId, Map.class);

    ProductOrder productOrder = new ProductOrder();
    productOrder.setCreateTime(new Date());
    productOrder.setUserId(userId);
    productOrder.setTradeNo(UUID.randomUUID().toString());
    productOrder.setProductName(productMap.get("name").toString());
    productOrder.setPrice(Integer.parseInt(productMap.get("price").toString()));

    return productOrder;
  }
}
