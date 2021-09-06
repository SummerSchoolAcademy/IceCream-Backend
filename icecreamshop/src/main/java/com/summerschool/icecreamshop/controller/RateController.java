package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.RateDTO;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.service.RateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static com.summerschool.icecreamshop.exception.Constants.RATE_NOT_FOUND;

@RestController
@RequestMapping("/ratings")
public class RateController {

    private RateService rateService;

    private ModelMapper modelMapper;


    @Autowired
    public RateController(RateService rateService, ModelMapper modelMapper) {
        this.rateService = rateService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<RateDTO> add(@Valid @RequestBody RateDTO rateDTO) {
        Rate rate = modelMapper.map(rateDTO, Rate.class);

        Rate savedRate = rateService.add(rate);
        if(savedRate==null)
        {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new RateDTO());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedRate, RateDTO.class));
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<RateDTO> update (@PathVariable("ratingId") Long ratingId, @RequestBody @Valid RateDTO rateDTO){

        Rate foundRate = rateService.get(ratingId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, RATE_NOT_FOUND));

        rateDTO.setId(foundRate.getId());
        Rate updatedRate = rateService.update(modelMapper.map(rateDTO,Rate.class),foundRate.getProduct());
        return ResponseEntity.ok(modelMapper.map(updatedRate,RateDTO.class));

    }
}