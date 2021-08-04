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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto newUser(@Valid @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getUser(@PathVariable Long id) throws NotFoundException {
        return userService.read(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) throws Exception {
        return userService.update(userDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) throws NotFoundException {
        userService.delete(id);
    }

    @GetMapping()
    public List<UserDto> getList() {
        return userService.list();
    }
}
