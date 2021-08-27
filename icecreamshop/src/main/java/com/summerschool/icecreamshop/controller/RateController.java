package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.exception.InvalidISBNException;
import com.summerschool.icecreamshop.service.RateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.RateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import static com.summerschool.icecreamshop.exception.Constants.RATE_NOT_FOUND;

import javax.validation.Valid;

@RestController
@RequestMapping("/ratings")
public class RateController {

    @Autowired
    private RateService rateService;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/{ratingId}")
    public ResponseEntity<RateDTO> update (@PathVariable("ratingId") Long ratingId, @RequestBody @Valid RateDTO rateDTO) throws InvalidISBNException{

        Rate foundRate = rateService.get(ratingId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, RATE_NOT_FOUND));

        rateDTO.setId(foundRate.getId());
        Rate updatedRate = rateService.update(modelMapper.map(rateDTO,Rate.class),foundRate.getProduct());
        return ResponseEntity.ok(modelMapper.map(updatedRate,RateDTO.class));

    }
}