package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.BasketDTO;
import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.service.BasketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import static com.summerschool.icecreamshop.exception.Constants.RATE_NOT_FOUND;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/{basketId}")
    public ResponseEntity<BasketDTO> update (@PathVariable("basketId") Long basketId, @RequestBody @Valid BasketDTO basketDTO){

        Basket foundBasket = basketService.get(basketId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, RATE_NOT_FOUND));

        basketDTO.setId(foundBasket.getId());
        Basket updatedBasket = basketService.update(modelMapper.map(basketDTO, Basket.class),foundBasket.getBasketProduct());
        return ResponseEntity.ok(modelMapper.map(updatedBasket, BasketDTO.class));

    }
}
