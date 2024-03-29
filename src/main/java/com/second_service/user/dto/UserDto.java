package com.second_service.user.dto;

import com.second_service.user.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAt;
    private String encryptedPwd;
    private List<ResponseOrder> resOrder;
}
