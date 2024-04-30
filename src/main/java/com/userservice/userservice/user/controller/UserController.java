package com.userservice.userservice.user.controller;

import com.userservice.userservice.user.dto.UserDto;
import com.userservice.userservice.user.repository.UserEntity;
import com.userservice.userservice.user.service.UserService;
import com.userservice.userservice.user.vo.GreetingVO;

import com.userservice.userservice.user.vo.RequestUser;
import com.userservice.userservice.user.vo.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {
    private final UserService userService;
    private final Environment env;
 /*   @Value("${server.port}")
    private String serverPort;

  */


    @Autowired
    public UserController(UserService userService, Environment env){
        this.env = env;
        this.userService = userService;
    }

    @Autowired
    private GreetingVO greeting;

    @GetMapping("/heath_check")
    public String status(){
        return String.format("It's Working in User Service"
                +", port(local.server.port)=" +env.getProperty("local.server.port")
                +", port(server.port)=" +env.getProperty("server.port")
                +", token secret" +env.getProperty("token.secret")
                +", comment!!!!!=" +env.getProperty("test.comment")

         );
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

    /**
     * [전체 사용자 조회]
     * 전체 사용자를 조회한다.
     * 조회된 사용자를 ResponseUser에 담아 상태코드 값과 함께 반환한다.
     * */
    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseUser.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * [사용자 정보와 주문정보 조회]
     * UserId 값을 가지고 사용자 정보를 조회한다.
     * 사용자 정보가 없다면 "User not found"를 띄운다.
     * 조회된 사용자 정보를 최종 ResponseUser으로 변경하여 반환한다.(사용자정보, 주문정보)
     * */
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUsers(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUserByUserId(userId);
        log.info("userDto {}",userDto);
        ModelMapper mapper = new ModelMapper();
        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        log.info("responseUser {}",responseUser);
        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }
}
