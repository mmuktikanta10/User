package com.shopping.user.controller;

import com.shopping.user.model.request.UserRequestModel;
import com.shopping.user.model.request.UserUpdateRequest;
import com.shopping.user.model.response.UserResponseModel;
import com.shopping.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponseModel> register(@RequestBody @Valid UserRequestModel request) {
        Optional<UserResponseModel> userResponse = userService.registerUser(request);
        return ResponseEntity.ok(userResponse.get());
    }

    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponseModel> updateUser( @PathVariable("id") int id,@RequestBody @Valid  UserUpdateRequest request) {
        return ResponseEntity.ok( userService.updateUser(id,request).get());
    }

    @GetMapping(value = "/{email}",  produces = "application/json")
    public ResponseEntity<UserResponseModel> findUser(@PathVariable("email") String email) {
        Optional<UserResponseModel> userResponse = userService.searchUser(email);
        return ResponseEntity.ok(userResponse.get());
    }
}
