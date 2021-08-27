package com.summerschool.icecreamshop.configuration;

import com.summerschool.icecreamshop.model.domain.Product;
import com.summerschool.icecreamshop.model.dto.ProductDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        Converter<ProductDTO, Product> productConverter = context -> {
            ProductDTO s = context.getSource();
            Product d = new Product();
            d.setId(s.getId());
            d.setTitle(s.getTitle());
            d.setShortDescription(s.getShortDescription());
            d.setLongDescription(s.getLongDescription());
            d.setIngredients(s.getIngredients());
            d.setQuantity(s.getQuantity());
            d.setAlergens(s.getAlergens());
            d.setPrice(s.getPrice());
            d.setCurrency(s.getCurrency());
            d.setPhoto_urls(s.getPhoto_urls());
            d.setType(s.getType());
            return d;
        };

        modelMapper.addConverter(productConverter);
        return modelMapper;
    }
}
