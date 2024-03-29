package com.userservice.userservice.user.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class GreetingVO {
    @Value("${greeting.message}")
    private String message;
}
