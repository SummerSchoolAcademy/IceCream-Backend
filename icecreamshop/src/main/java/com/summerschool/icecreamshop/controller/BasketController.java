package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.BasketDTO;
import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.service.BasketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private BasketService basketService;

    private ModelMapper modelMapper;

    @Autowired
    public BasketController(BasketService basketService, ModelMapper modelMapper) {
        this.basketService = basketService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<BasketDTO> add(@Valid @RequestBody BasketDTO basketDTO) {
        Basket basket = modelMapper.map(basketDTO, Basket.class);

        Basket savedBasket = basketService.add(basket);
        if(savedBasket == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BasketDTO());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedBasket, BasketDTO.class));
    }
}
