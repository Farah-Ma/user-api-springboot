package com.mathaliapp.hub.controller;

import com.mathaliapp.hub.model.User;
import com.mathaliapp.hub.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/users")
@Api(value = "User Management System", description = "Operations for users Management System")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value = "Get users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "Get user by Id")
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user= userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "add user ")
    @PostMapping(value = "/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newuser= userService.addUser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @ApiOperation(value = "update user ")
    @PutMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateduser= userService.updateUser(user);
        return new ResponseEntity<>(updateduser, HttpStatus.OK);
    }

    @ApiOperation(value = "delete user by Id")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long id){
         userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "delete user by Id")
    @DeleteMapping(value = "/deleteByUserIdent/{userIdent}")
    public ResponseEntity<User> deleteUserByUserIdent(@PathVariable("userIdent") String userIdent){
        userService.deleteUserByUserIdent(userIdent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
