package com.zhuravel.controller;

import com.zhuravel.model.User;
import com.zhuravel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/users";
    private static final String SAVE_URL = "/save";
    private static final String DELETE_URL = "/delete";
    private static final String GET_BY_ID_URL = "/id";

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
//    @Operation(summary = "Return all available Users")
    public List<User> getAll(){
        LOG.debug("Received GET request to get all Users");

        return service.findAll();
    }

    @GetMapping(GET_BY_ID_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Return category by id")
    public User getById(@RequestParam Long id) {
        LOG.debug("Received GET request to get User with id[{}]", id);

        return service.findById(id);
    }

    @PostMapping(SAVE_URL)
//    @Operation(summary = "add User")
    public ResponseEntity<User> save(@RequestBody User user, BindingResult bindingResult) {
        LOG.debug("Received POST request to add new User");

        var newUser = service.save(user);

        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping(DELETE_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Delete User with provided identifier")
    public void deleteById(@RequestParam("id") Long id) {
        LOG.debug("Received DELETE request to delete User with id:[{}]", id);

        service.delete(id);
    }
}
