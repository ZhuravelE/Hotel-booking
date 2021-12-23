package com.zhuravel.controller;

import com.zhuravel.model.RoomOption;
import com.zhuravel.service.RoomOptionsService;
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
@RequestMapping(path = RoomOptionController.BASE_URL)
public class RoomOptionController {

    public static final String BASE_URL = "/room-options";
    private static final String SAVE_URL = "/save";
    private static final String DELETE_URL = "/delete";
    private static final String GET_BY_ID_URL = "/id";

    private static final Logger LOG = LoggerFactory.getLogger(RoomOptionController.class);

    private final RoomOptionsService service;

    public RoomOptionController(RoomOptionsService service) {
        this.service = service;
    }

    @GetMapping()
//    @Operation(summary = "Return all available RoomOptions")
    public List<RoomOption> getAll(){
        LOG.debug("Received GET request to get all RoomOptions");

        return service.findAll();
    }

    @GetMapping(GET_BY_ID_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Return option by id")
    public RoomOption getById(@RequestParam Long id) {
        LOG.debug("Received GET request to get RoomOption with id[{}]", id);

        return service.findById(id);
    }

    @PostMapping(SAVE_URL)
//    @Operation(summary = "add RoomOption")
    public ResponseEntity<RoomOption> save(@RequestBody RoomOption roomOption, BindingResult bindingResult) {
        LOG.debug("Received POST request to add new RoomOption");

        var newRoomOption = service.save(roomOption);

        return ResponseEntity.ok(newRoomOption);
    }

    @DeleteMapping(DELETE_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Delete RoomOption with provided identifier")
    public void deleteById(@RequestParam("id") Long id) {
        LOG.debug("Received DELETE request to delete RoomOption with id:[{}]", id);

        service.delete(id);
    }
}
