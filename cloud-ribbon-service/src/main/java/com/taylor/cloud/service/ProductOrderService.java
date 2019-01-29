package com.taylor.cloud.service;

import com.taylor.cloud.domain.ProductOrder;

/**
 * 订单业务类
 */
public interface ProductOrderService {

  /**
   * 下单接口
   */
  ProductOrder save(int userId, int productId);
}
