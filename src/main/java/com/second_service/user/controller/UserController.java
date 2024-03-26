package com.second_service.user.controller;

import com.second_service.user.dto.UserDto;
import com.second_service.user.service.UserService;
import com.second_service.user.vo.GreetingVO;
import com.second_service.user.vo.RequestUser;
import com.second_service.user.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GreetingVO greeting;

    @GetMapping("/heath_check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); //정확하게

        UserDto userDto = mapper.map(user,UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        //성공(201)
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
