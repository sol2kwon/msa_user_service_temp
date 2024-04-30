package com.userservice.userservice.user.vo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.userservice.userservice.user.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {
    private String email;
    private String name;
    private String userId;
    private List<ResponseOrder> orders;
}
