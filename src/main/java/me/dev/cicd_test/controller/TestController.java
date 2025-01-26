package me.dev.cicd_test.controller;

import lombok.RequiredArgsConstructor;
import me.dev.cicd_test.dto.JoinDto;
import me.dev.cicd_test.entity.User;
import me.dev.cicd_test.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<User>joinProcess(@RequestBody JoinDto joinDto){
        User user= userService.join(joinDto);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findProcess(@PathVariable("id") Long id){
        try {
            User user = userService.findUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
