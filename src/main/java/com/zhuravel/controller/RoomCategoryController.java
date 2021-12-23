package com.zhuravel.controller;

import com.zhuravel.model.RoomCategory;
import com.zhuravel.service.RoomCategoryService;
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
@RequestMapping(path = RoomCategoryController.BASE_URL)
public class RoomCategoryController {

    public static final String BASE_URL = "/room-categories";
    private static final String SAVE_URL = "/save";
    private static final String DELETE_URL = "/delete";
    private static final String GET_BY_ID_URL = "/id";

    private static final Logger LOG = LoggerFactory.getLogger(RoomCategoryController.class);

    private final RoomCategoryService service;

    public RoomCategoryController(RoomCategoryService service) {
        this.service = service;
    }

    @GetMapping()
//    @Operation(summary = "Return all available RoomCategories")
    public List<RoomCategory> getAll(){
        LOG.debug("Received GET request to get all RoomCategories");

        return service.findAll();
    }

    @GetMapping(GET_BY_ID_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Return category by id")
    public RoomCategory getById(@RequestParam Long id) {
        LOG.debug("Received GET request to get RoomCategory with id[{}]", id);

        return service.findById(id);
    }

    @PostMapping(SAVE_URL)
//    @Operation(summary = "add RoomCategory")
    public ResponseEntity<RoomCategory> save(@RequestBody RoomCategory roomCategory, BindingResult bindingResult) {
        LOG.debug("Received POST request to add new RoomCategory");

        var newRoomCategory = service.save(roomCategory);

        return ResponseEntity.ok(newRoomCategory);
    }

    @DeleteMapping(DELETE_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Delete RoomCategory with provided identifier")
    public void deleteById(@RequestParam("id") Long id) {
        LOG.debug("Received DELETE request to delete RoomCategory with id:[{}]", id);

        service.delete(id);
    }
}
