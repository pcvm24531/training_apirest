package com.adaps.water.controller;

import com.adaps.water.dto.UserDto;
import com.adaps.water.service.UserService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> newUser(@RequestBody @Valid UserDto userDto, BindingResult result) throws Exception {
        return userService.create(userDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) throws NotFoundException {
        return userService.read(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) throws Exception {
        return userService.update(userDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) throws NotFoundException {
        userService.delete(id);
    }

    @GetMapping(value = "/list")
    public List<UserDto> getList() {
        return userService.list();
    }
}
