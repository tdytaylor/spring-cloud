package com.taylor.cloud.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.taylor.cloud.domain.ProductOrder;
import com.taylor.cloud.service.ProductClient;
import com.taylor.cloud.service.ProductOrderService;
import com.taylor.cloud.utils.JsonUtils;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

  @Autowired
  private ProductClient productClient;


  @Override
  public ProductOrder save(int userId, int productId) {
    String response = productClient.findById(productId);
    JsonNode jsonNode = JsonUtils.str2JsonNode(response);

    ProductOrder productOrder = new ProductOrder();
    productOrder.setCreateTime(new Date());
    productOrder.setUserId(userId);
    productOrder.setTradeNo(UUID.randomUUID().toString());
    productOrder.setProductName(jsonNode.get("name").toString());
    productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
    return productOrder;
  }
}
