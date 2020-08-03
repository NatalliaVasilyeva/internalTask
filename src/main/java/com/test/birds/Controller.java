package com.test.birds;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.birds.converter.ColorEnumConverter;
import com.test.birds.converter.SpeciesEnumConverter;
import com.test.birds.entity.Bird;
import com.test.birds.entity.enums.Color;
import com.test.birds.entity.enums.Species;
import com.test.birds.service.BirdService;
import com.test.birds.validation.ValidateParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    private BirdService birdService;
    private ValidateParameters validateParameters;


    @Autowired
    public void setBirdService(BirdService birdService) {
        this.birdService = birdService;
    }

    @Autowired
    public void setValidateParameters(ValidateParameters validateParameters) {
        this.validateParameters = validateParameters;
    }

    @RequestMapping(
            value = "/birds",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getBirds(@RequestParam MultiValueMap<String, String> params,
                                   @RequestParam(value = "attribute", required = false) String attribute,
                                   @RequestParam(value = "order", required = false) String order,
                                   @RequestParam(value = "offset", required = false) @PositiveOrZero Integer offset,
                                   @RequestParam(value = "limit", required = false) @PositiveOrZero Integer limit) throws JsonProcessingException {

        if (attribute != null) {
            validateParameters.validateAttribute(attribute);
        }
        if (order != null) {
            validateParameters.validateTypeOfSort(order);
        }
        if (limit == null && offset != null) {
            throw new IllegalArgumentException();
        }

        List<Bird> birds = new ArrayList<>();
        if (params.isEmpty()) {
            birds = birdService.findAll();
        } else if (params.size() == 4) {
            birds = birdService.findAllAndSortByAttributeWithLimit(attribute, order, offset, limit);
        } else if (params.size() == 3) {
            birds = birdService.findAllAndSortByAttributeWithLimit(attribute, order, 0, limit);
        } else if (params.size() == 2) {
            if (attribute != null && order != null) {
                birds = birdService.findAllAndSort(attribute, order);
            } else if (limit != null && offset != null) {
                birds = birdService.findByAttributeWithOffsetAndLimit(offset, limit);
            }
        } else if (params.size() == 1) {
            if (attribute != null) {
                birds = birdService.findAllAndSort(attribute, "asc");
            } else if (limit != null) {
                birds = birdService.findAllWithLimit(limit);
            }
        } else {
            throw new IllegalArgumentException();
        }


        return ResponseEntity.ok().body(new ObjectMapper().writeValueAsString(birds));
    }


    @RequestMapping(
            value = "/birds",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createBirds(@ModelAttribute Bird bird) throws JsonProcessingException {

        List<String> errors = validateParameters.validateRequestBody(bird);
        if (errors != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ObjectMapper().writeValueAsString(errors));
        }

        Bird checkedBird = birdService.findById(bird.getName());

        if(checkedBird!=null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bird with such name is present in database. Please, provide other name and repeat request");
        }

        return ResponseEntity.ok().body(new ObjectMapper().writeValueAsString(birdService.createBird(bird)));
    }




    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Color.class, new ColorEnumConverter());
        webdataBinder.registerCustomEditor(Species.class, new SpeciesEnumConverter());
    }

}
