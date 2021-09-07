package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.service.RateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.dto.RateDTO;
import org.springframework.beans.factory.annotation.Autowired;

import static com.summerschool.icecreamshop.exception.Constants.PRODUCT_NOT_FOUND;
import static com.summerschool.icecreamshop.exception.Constants.RATE_NOT_FOUND;
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
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;
import static com.summerschool.icecreamshop.exception.Constants.*;

@RestController
@RequestMapping("/ratings")
public class RateController {

    private final RateService rateService;

    private final ModelMapper modelMapper;


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

    @GetMapping(path = "/rates/{productID}")
    public ResponseEntity<List<RateDTO>> get(@PathVariable("productId") Long id) {
        Rate rate = rateService.getByRateId(id);
                //verify if rate is null
                //if null
                //then throw exception
                //else throw ok
                if(rate == null){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);}
                else
                    return
                ResponseEntity.ok(rateService.getByRateId(id)
                                .stream()
                                .map(product -> modelMapper.map(rate, RateDTO.class))
                                .collect(Collectors.toList()));
    }
}
