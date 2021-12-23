package com.zhuravel.controller;

import com.zhuravel.model.Option;
import com.zhuravel.service.OptionService;
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
@RequestMapping(path = OptionController.BASE_URL)
public class OptionController {

    public static final String BASE_URL = "/options";
    private static final String SAVE_URL = "/save";
    private static final String DELETE_URL = "/delete";
    private static final String GET_BY_ID_URL = "/id";

    private static final Logger LOG = LoggerFactory.getLogger(OptionController.class);

    private final OptionService service;

    public OptionController(OptionService service) {
        this.service = service;
    }

    @GetMapping()
//    @Operation(summary = "Return all available Options")
    public List<Option> getAll(){
        LOG.debug("Received GET request to get all Options");

        return service.findAll();
    }

    @GetMapping(GET_BY_ID_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Return category by id")
    public Option getById(@RequestParam Long id) {
        LOG.debug("Received GET request to get Option with id[{}]", id);

        return service.findById(id);
    }

    @PostMapping(SAVE_URL)
//    @Operation(summary = "add Option")
    public ResponseEntity<Option> save(@RequestBody Option option, BindingResult bindingResult) {
        LOG.debug("Received POST request to add new Option");

        var newOption = service.save(option);

        return ResponseEntity.ok(newOption);
    }

    @DeleteMapping(DELETE_URL)
    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Delete Option with provided identifier")
    public void deleteById(@RequestParam("id") Long id) {
        LOG.debug("Received DELETE request to delete Option with id:[{}]", id);

        service.delete(id);
    }
}
