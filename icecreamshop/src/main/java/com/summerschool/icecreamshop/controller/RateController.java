package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.RateDTO;
import com.summerschool.icecreamshop.service.RateService;
import com.summerschool.icecreamshop.model.Rate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedRate, RateDTO.class));
    }
}
