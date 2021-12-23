package com.zhuravel.controller;

import com.zhuravel.model.Room;
import com.zhuravel.service.RoomService;
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
@RequestMapping(path = RoomController.BASE_URL)
public class RoomController {

    public static final String BASE_URL = "/rooms";
    private static final String SAVE_URL = "/save";
    private static final String DELETE_URL = "/delete";
    private static final String GET_BY_ID_URL = "/id";

    private static final Logger LOG = LoggerFactory.getLogger(RoomController.class);

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping()
//    @Operation(summary = "Return all available Rooms")
    public List<Room> getAll(){
        LOG.debug("Received GET request to get all Rooms");

        return service.findAll();
    }

    @GetMapping(GET_BY_ID_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Return category by id")
    public Room getById(@RequestParam Long id) {
        LOG.debug("Received GET request to get Room with id[{}]", id);

        return service.findById(id);
    }

    @PostMapping(SAVE_URL)
//    @Operation(summary = "add Room")
    public ResponseEntity<Room> save(@RequestBody Room room, BindingResult bindingResult) {
        LOG.debug("Received POST request to add new Room");

        var newRoom = service.save(room);

        return ResponseEntity.ok(newRoom);
    }

    @DeleteMapping(DELETE_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Delete Room with provided identifier")
    public void deleteById(@RequestParam("id") Long id) {
        LOG.debug("Received DELETE request to delete Room with id:[{}]", id);

        service.delete(id);
    }
}
