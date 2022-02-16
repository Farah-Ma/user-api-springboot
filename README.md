# user-api-springboot
A spring boot user Api.

## Index :pushpin:
- [About the project](#about)
- [Show_me_the_code](#code)

## About the project <a name="about"></a> :link:
Follow the technologies present in this project below:
- Java 11
- Spring Boot
- Database : maria DB version 10

## Show me the code <a name="code"></a> :computer:
```java
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
```


