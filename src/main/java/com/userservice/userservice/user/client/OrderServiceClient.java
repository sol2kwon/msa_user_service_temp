package com.userservice.userservice.user.client;

import com.userservice.userservice.user.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderServiceClient {

   // @GetMapping("/order-service/{userId}/order_ng") //에러처리 테스트
    @GetMapping("/order-service/{userId}/orders")
    List<ResponseOrder> getOrders (@PathVariable String userId);

}
